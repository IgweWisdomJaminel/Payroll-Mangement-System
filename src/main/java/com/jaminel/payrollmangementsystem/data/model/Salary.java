package com.jaminel.payrollmangementsystem.data.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

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

    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "pay_slip_id")
    private PaySlip paySlip;

    @ManyToOne
    @JoinColumn(name = "deduction_id")
    private Deduction deduction;
}
