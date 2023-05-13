package com.eatbetter.Controller;

import com.eatbetter.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
    public String login(Principal principal){
        //userService.saveOauth2User(user);
        System.out.println(principal);
        //System.out.println(user.getAttribute("id").toString());
        return "redirect:/dupa";
    }


}
