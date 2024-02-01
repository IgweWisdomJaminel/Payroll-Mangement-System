package com.jaminel.payrollmangementsystem.data.model;

import com.jaminel.payrollmangementsystem.data.model.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @UuidGenerator
    private String id;

    private LocalDate dateEmployed;

    private Gender gender;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private String designation;

    private Salary salary;
}
