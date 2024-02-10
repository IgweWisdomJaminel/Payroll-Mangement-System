package com.jaminel.payrollmangementsystem.data.service;

import com.jaminel.payrollmangementsystem.data.dto.PaymentDto;
import com.jaminel.payrollmangementsystem.data.model.Deduction;
import com.jaminel.payrollmangementsystem.data.model.Employee;
import com.jaminel.payrollmangementsystem.data.model.Payment;
import com.jaminel.payrollmangementsystem.data.model.Salary;
import com.jaminel.payrollmangementsystem.data.repository.EmployeeRepository;
import com.jaminel.payrollmangementsystem.data.repository.PaymentRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PaymentService {


    private EmployeeService employeeService;


    private SalaryService salaryService;


    private PaymentRepository paymentRepository;

    private  PaySlipService paySlipService;
    @Transactional
    public Payment createPayment(PaymentDto paymentDto) {

        Salary salary = salaryService.findSalaryByEmployeeName(paymentDto.getEmployeeName()).getBody();
       double netPay;
      if(salary.getNetSalary()==0.0){
          netPay= calculateNetAmount(salary.getBasicSalary(), paymentDto.getDeductionAmount(), paymentDto.getAllowances());

      }else {
          netPay=salary.getNetSalary();
      }

        Payment payment = Payment.builder()
                .employee(salary.getEmployees())
                .paymentDate(paymentDto.getPaymentDate())
                .paymentType(paymentDto.getPaymentType())
                .grossAmount(salary.getBasicSalary())
                .deduction(salary.getDeduction().getAmount())
                .netAmount(netPay)
                .paymentMethod(paymentDto.getPaymentMethod())
                .paymentReference(paymentDto.getPaymentReference())
                .allowances(salary.getAllowances())
                .build();
      paySlipService.generateAndSendPayslip(payment);


        return paymentRepository.save(payment);
    }


    private double calculateNetAmount( double baseSalary, double deductionAmount,double allowances) {

        double netpay = Stream.of(baseSalary, deductionAmount, allowances)
                .mapToDouble(value -> value != null ? value : 0.0)
                .reduce(0.0, (subtotal, element) -> subtotal - element + element);
        return netpay;
    }



}
