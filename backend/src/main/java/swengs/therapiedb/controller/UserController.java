package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import swengs.therapiedb.dto.UserDTO;
import swengs.therapiedb.facade.UserFacade;
import swengs.therapiedb.model.user.User;
import swengs.therapiedb.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dto/users")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private UserService userService;

    // ---------------------------------------------------------------------------------
    @GetMapping("{id}")
    ResponseEntity<UserDTO> getById(@PathVariable Long id) {
    // ---------------------------------------------------------------------------------
        if (!userService.findById(id).isPresent()) {
            return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
        }

        UserDTO dto = userFacade.getById(id);
        return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
    }

    // ---------------------------------------------------------------------------------
    @PostMapping("{id}")
    ResponseEntity<UserDTO> create(@PathVariable Long id, @RequestBody @Valid UserDTO dto, UriComponentsBuilder ucBuilder) {
    // ---------------------------------------------------------------------------------

        UserDTO result = userFacade.create(id, dto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/users/{id}").buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<UserDTO>(headers, HttpStatus.CREATED);
    }

    // ---------------------------------------------------------------------------------
    @PutMapping("{id}")
    ResponseEntity<UserDTO> update(@RequestBody @Valid UserDTO dto, @PathVariable Long id) {
    // ---------------------------------------------------------------------------------

        if (!userService.findById(id).isPresent()) {
            return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
        }

        userFacade.update(id, dto);
        return new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT);
    }

    // ---------------------------------------------------------------------------------
    @GetMapping("/employee/")
    ResponseEntity<List<UserDTO>> getAllUsersByEmployee() {
        // ---------------------------------------------------------------------------------

        List<User> entities = userService.findByEmployee();
        if (entities == null || !entities.iterator().hasNext()) {
            return new ResponseEntity<List<UserDTO>>(HttpStatus.NO_CONTENT);
        }

        List<UserDTO> dtos = userFacade.getAllByEmployee();
        return new ResponseEntity<List<UserDTO>>(dtos,HttpStatus.OK);
    }
}
