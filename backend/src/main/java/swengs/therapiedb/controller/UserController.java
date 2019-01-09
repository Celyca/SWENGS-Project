package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swengs.therapiedb.dto.UserDTO;
import swengs.therapiedb.facade.UserFacade;
import swengs.therapiedb.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/dto/users")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("{id}")
    UserDTO getById(@PathVariable Long id) {
        return userFacade.getById(id);
    }

    @PostMapping("{id}")
    UserDTO create(@PathVariable Long id, @RequestBody @Valid UserDTO dto) {
        return userFacade.create(id, dto);
    }

    @PutMapping("{id}")
    UserDTO update(@RequestBody @Valid UserDTO dto, @PathVariable Long id) {
        return userFacade.update(id, dto);
    }
}
