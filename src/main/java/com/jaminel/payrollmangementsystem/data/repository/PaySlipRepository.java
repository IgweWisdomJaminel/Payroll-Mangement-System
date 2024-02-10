package com.jaminel.payrollmangementsystem.data.repository;

import com.jaminel.payrollmangementsystem.data.model.PaySlip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaySlipRepository extends JpaRepository<PaySlip, Integer> {
Optional<PaySlip> findByEmail(String email);
}
