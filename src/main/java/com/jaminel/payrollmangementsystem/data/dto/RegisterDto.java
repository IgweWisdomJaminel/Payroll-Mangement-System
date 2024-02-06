package com.jaminel.payrollmangementsystem.data.dto;

import com.jaminel.payrollmangementsystem.data.enums.Role;
import lombok.Data;

@Data
public class RegisterDto {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Role role;
}
