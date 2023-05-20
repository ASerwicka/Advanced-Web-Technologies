package com.eatbetter.Login;

import com.eatbetter.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Component
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/loginSuccess")
    public ResponseEntity<String> login(Principal principal){
        System.out.println(principal.getName());
        return ResponseEntity.ok("Login successful");
    }


}
