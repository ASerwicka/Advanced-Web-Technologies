package com.eatbetter.Service;

import com.eatbetter.Entity.User;
import com.eatbetter.Repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
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

}
