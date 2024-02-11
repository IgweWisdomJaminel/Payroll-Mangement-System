package com.jaminel.payrollmangementsystem.data.model;

import com.jaminel.payrollmangementsystem.data.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.jaminel.payrollmangementsystem.data.model.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    @Column(name="full_name")
    private String fullName;

    @Column(name = "date_employed")
    private LocalDate dateEmployed;

    private Gender gender;
    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

   @Email(message = "Please input a valid email address")
    private String email;

    public Employee(String fullName, LocalDate dateEmployed, Gender gender, String phoneNumber, Department department, String email) {
        this.fullName = fullName;
        this.dateEmployed = dateEmployed;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.department = department;
       this.email = email;
    }

    private Double salary;
}
