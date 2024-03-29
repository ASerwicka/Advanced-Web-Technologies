package com.pwr.weblablibrary.Book;

import com.pwr.weblablibrary.exception.EntityNotFoundException;
import com.pwr.weblablibrary.exception.InvalidEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final IBooksService booksService;
    @CrossOrigin
    @GetMapping("/")
    public String home() {
        return "Home";
    }
    @CrossOrigin
    @GetMapping("/get/books")
    public ResponseEntity<Collection<Book>> getBooks() {
        return ResponseEntity.ok(booksService.getBooks());
    }
    @CrossOrigin
    @GetMapping("/get/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        try {
            return ResponseEntity.ok(booksService.getBook(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @PostMapping("/post/book")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        try {
            return ResponseEntity.ok(booksService.addBook(book));
        } catch (InvalidEntityException e) {
            return ResponseEntity.badRequest().body("Invalid entity");
        }
    }
    @CrossOrigin
    @PatchMapping("/patch/book")
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        try {
            return ResponseEntity.ok(booksService.updateBook(book));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Entity not found");
        } catch (InvalidEntityException e) {
            return ResponseEntity.badRequest().body("Invalid entity");
        }
    }
    @CrossOrigin
    @DeleteMapping("/delete/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        try {
            booksService.deleteBook(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
