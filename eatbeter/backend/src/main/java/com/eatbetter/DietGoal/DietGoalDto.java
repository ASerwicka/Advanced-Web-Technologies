package com.eatbetter.DietGoal;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link DietGoal} entity
 */
@Data
public class DietGoalDto implements Serializable {
    private final Integer calories;
    private final Integer fat;
    private final Integer carbohydrates;
    private final Integer sugar;
    private final Integer protein;
    private final Integer salt;
    private final Integer userId;
}