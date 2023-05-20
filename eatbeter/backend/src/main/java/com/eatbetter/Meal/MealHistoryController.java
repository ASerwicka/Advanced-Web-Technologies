package com.eatbetter.Meal;

import com.eatbetter.User.User;
import com.eatbetter.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class MealHistoryController {
    private final MealHistoryService mealHistoryService;
    private final UserService userService;

    @PostMapping("/mealHistory/add")
    public void addMeal(Principal principal, @RequestBody MealHistoryDto mealHistoryDto) {
        User user = userService.findByPrincipal(principal).orElseThrow();
        mealHistoryService.addMeal(user, mealHistoryDto);
    }

    @GetMapping("/mealHistory/get/{start_date}/{end_date}")
    public ResponseEntity<String > getMealHistoryBetweenDates(Principal principal, @PathVariable String start_date, @PathVariable String end_date){
        User user = userService.findByPrincipal(principal).orElseThrow();
        return ResponseEntity.ok(mealHistoryService.getMealHistoryBetweenDates(user, start_date, end_date).toString());
    }

    @PutMapping("/mealHistory/update/{id}")
    public ResponseEntity<String> updateMealHistory(Principal principal, @RequestBody MealHistoryDto mealHistoryDto, @PathVariable Integer id){
        User user = userService.findByPrincipal(principal).orElseThrow();
        try {
            mealHistoryService.updateMealHistory(user, mealHistoryDto, id);
            return ResponseEntity.ok("Meal history updated successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/mealHistory/delete/{id}")
    public ResponseEntity<String> deleteMealHistory(Principal principal, @PathVariable Integer id){
        User user = userService.findByPrincipal(principal).orElseThrow();
        try {
            mealHistoryService.deleteMealHistory(user, id);
            return ResponseEntity.ok("Meal history deleted successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




}
