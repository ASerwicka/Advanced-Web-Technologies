package com.eatbetter.Service;

import com.eatbetter.Entity.MealHistory;
import com.eatbetter.Entity.MealHistoryDto;
import com.eatbetter.Entity.MealInfoDto;
import com.eatbetter.Entity.User;
import com.eatbetter.Repository.MealHistoryRepository;
import com.eatbetter.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MealHistoryService {
    private  final ProductRepository productRepository;
    private final MealHistoryRepository mealHistoryRepository;
    public void addMeal(User user, MealHistoryDto mealHistoryDto) {
        MealHistory mealHistory = new MealHistory();
        mealHistory.setMealTime(LocalDateTime.now());
        mealHistory.setUser(user);
        mealHistory.setProduct(productRepository.findById(Long.valueOf(mealHistoryDto.getProductID())).orElseThrow());
        mealHistory.setQuantity(mealHistoryDto.getQuantity());
        mealHistoryRepository.save(mealHistory);
    }

    public List<MealInfoDto> convertToMealInfoDto(List<MealHistory> mealHistories){

        return mealHistories.stream().map(mealHistory -> {
            int multiplier = mealHistory.getQuantity() / 100;
            MealInfoDto mealInfoDto = new MealInfoDto();
            mealInfoDto.setMealTime(mealHistory.getMealTime());
            mealInfoDto.setName(mealHistory.getProduct().getName());
            mealInfoDto.setQuantity(mealHistory.getQuantity());
            mealInfoDto.setCalories(mealHistory.getProduct().getCalories()*multiplier);
            mealInfoDto.setFat(mealHistory.getProduct().getFat()*multiplier);
            mealInfoDto.setCarbohydrates(mealHistory.getProduct().getCarbohydrates()*multiplier);
            mealInfoDto.setSugar(mealHistory.getProduct().getSugar()*multiplier);
            mealInfoDto.setProtein(mealHistory.getProduct().getProtein()*multiplier);
            mealInfoDto.setSalt(mealHistory.getProduct().getSalt()*multiplier);
            return mealInfoDto;
        }).toList();
    }

    public List<MealInfoDto> getMealHistoryBetweenDates(User user, String start_date, String end_date){
        LocalDateTime startDate = LocalDateTime.parse(start_date);
        LocalDateTime endDate = LocalDateTime.parse(end_date);
         return convertToMealInfoDto(mealHistoryRepository.findAllByUserAndMealTimeBetween(user, startDate, endDate));
    }
}
