package swengs.therapiedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swengs.therapiedb.service.UserService;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    String getAuthentication() {
        return userService.getAuthentication();
    }
}
