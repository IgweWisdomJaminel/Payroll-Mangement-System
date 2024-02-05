package com.jaminel.payrollmangementsystem.data.dto;

import com.jaminel.payrollmangementsystem.data.model.enums.Role;
import lombok.Data;

@Data
public class RegisterDto {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    public Role role;
}
