package com.jaminel.payrollmangementsystem.data.dto;

import com.jaminel.payrollmangementsystem.data.model.Department;
import com.jaminel.payrollmangementsystem.data.model.enums.Gender;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Getter
@Setter
@Data
public class EmployeeDto {

    private String fullName;
    private LocalDate dateEmployed;
    private Gender gender;
    private String phoneNumber;
    private String departmentId;
    private String Email;
}
