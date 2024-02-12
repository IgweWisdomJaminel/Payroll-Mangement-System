package com.jaminel.payrollmangementsystem.data.repository;



import com.jaminel.payrollmangementsystem.data.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaySlipRepository extends JpaRepository<Payment, Integer> {
//Optional<Payment> findByEmail(String email);
}
