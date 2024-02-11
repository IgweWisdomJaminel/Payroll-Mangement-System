package com.jaminel.payrollmangementsystem.data.controller;



import com.jaminel.payrollmangementsystem.data.dto.PaymentDto;
import com.jaminel.payrollmangementsystem.data.model.Payment;
import com.jaminel.payrollmangementsystem.data.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentDto paymentDto) {
        return new ResponseEntity<>(paymentService.createPayment(paymentDto), HttpStatus.CREATED);
    }
}

