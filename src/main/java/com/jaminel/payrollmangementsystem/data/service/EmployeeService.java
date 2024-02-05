package com.jaminel.payrollmangementsystem.data.service;
import com.jaminel.payrollmangementsystem.data.exception.UserNotFoundException;
import com.jaminel.payrollmangementsystem.data.model.Department;
import com.jaminel.payrollmangementsystem.data.model.Employee;
import com.jaminel.payrollmangementsystem.data.repository.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public Employee saveEmployee (@Valid Employee employee){
        return employeeRepository.save(employee);
    }

    public Map<String, Boolean>  saveAllEmployee(List<Employee> employee){
        Map<String, Boolean> response = new HashMap<>();
        for (Employee employees : employee){
            response.put(employees.getId() + "saved successfully", true);
        }
        employeeRepository.saveAll(employee);
        return response;
    }

    public List<Employee> getAllEmployee (){
        return employeeRepository.findAll();
    }
    public Employee findUserById(int id){
        return employeeRepository.findById(id).orElseThrow(()->new UserNotFoundException("NOT FOUND"));
    }
    public Employee updateEmployeeList(int id, Employee employee) {
        Optional<Employee> updateList = employeeRepository.findById(id);
        if (updateList.isPresent()) {
            Employee employees = updateList.get();
            employees.setDateEmployed(employee.getDateEmployed());
            employees.setDepartment(employee.getDepartment());
            employees.setGender(employee.getGender());
            employees.setSalary(employee.getSalary());

            return employeeRepository.save(employees);
        } else {
            return (null);
        }
    }

    public Employee findByDepartment (Department department){
        return employeeRepository.findByDepartment(department);
    }
    public Optional<Employee> findByDateEmployed (LocalDate date){
        return employeeRepository.findByDateEmployed(date) ;
    }
    public void deleteEmployee (int id){
        employeeRepository.deleteById(id);
    }
}
