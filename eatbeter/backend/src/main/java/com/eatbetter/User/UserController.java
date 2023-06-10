package com.eatbetter.User;

import com.eatbetter.DietGoal.DietGoal;
import com.eatbetter.DietGoal.DietGoalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final DietGoalService dietGoalService;


    @GetMapping("user/dietGoal")
    public ResponseEntity<String> dietGoal(Principal principal){
        User user = userService.findByPrincipal(principal).orElseThrow();
        DietGoal dietGoal =  dietGoalService.getDietGoal(user);
        return ResponseEntity.ok(dietGoal.toString());
    }

    @PostMapping("user/edit")
    public ResponseEntity<String> editUser(Principal principal, @RequestBody UserEditDto userEditDto){
        try {
            userService.editUser(userEditDto, principal);
            return ResponseEntity.ok("User edited successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
