package com.eatbetter.DietGoal;

import com.eatbetter.DietGoal.DietGoal;
import com.eatbetter.DietGoal.DietGoalDto;
import com.eatbetter.User.User;
import com.eatbetter.DietGoal.DietGoalRepository;
import com.eatbetter.User.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DietGoalService {
    private final UserRepository userRepository;
    private final DietGoalRepository dietGoalRepository;
    public void addDietGoal(DietGoalDto dietGoalDto, User dietetician) {

        DietGoal dietGoal = new DietGoal();
        dietGoal.setCalories(dietGoalDto.getCalories());
        dietGoal.setCarbohydrates(dietGoalDto.getCarbohydrates());
        dietGoal.setFat(dietGoalDto.getFat());
        dietGoal.setProtein(dietGoalDto.getProtein());
        dietGoal.setSalt(dietGoalDto.getSalt());
        dietGoal.setSugar(dietGoalDto.getSugar());
        User user = userRepository.findById(Long.valueOf(dietGoalDto.getUserId())).orElseThrow();
        dietGoal.setUser(user);
        dietGoal.setDietetician(dietetician);
        user.setDietGoal(dietGoal);

        dietGoalRepository.save(dietGoal);
        userRepository.save(user);
    }

    public DietGoal getDietGoalByUser(User dietetician,User user) {
        DietGoal dietGoal = dietGoalRepository.findDietGoalByUser(user).orElseThrow();
        if(dietGoal.getDietetician().equals(dietetician))
            return dietGoal;
        else throw new IllegalArgumentException("Diet goal was not created by this dietetician");
    }

    public DietGoal getDietGoal(User user) {

        return dietGoalRepository.findDietGoalByUser(user).orElseThrow();
    }

    public Object getAllDietGoals(User dietetician) {
        List<DietGoal> dietGoals = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            if (user.getDietGoal() != null && user.getDietGoal().getDietetician().equals(dietetician)) {
                dietGoals.add(user.getDietGoal());
            }
        });
        return dietGoals;
    }

    public DietGoal updateDietGoal(DietGoalDto dietGoalDto, Integer id, User dietetician) {

        DietGoal dietGoal_org = dietGoalRepository.findById(Long.valueOf(id)).orElseThrow();
        if(!dietGoal_org.getDietetician().equals(dietetician))
            throw new IllegalArgumentException("Diet goal was not created by this dietetician");
        
        DietGoal dietGoal = new DietGoal();
        dietGoal.setCalories(dietGoalDto.getCalories());
        dietGoal.setCarbohydrates(dietGoalDto.getCarbohydrates());
        dietGoal.setFat(dietGoalDto.getFat());
        dietGoal.setProtein(dietGoalDto.getProtein());
        dietGoal.setSalt(dietGoalDto.getSalt());
        dietGoal.setSugar(dietGoalDto.getSugar());
        dietGoal.setId(id);
        dietGoal.setDietetician(dietetician);
        User user = userRepository.findById(Long.valueOf(dietGoalDto.getUserId())).orElseThrow();
        dietGoal.setUser(user);
        user.setDietGoal(dietGoal);
        dietGoalRepository.save(dietGoal);
        userRepository.save(user);
        return dietGoal;
    }

    public DietGoal deleteDietGoal(Integer id, User dietetician) {
        DietGoal dietGoal = dietGoalRepository.findById(Long.valueOf(id)).orElseThrow();
        if (dietGoal.getDietetician().equals(dietetician)) {
            dietGoalRepository.delete(dietGoal);
            return dietGoal;
        }
        else throw new IllegalArgumentException("Diet goal was not created by this dietetician");
    }
}
