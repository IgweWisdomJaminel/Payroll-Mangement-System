package com.jaminel.payrollmangementsystem.data.dto;

import com.jaminel.payrollmangementsystem.data.model.Employee;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName ="build")
public class SalaryDto {

    private Employee employees;


    private String employeeName;


    private double baseSalary;

    private double allowances;

    private String deductionType;


    private double netSalary;
}
