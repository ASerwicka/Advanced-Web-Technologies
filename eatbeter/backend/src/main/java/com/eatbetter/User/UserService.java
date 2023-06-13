package com.eatbetter.User;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

@Service
@Component
@Data
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByPrincipal(Principal principal){
        User user = null;
        if (principal instanceof UsernamePasswordAuthenticationToken){
             user = userRepository.findByName(principal.getName()).orElse(null);

        }else if (principal instanceof OAuth2AuthenticationToken){
             user = userRepository.findByOauth2Id(((OAuth2AuthenticationToken) principal).getPrincipal().getAttribute("id").toString()).orElse(null);
        }
        System.out.println(user);
        return Optional.ofNullable(user);
    }

    public Optional<User> findById(Integer id){
        return userRepository.findById(Long.valueOf(id));
    }


    public void checkIfUserExists(Principal principal){
        User user = findByPrincipal(principal).orElse(null);
        if (principal instanceof OAuth2AuthenticationToken){
            if (Objects.isNull(user)){
                saveOauth2User((OAuth2AuthenticationToken) principal);
            }
        }
    }

    public void saveOauth2User(OAuth2AuthenticationToken principal){

        User user = new User();
        user.setOauth2Id(principal.getPrincipal().getAttribute("id").toString());
        user.setName(principal.getPrincipal().getAttribute("login").toString());
        userRepository.save(user);
    }

    public void save(User user) {
        userRepository.findByName(user.getName()).ifPresentOrElse(
                user1 -> {
                    throw new IllegalStateException("User already exists");
                },
                () -> {
                    userRepository.save(user);
                }
        );
    }

    public void editUser(UserEditDto userEditDto, Principal principal) {
        User user = findByPrincipal(principal).orElseThrow();
        if (Objects.nonNull(userEditDto.getEmail())){
            user.setEmail(userEditDto.getEmail());
        }
        if (Objects.nonNull(userEditDto.getBirthDate())){
            user.setBirthDate(userEditDto.getBirthDate());
        }
        if (Objects.nonNull(userEditDto.getPassword())){
            user.setPassword(userEditDto.getPassword());
        }
        userRepository.save(user);
    }
}

