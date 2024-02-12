package com.jaminel.payrollmangementsystem.data.service;

import com.jaminel.payrollmangementsystem.data.model.Payment;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class PaySlipService {


    public void generateAndSendPayslip(Payment payment) {

        String payslipContent = generatePayslipContent(payment);

    }


    private String generatePayslipContent(Payment payment) {


        StringBuilder payslipContent = new StringBuilder();


        payslipContent.append("**Employee Name:** ").append(payment.getEmployee().getFullName()).append("\n");
        payslipContent.append("**Employee ID:** ").append(payment.getEmployee().getId()).append("\n");

        payslipContent.append("**Payment Date:** ").append(payment.getPaymentDate()).append("\n");
        payslipContent.append("**Payment Type:** ").append(payment.getPaymentType()).append("\n");


        payslipContent.append("**Gross Amount:** ").append(payment.getGrossAmount()).append("\n");


        payslipContent.append("**Deductions:**\n");
        if (payment.getDeduction() > 0) {
            payslipContent.append(" - " + "Deduction amount" + ": ").append(payment.getDeduction()).append("\n");
        }

        payslipContent.append("**Allowances:**\n");
        if (payment.getAllowances() > 0) {
            payslipContent.append(" - " + "Deduction Amount" + ": ").append(payment.getAllowances()).append("\n");
        }

        payslipContent.append("**Net Amount:** ").append(payment.getNetAmount()).append("\n");


        payslipContent.append("Payment Reference: ").append(payment.getPaymentReference()).append("\n");

        payslipContent.append("\n"); // Add a line break for readability
        String payslip = payslipContent.toString();
        try {
            FileWriter fileWriter = new FileWriter("payslip.txt");
            fileWriter.write(payslip);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return payslip;
    }
}
