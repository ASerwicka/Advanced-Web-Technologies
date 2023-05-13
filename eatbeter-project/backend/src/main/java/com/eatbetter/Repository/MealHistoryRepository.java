package com.eatbetter.Repository;

import com.eatbetter.Entity.MealHistory;
import com.eatbetter.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Component
public interface MealHistoryRepository extends JpaRepository<MealHistory, Long> {
    List<MealHistory> findMealHistoriesByUser(User user);
    List<MealHistory> findMealHistoriesByUserAndMealTimeBetweenOrderByMealTimeAsc(User user, LocalDateTime mealTime, LocalDateTime mealTime2);
    List<MealHistory> findMealHistoriesByUserAndMealTimeAfterOrderByMealTimeAsc(User user, LocalDateTime mealTime);


    List<MealHistory> findAllByUserAndMealTimeBetween(User user, LocalDateTime localDateTime, LocalDateTime localDateTime1);
}
