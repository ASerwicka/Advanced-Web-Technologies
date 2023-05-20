package com.eatbetter.Login;

import com.eatbetter.Texts.TextsDto;
import com.eatbetter.Texts.TextService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TextController {
    private final TextService textService;

    @GetMapping("/text/get/{id}")
    public ResponseEntity<String> getText(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(textService.getText(id).toString());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/text/add")
    public ResponseEntity<String> addText(@RequestBody TextsDto textsDto){
        try {
            textService.addText(textsDto);
            return ResponseEntity.ok("Text added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/text/update/{id}")
    public ResponseEntity<String> updateText(@RequestBody TextsDto textsDto, @PathVariable Integer id){
        try {
            textService.updateText(textsDto, id);
            return ResponseEntity.ok("Text updated successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/text/delete/{id}")
    public ResponseEntity<String> deleteText(@PathVariable Integer id){
        try {
            textService.deleteText(id);
            return ResponseEntity.ok("Text deleted successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
