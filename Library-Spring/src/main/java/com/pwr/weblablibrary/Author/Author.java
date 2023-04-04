package com.pwr.weblablibrary.Author;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author {
    private int id;
    private String firstName;
    private String lastName;
}