package com.eatbetter.Meal;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class MealInfoDto {
    private LocalDateTime mealTime;
   private String name;
   private Integer quantity;
   private Integer calories;
   private Integer fat;
   private Integer carbohydrates;
   private Integer sugar;
   private Integer protein;
   private Integer salt;



}
