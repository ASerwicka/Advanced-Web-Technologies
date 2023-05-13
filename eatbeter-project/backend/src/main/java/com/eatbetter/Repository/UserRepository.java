package com.eatbetter.Repository;

import com.eatbetter.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);


    Optional<User> findByName(String username);
    Optional<User>findByOauth2Id(String id);

}
