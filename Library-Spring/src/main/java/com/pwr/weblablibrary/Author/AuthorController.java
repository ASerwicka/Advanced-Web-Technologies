package com.pwr.weblablibrary.Author;

import com.pwr.weblablibrary.exception.EntityNotFoundException;
import com.pwr.weblablibrary.exception.InvalidEntityException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final IAuthorService authorService;
    @CrossOrigin
    @GetMapping("/get/authors")
    public ResponseEntity<Collection<Author>> getAuthors() {
        return ResponseEntity.ok(authorService.getAuthors());
    }
    @CrossOrigin
    @GetMapping("/get/author/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable int id) {
        try {
            return ResponseEntity.ok(authorService.getAuthor(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @PostMapping("/post/author")
    public ResponseEntity<?> addAuthor(@RequestBody Author author) {
        try {
            return ResponseEntity.ok(authorService.addAuthor(author));
        } catch (InvalidEntityException e) {
            return ResponseEntity.badRequest().body("Invalid entity");
        }
    }
    @CrossOrigin
    @PatchMapping("/patch/author")
    public ResponseEntity<?> updateAuthor(@RequestBody Author author) {
        try {
            return ResponseEntity.ok(authorService.updateAuthor(author));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Invalid entity");
        }
    }
    @CrossOrigin
    @PatchMapping("/delete/author/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable int id) {
        try {
            authorService.deleteAuthor(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
