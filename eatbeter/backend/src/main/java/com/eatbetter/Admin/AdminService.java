package com.eatbetter.Admin;

import com.eatbetter.Login.SetRoleDto;
import com.eatbetter.User.User;
import com.eatbetter.Login.RoleRepository;
import com.eatbetter.User.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public void addRole(SetRoleDto setRoleDto){
        User user = userRepository.findById(Long.valueOf(setRoleDto.getUserID())).orElseThrow(() -> new RuntimeException("User not found"));
        user.getRoles().add(roleRepository.findByName(setRoleDto.getRoleName()));
        userRepository.save(user);
    }
}
