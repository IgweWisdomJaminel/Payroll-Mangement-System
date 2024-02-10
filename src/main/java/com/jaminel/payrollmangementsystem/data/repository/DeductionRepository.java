package com.jaminel.payrollmangementsystem.data.repository;

import com.jaminel.payrollmangementsystem.data.model.Deduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeductionRepository extends JpaRepository<Deduction,String> {

    Deduction getDeductionByType(String type);

}
