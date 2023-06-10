package com.eatbetter.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig   {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PlaintextPasswordEncoder();
    }
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeHttpRequests()
            .requestMatchers("/dietGoal/**").hasAuthority("Dietetician")
            .requestMatchers("/text/**").hasAuthority("Admin")
            .requestMatchers("/textType/**").hasAuthority("Admin")
            .requestMatchers("/inspirationData/**").hasAuthority("Admin")
            .requestMatchers("/admin/**").hasAuthority("Admin")
        .anyRequest()
        .authenticated()
        .and()
        .oauth2Login()
            .successHandler(new Oauth2SuccessHandler())
            .and()
            .formLogin()
            .defaultSuccessUrl("/loginSuccess", true);


    ;
    return http.build();
  }

}
