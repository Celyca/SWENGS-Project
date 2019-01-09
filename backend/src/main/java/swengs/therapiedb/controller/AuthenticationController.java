package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swengs.therapiedb.dto.AuthenticationDTO;
import swengs.therapiedb.dto.UserDTO;
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

    @GetMapping("/users/{id}")
    AuthenticationDTO getById(@PathVariable Long id) {
        return authenticationFacade.getById(id);
    }

    @PostMapping("/users")
    AuthenticationDTO create(@RequestBody @Valid AuthenticationDTO dto) {
        return authenticationFacade.create(dto);
    }

    @PutMapping("/users/{id}")
    AuthenticationDTO update(@RequestBody @Valid AuthenticationDTO dto, @PathVariable Long id) {
        return authenticationFacade.update(id, dto);
    }

    @GetMapping("/auth")
    AuthenticationDTO getAuth() {
        return authenticationFacade.getAuth();
    }
}
