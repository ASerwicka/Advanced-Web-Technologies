package com.eatbetter.config;

import com.eatbetter.Login.Role;
import com.eatbetter.User.User;
import com.eatbetter.Login.RoleRepository;
import com.eatbetter.User.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    @Transactional
    public void addData() {
        if (roleRepository.count() == 0) {
            roleRepository.saveAll(
                    getRoles()
            );
        }
        if (userRepository.count() == 0) {
            userRepository.saveAll(
                    getUsers()
            );
        }
    }

    private List<Role> getRoles(){
        return List.of(
                Role.builder()
                        .name("Admin")
                        .build(),
                Role.builder()
                        .name("User")
                        .build(),
                Role.builder()
                        .name("Dietetician")
                        .build()
        );
    }
    private List<User> getUsers(){




        return List.of(
                User.builder()
                        .email("Admin@Admin")
                        .name("Admin")
                        .password(passwordEncoder.encode("Admin"))
                        .roles(Set.of(
                                roleRepository.findByName("Admin"),
                                roleRepository.findByName("User"),
                                roleRepository.findByName("Dietetician")
                                ))
                        .build(),
                User.builder()
                        .email("Dietetician@Dietetician")
                        .name("Dietetician")
                        .password(passwordEncoder.encode("Dietetician"))
                        .roles(Set.of(
                                roleRepository.findByName("Dietetician"),
                                roleRepository.findByName("User")
                        ))
                        .build(),
                User.builder()
                        .email("User@User")
                        .name("User")
                        .password(passwordEncoder.encode("User"))
                        .roles(Set.of(
                                roleRepository.findByName("User")
                        )).build());
    }

}
