package com.jaminel.payrollmangementsystem.data.controller;



import com.jaminel.payrollmangementsystem.data.dto.SalaryDto;
import com.jaminel.payrollmangementsystem.data.model.Salary;
import com.jaminel.payrollmangementsystem.data.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/salaries")
@RequiredArgsConstructor
public class SalaryController {

    private final SalaryService salaryService;

    @PostMapping
    public ResponseEntity<Map<String, String>> addSalary(@RequestBody SalaryDto salaryDto) {
        return new ResponseEntity<>(salaryService.addSalary(salaryDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> getAllSalary() {
        return new ResponseEntity<>(salaryService.getAllSalary(), HttpStatus.OK);
    }

    @PutMapping("/{employeeName}")
    public ResponseEntity<Map<String, String>> updateSalary(@PathVariable String employeeName, @RequestBody SalaryDto salaryDto) {
        return new ResponseEntity<>(salaryService.updateSalary(employeeName, salaryDto), HttpStatus.OK);
    }

    @GetMapping("/{employeeName}")
    public ResponseEntity<Salary> findSalaryByEmployeeName(@PathVariable String employeeName) {
        return salaryService.findSalaryByEmployeeName(employeeName);
    }

    @DeleteMapping("/{employeeName}")
    public ResponseEntity<Map<String, String>> deleteSalaryByName(@PathVariable String employeeName) {
        return new ResponseEntity<>(salaryService.deleteSalaryName(employeeName), HttpStatus.OK);
    }
}

