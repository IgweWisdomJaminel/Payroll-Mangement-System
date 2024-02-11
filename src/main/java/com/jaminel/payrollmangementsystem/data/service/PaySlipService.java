package com.jaminel.payrollmangementsystem.data.service;

import com.jaminel.payrollmangementsystem.data.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
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


        payslipContent.append("**Employee Name:** " + payment.getEmployee().getFullName() + "\n");
        payslipContent.append("**Employee ID:** " + payment.getEmployee().getId() + "\n");

        payslipContent.append("**Payment Date:** " + payment.getPaymentDate() + "\n");
        payslipContent.append("**Payment Type:** " + payment.getPaymentType() + "\n");


        payslipContent.append("**Gross Amount:** " + payment.getGrossAmount() + "\n");


        payslipContent.append("**Deductions:**\n");
        if (payment.getDeduction() > 0) {
            payslipContent.append(" - " + "Deduction amount" + ": " + payment.getDeduction() + "\n");
        }

        payslipContent.append("**Allowances:**\n");
        if (payment.getAllowances() > 0) {
            payslipContent.append(" - " + "Deduction Amount" + ": " + payment.getAllowances() + "\n");
        }

        payslipContent.append("**Net Amount:** " + payment.getNetAmount() + "\n");


        payslipContent.append("Payment Reference: " + payment.getPaymentReference() + "\n");

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
