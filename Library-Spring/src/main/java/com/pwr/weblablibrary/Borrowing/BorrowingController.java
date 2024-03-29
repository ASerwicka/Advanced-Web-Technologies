package com.pwr.weblablibrary.Borrowing;

import com.pwr.weblablibrary.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BorrowingController {

    private final IBorrowingService borrowService;

    @GetMapping("/borrow/book/{id}")
    public ResponseEntity<?> borrowBook(@PathVariable int id) {
        try {
            return ResponseEntity.ok(borrowService.borrowBook(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/return/book/{id}")
    public ResponseEntity<?> returnBook(@PathVariable int id) {
        try {
            return ResponseEntity.ok(borrowService.returnBook(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/borrowings")
    public ResponseEntity<List<Borrowing>> getBorrowings() {
        return ResponseEntity.ok(borrowService.getBorrowings());
    }
}
