package com.jaminel.payrollmangementsystem.data.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Salary {

    @Id
    @UuidGenerator
    private String id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employees;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "basic_salary")
    private double basicSalary;

    private double allowances;

    @OneToOne(cascade = CascadeType.ALL) // Consider cascading operations
    @JoinColumn(name = "deduction_id")
    private Deduction deduction;

    @Column(name = "net_salary")
    private double netSalary;
}
