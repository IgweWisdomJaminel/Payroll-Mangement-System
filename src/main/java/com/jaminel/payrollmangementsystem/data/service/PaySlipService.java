package com.jaminel.payrollmangementsystem.data.service;

import com.jaminel.payrollmangementsystem.data.model.PaySlip;
import com.jaminel.payrollmangementsystem.data.repository.PaySlipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PaySlipService {

    private final PaySlipRepository paySlipRepository;

    public void savePayslip(PaySlip paySlip) {

        paySlipRepository.save(paySlip);
    }
    public Optional<PaySlip> findByEmail(String email) {
        return paySlipRepository.findByEmail(email);
    }
}
