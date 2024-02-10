package com.jaminel.payrollmangementsystem.data.controller;


import com.jaminel.payrollmangementsystem.data.dto.EmployeeDto;
import com.jaminel.payrollmangementsystem.data.model.Employee;
import com.jaminel.payrollmangementsystem.data.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        try {
            return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto employeeDto) {
        try {
            return new ResponseEntity<>(employeeService.addEmployee(employeeDto), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody EmployeeDto employeeDto) {
        try {
            return employeeService.updateEmployee(id, employeeDto);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteEmployee(@PathVariable String id) {
        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(Map.of("message", "Employee deleted successfully"), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(Map.of("message", "Error deleting employee: " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        try {
            return employeeService.getEmployeeById(id);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/by-name/{name}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable String name) {
        try {
            return employeeService.getEmployeeByName(name);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}

