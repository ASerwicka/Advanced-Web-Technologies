package com.eatbetter.DietGoal;

import com.eatbetter.DietGoal.DietGoal;
import com.eatbetter.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DietGoalRepository extends JpaRepository<DietGoal, Long> {

    Optional<DietGoal> findDietGoalByUser(User users);
}
