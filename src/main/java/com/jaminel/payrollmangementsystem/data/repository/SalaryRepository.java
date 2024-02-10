package com.jaminel.payrollmangementsystem.data.repository;

import com.jaminel.payrollmangementsystem.data.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary,String> {

    Salary findSalariesByEmployeeName(String name);
}
