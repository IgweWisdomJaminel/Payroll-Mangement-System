package com.jaminel.payrollmangementsystem.data.service;

import com.jaminel.payrollmangementsystem.data.dto.SalaryDto;
import com.jaminel.payrollmangementsystem.data.model.Deduction;
import com.jaminel.payrollmangementsystem.data.model.Employee;
import com.jaminel.payrollmangementsystem.data.model.Salary;
import com.jaminel.payrollmangementsystem.data.repository.SalaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class SalaryService {

    private final SalaryRepository salaryRepository;
    private  final EmployeeService employeeService;
    private  final DeductionService deductionService;
    private  final SalaryService salaryService;
    public Map<String,String>addSalary(SalaryDto salaryDto){

        try{
            Deduction deduction = deductionService.findDeductionByType(salaryDto.getDeductionType()).getBody();
            Employee employee = employeeService.getEmployeeByName(salaryDto.getEmployeeName()).getBody();
            assert deduction != null;
            double netpay = Stream.of(salaryDto.getBaseSalary(), deduction.getAmount(), salaryDto.getAllowances())
                    .mapToDouble(value -> value)
                    .reduce(0.0, (subtotal, element) -> subtotal - element + element);
            assert employee != null;
            Salary salary = Salary.builder()
                    .employeeName(employee.getFullName())
                    .employees(employee).basicSalary(salaryDto.getBaseSalary()).
                    allowances(salaryDto.getAllowances())
                    .netSalary(netpay).deduction(deduction).build();
            salaryRepository.save(salary);
            return Map.of("Message :","salary Added");
        }catch (Exception e){
            e.printStackTrace();
            return Map.of("Message :",e.getMessage());
        }
    }
    public Map<String,String>getAllSalary(){
        try{
            salaryRepository.findAll();
        return Map.of("Message :","Salary List");
        }catch (Exception e){
            e.printStackTrace();
            return  Map.of("Message :",e.getMessage());
        }


    }
    public Map<String, String> updateSalary(String employeeName, SalaryDto salaryDto) {

        try {

            Salary existingSalary = salaryService.findSalaryByEmployeeName(employeeName).getBody();
            Deduction deduction = deductionService.findDeductionByType(salaryDto.getDeductionType()).getBody();
            double netPay = Stream.of(salaryDto.getBaseSalary(), deduction.getAmount(), salaryDto.getAllowances())
                    .mapToDouble(value -> value)
                    .reduce(0.0, (subtotal, element) -> subtotal - element + element);


            assert existingSalary != null;
            existingSalary.setBasicSalary(salaryDto.getBaseSalary());
            existingSalary.setAllowances(salaryDto.getAllowances());
            existingSalary.setNetSalary(netPay);
            existingSalary.setDeduction(deduction);

            // Save updated salary using appropriate exception handling
            salaryRepository.save(existingSalary);

            return Map.of("Message", "Salary successfully updated");

        } catch (NoSuchElementException e) {
            return Map.of("Message", "Error: " + e.getMessage());
        } catch (Exception e) {
            log.error("Error updating salary", e);
            return Map.of("Message", "Error updating salary. Please try again later.");
        }
    }

    public ResponseEntity<Salary>findSalaryByEmployeeName(String employeeName){
       try {
           Salary salary = salaryRepository.findSalariesByEmployeeName(employeeName);
           return new ResponseEntity<>(salary, HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
           e.getMessage();
           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       }
    }
   public Map<String,String>deleteSalaryName(String employeeName){
       try {
           Salary salary = salaryRepository.findSalariesByEmployeeName(employeeName);
           salaryRepository.deleteById(salary.getId());
           return Map.of("Message: ","Salary deleted");
       }catch (Exception e){
           e.printStackTrace();

           return Map.of("Message :",e.getMessage());
       }
   }




}
