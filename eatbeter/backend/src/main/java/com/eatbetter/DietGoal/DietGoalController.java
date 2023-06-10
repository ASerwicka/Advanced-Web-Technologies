package com.eatbetter.DietGoal;

import com.eatbetter.User.User;
import com.eatbetter.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
public class DietGoalController {
    private final DietGoalService dietGoalService;
    private final UserService userService;


    @PostMapping("/dietGoal/add")
    public ResponseEntity<String> addDietGoal(Principal principal, @RequestBody DietGoalDto dietGoalDto){
        User dietetician = userService.findByPrincipal(principal).orElseThrow();
        dietGoalService.addDietGoal(dietGoalDto, dietetician);
        return ResponseEntity.ok("Diet goal added successfully");
    }

    @PutMapping("/dietGoal/update/{id}")
    public ResponseEntity<String> updateDietGoal(Principal principal, @RequestBody DietGoalDto dietGoalDto, @PathVariable Integer id){
        User dietetician = userService.findByPrincipal(principal).orElseThrow();
        try {
            DietGoal dietGoal=dietGoalService.updateDietGoal(dietGoalDto, id, dietetician);
            return ResponseEntity.ok(dietGoal.toString());
        }catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body("No diet goal found for this user");
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




    @GetMapping("/dietGoal/get/{userId}")
    public ResponseEntity<String> getDietGoal(Principal principal, @PathVariable Integer userId){
        User user = userService.findById(userId).orElseThrow();
        User dietetician = userService.findByPrincipal(principal).orElseThrow();
        try {
            DietGoal dietGoal = dietGoalService.getDietGoalByUser(dietetician,user);
            return ResponseEntity.ok(dietGoal.toString());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("No diet goal found for this user");
        }
    }

    @GetMapping("/dietGoal/get/all")
    public ResponseEntity<String> getAllDietGoals(Principal principal){
        User dietetician = userService.findByPrincipal(principal).orElseThrow();
        return ResponseEntity.ok(dietGoalService.getAllDietGoals(dietetician).toString());
    }

    @DeleteMapping("/dietGoal/delete/{id}")
    public ResponseEntity<String> deleteDietGoal(Principal principal, @PathVariable Integer id){
        User dietetician = userService.findByPrincipal(principal).orElseThrow();
        try {
            DietGoal dietGoal = dietGoalService.deleteDietGoal(id, dietetician);
            return ResponseEntity.ok(dietGoal.toString());
        }catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body("No diet goal found for this user");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
