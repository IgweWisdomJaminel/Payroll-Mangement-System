package com.jaminel.payrollmangementsystem.data.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeductionDto {

    private String id;

    private String type;

    private double amount;
}
