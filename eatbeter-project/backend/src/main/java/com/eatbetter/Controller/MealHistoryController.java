package com.eatbetter.Controller;

import com.eatbetter.Entity.MealHistoryDto;
import com.eatbetter.Entity.User;
import com.eatbetter.Service.MealHistoryService;
import com.eatbetter.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class MealHistoryController {
    private final MealHistoryService mealHistoryService;
    private final UserService userService;

    @PostMapping("/addMeal")
    public void addMeal(Principal principal, @RequestBody MealHistoryDto mealHistoryDto) {
        User user = userService.findByPrincipal(principal).orElseThrow();
        mealHistoryService.addMeal(user, mealHistoryDto);
    }

    @GetMapping("/getMealHistory/{start_date}/{end_date}")
    public ResponseEntity<String > getMealHistoryBetweenDates(Principal principal, @PathVariable String start_date, @PathVariable String end_date){
        User user = userService.findByPrincipal(principal).orElseThrow();
        return ResponseEntity.ok(mealHistoryService.getMealHistoryBetweenDates(user, start_date, end_date).toString());
    }
}
