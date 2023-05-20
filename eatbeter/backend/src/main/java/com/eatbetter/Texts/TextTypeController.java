package com.eatbetter.Texts;

import com.eatbetter.Texts.TextType;
import com.eatbetter.Texts.TextTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TextTypeController {

    private final TextTypeService textTypeService;

    @GetMapping("/textType/get/{id}")
    public ResponseEntity<String> getTextType(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(textTypeService.getTextType(id).toString());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/textType/add")
    public ResponseEntity<String> addTextType(@RequestBody TextType textType){
        try {
            textTypeService.addTextType(textType);
            return ResponseEntity.ok("Text type added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/textType/update/{id}")
    public ResponseEntity<String> updateTextType(@RequestBody TextType textType, @PathVariable Integer id){
        try {
            textTypeService.updateTextType(textType, id);
            return ResponseEntity.ok("Text type updated successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/textType/delete/{id}")
    public ResponseEntity<String> deleteTextType(@PathVariable Integer id){
        try {
            textTypeService.deleteTextType(id);
            return ResponseEntity.ok("Text type deleted successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
