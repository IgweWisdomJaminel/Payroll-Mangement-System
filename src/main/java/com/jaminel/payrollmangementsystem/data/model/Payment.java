package com.jaminel.payrollmangementsystem.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Payment {

    @Id
    @UuidGenerator
    private String id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @NotBlank(message = "Employee ID is required.")
    private Employee employee;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "gross_amount")
    private double grossAmount;

//    @ManyToOne
//    @JoinColumn(name = "deduction_id")
//    private Deduction deduction;

    private double deduction;

    @Column(name = "net_amount")
    private double netAmount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_reference")
    private String paymentReference;

    @Column(name = "created_at", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    private double allowances;





}