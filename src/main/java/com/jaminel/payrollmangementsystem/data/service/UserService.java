package com.jaminel.payrollmangementsystem.data.service;

import com.jaminel.payrollmangementsystem.data.dto.RegisterDto;
import com.jaminel.payrollmangementsystem.data.model.User;
import com.jaminel.payrollmangementsystem.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User saveUser (RegisterDto userRegistration){
        User user = new User();
        user.setUsername(userRegistration.getUsername());
        user.setPassword(userRegistration.getPassword());
        user.setRole(userRegistration.getRole());
        return userRepository.save(user);
    }
}
