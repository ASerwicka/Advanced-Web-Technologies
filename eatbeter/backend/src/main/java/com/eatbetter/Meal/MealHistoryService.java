package com.eatbetter.Meal;

import com.eatbetter.User.User;
import com.eatbetter.Product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void updateMealHistory(User user, MealHistoryDto mealHistoryDto, Integer id) {
        MealHistory mealHistory = mealHistoryRepository.findById(Long.valueOf(id)).orElseThrow();
        if( !mealHistory.getUser().equals(user))
            throw new IllegalArgumentException("Meal history was not created by this user");
        mealHistory.setProduct(productRepository.findById(Long.valueOf(mealHistoryDto.getProductID())).orElseThrow());
        mealHistory.setQuantity(mealHistoryDto.getQuantity());
        mealHistoryRepository.save(mealHistory);
    }

    public void deleteMealHistory(User user, Integer id) {
        MealHistory mealHistory = mealHistoryRepository.findById(Long.valueOf(id)).orElseThrow();
        if( !mealHistory.getUser().equals(user))
            throw new IllegalArgumentException("Meal history was not created by this user");
        mealHistoryRepository.delete(mealHistory);
    }
}
