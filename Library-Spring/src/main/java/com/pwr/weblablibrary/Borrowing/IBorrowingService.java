package com.pwr.weblablibrary.Borrowing;

import com.pwr.weblablibrary.exception.EntityNotFoundException;

import java.util.List;

public interface IBorrowingService {

    List<Borrowing> getBorrowings();

    Borrowing borrowBook(int id) throws EntityNotFoundException;

    Borrowing returnBook(int id) throws EntityNotFoundException;
}
