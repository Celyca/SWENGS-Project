package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import swengs.therapiedb.dto.AuthenticationDTO;
import swengs.therapiedb.facade.AuthenticationFacade;
import swengs.therapiedb.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/dto/authentication")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationFacade authenticationFacade;

    // ---------------------------------------------------------------------------------
    @PostMapping("/users")
    ResponseEntity<AuthenticationDTO> create(@RequestBody @Valid AuthenticationDTO dto, UriComponentsBuilder ucBuilder) {
    // ---------------------------------------------------------------------------------

        AuthenticationDTO result = authenticationFacade.create(dto);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/users/{id}").buildAndExpand(result.getId()).toUri());
        return new ResponseEntity<AuthenticationDTO>(headers, HttpStatus.CREATED);
    }

    // ---------------------------------------------------------------------------------
    @PutMapping("/users/{id}")
    ResponseEntity<AuthenticationDTO> update(@RequestBody @Valid AuthenticationDTO dto, @PathVariable Long id) {
    // ---------------------------------------------------------------------------------

        if (!userService.findById(id).isPresent()) {
            return new ResponseEntity<AuthenticationDTO>(HttpStatus.NOT_FOUND);
        }

        authenticationFacade.update(id, dto);
        return new ResponseEntity<AuthenticationDTO>(HttpStatus.NO_CONTENT);
    }

    // ---------------------------------------------------------------------------------
    @GetMapping("/auth")
    ResponseEntity<AuthenticationDTO> getAuth() {
    // ---------------------------------------------------------------------------------
        AuthenticationDTO result = authenticationFacade.getAuth();
        if (result == null) {
            return new ResponseEntity<AuthenticationDTO>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<AuthenticationDTO>(result, HttpStatus.OK);
    }
}
