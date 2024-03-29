package com.pwr.weblablibrary.Author;

import com.pwr.weblablibrary.Author.Author;
import com.pwr.weblablibrary.exception.EntityNotFoundException;
import com.pwr.weblablibrary.exception.InvalidEntityException;

import java.util.Collection;

public interface IAuthorService {

    Collection<Author> getAuthors();

    Author getAuthor(int id) throws EntityNotFoundException;

    Author addAuthor(Author author) throws InvalidEntityException;

    Author updateAuthor(Author author) throws EntityNotFoundException;

    void deleteAuthor(int id) throws EntityNotFoundException;
}
