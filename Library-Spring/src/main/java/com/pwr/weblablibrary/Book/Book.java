package com.pwr.weblablibrary.Book;

import com.pwr.weblablibrary.Author.Author;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private Author author;
    private int pages;
    private boolean isBorrowed;
}
