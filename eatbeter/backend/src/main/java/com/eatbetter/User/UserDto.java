package com.eatbetter.User;

import com.eatbetter.Login.Role;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserDto implements Serializable {
    private final String name;
    private final String email;
    private final String password;
    private final LocalDate birthDate;
    private final Set<Role> roles;

    public UserDto(String name, String email, String password, Set<Role> roleSet, Set<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.birthDate = null;
    }
}