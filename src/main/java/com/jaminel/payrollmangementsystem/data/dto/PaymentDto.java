package com.jaminel.payrollmangementsystem.data.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class PaymentDto {

    @NotBlank(message = "Employee ID is required.")
    private String employeeId;


    private String employeeName;

    @NotNull(message = "Payment date is required.")
    private LocalDate paymentDate;

    @NotBlank(message = "Payment type is required.")
    private String paymentType;

    @Min(value = 0, message = "Gross amount must be non-negative.")
    private double grossAmount;

    @NotBlank(message = "Deduction type is required.")
    private String deductionType;

    @Min(value = 0, message = "Deduction amount must be non-negative.")
    private double deductionAmount;

    @NotBlank(message = "Payment method is required.")
    private String paymentMethod;

    @NotBlank(message = "Payment reference is required.")
    private String paymentReference;

    @Min(value = 0, message = "Allowances must be non-negative.")
    private double allowances;



}
