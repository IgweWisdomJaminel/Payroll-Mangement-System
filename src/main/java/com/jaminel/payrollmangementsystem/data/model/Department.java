package com.jaminel.payrollmangementsystem.data.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {

    @Id
    @UuidGenerator
    private String id;

    private String name;


    public Department(String departmentName) {

    @Column(name = "department_name")
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
}

