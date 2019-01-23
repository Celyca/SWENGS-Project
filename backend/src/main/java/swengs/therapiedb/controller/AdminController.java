package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swengs.therapiedb.dto.AuthenticationDTO;
import swengs.therapiedb.dto.UserDTO;
import swengs.therapiedb.facade.AuthenticationFacade;
import swengs.therapiedb.facade.UserFacade;
import swengs.therapiedb.model.user.User;
import swengs.therapiedb.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/dto/admin")
public class AdminController {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    // ---------------------------------------------------------------------------------
    @GetMapping("/users")
    ResponseEntity<List<AuthenticationDTO>> getAllUsers() {
    // ---------------------------------------------------------------------------------

        List<User> entities = userService.findAll();
        if (entities == null || !entities.iterator().hasNext()) {
            return new ResponseEntity<List<AuthenticationDTO>>(HttpStatus.NO_CONTENT);
        }

        List<AuthenticationDTO> dtos = authenticationFacade.getAll();
        return new ResponseEntity<List<AuthenticationDTO>>(dtos,HttpStatus.OK);
    }

    // ---------------------------------------------------------------------------------
    @GetMapping("/users/{id}")
    ResponseEntity<AuthenticationDTO> getUserById(@PathVariable Long id) {
    // ---------------------------------------------------------------------------------

        if (!userService.findById(id).isPresent()) {
            return new ResponseEntity<AuthenticationDTO>(HttpStatus.NOT_FOUND);
        }

        AuthenticationDTO dto = authenticationFacade.getById(id);
        return new ResponseEntity<AuthenticationDTO>(dto, HttpStatus.OK);
    }

    // ---------------------------------------------------------------------------------
    @DeleteMapping("/users/{id}")
    ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
    // ---------------------------------------------------------------------------------

        if (!userService.findById(id).isPresent()) {
            return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
        }

        userFacade.delete(id);
        return new ResponseEntity<UserDTO>(HttpStatus.NO_CONTENT);
    }
}
