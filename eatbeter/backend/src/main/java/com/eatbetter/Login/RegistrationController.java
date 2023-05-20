package com.eatbetter.Login;

import com.eatbetter.User.User;
import com.eatbetter.User.UserDto;
import com.eatbetter.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;
    @PostMapping("/register")
    public void register(@RequestBody UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRoles(userDto.getRoles());
        user.setBirthDate(userDto.getBirthDate());
        userService.save(user);
    }
}
