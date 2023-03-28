package com.pwr.weblablibrary.Book;

import com.pwr.weblablibrary.Book.Book;
import com.pwr.weblablibrary.exception.EntityNotFoundException;
import com.pwr.weblablibrary.exception.InvalidEntityException;

import java.util.Collection;

public interface IBooksService {

    Collection<Book> getBooks();
    Book getBook(int id) throws EntityNotFoundException;

    Book addBook(Book book) throws InvalidEntityException;

    Book updateBook(Book book) throws EntityNotFoundException, InvalidEntityException;

    void deleteBook(int id) throws EntityNotFoundException;
}
