package com.eatbetter.Admin;

import com.eatbetter.Login.SetRoleDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AdminController {
    private final AdminService adminService;


    @PostMapping("/admin/setRole")
    public ResponseEntity<String> setRole(@RequestBody SetRoleDto setRoleDto){
        try {
            adminService.addRole(setRoleDto);
            return ResponseEntity.ok("Role added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
