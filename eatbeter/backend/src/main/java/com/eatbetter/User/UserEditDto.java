package com.eatbetter.User;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserEditDto implements Serializable {
    private final String email;
    private final String password;
    private final LocalDate birthDate;
}