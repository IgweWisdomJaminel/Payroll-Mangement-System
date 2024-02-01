package com.jaminel.payrollmangementsystem.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Deduction {

    @Id
    @UuidGenerator
    private String id;
}
