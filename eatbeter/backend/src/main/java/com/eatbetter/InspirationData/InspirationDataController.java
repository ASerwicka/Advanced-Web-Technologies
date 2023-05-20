package com.eatbetter.InspirationData;


import com.eatbetter.InspirationData.InspirationDataDto;
import com.eatbetter.InspirationData.InspirationDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class InspirationDataController {
    private final InspirationDataService inspirationDataService;

    @GetMapping("/inspirationData/get/{id}")
    public ResponseEntity<String> getInspirationData(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(inspirationDataService.getInspirationData(id).toString());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/inspirationData/add")
    public ResponseEntity<String> addInspirationData(@RequestBody InspirationDataDto inspirationDataDto){
        try {
            inspirationDataService.addInspirationData(inspirationDataDto);
            return ResponseEntity.ok("InspirationData added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/inspirationData/update/{id}")
    public ResponseEntity<String> updateInspirationData(@RequestBody InspirationDataDto inspirationDataDto, @PathVariable Integer id){
        try {
            inspirationDataService.updateInspirationData(inspirationDataDto, id);
            return ResponseEntity.ok("InspirationData updated successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/inspirationData/delete/{id}")
    public ResponseEntity<String> deleteInspirationData(@PathVariable Integer id){
        try {
            inspirationDataService.deleteInspirationData(id);
            return ResponseEntity.ok("InspirationData deleted successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
