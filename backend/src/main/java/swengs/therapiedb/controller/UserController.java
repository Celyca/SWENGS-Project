package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swengs.therapiedb.dto.UserDTO;
import swengs.therapiedb.facade.UserFacade;
import swengs.therapiedb.service.UserService;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("/dto/users/{id}")
    UserDTO getById(@PathVariable Long id) {
        return userFacade.getById(id);
    }

    @PostMapping("/dto/users")
    UserDTO create(@RequestBody @Valid UserDTO dto) {
        return userFacade.create(dto);
    }

    @PutMapping("/dto/users/{id}")
    UserDTO update(@RequestBody @Valid UserDTO dto, @PathVariable Long id) {
        return userFacade.update(id, dto);
    }
}
