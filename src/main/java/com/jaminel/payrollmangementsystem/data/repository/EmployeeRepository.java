package com.jaminel.payrollmangementsystem.data.repository;

import com.jaminel.payrollmangementsystem.data.model.Employee;
import com.jaminel.payrollmangementsystem.data.service.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

    public Employee getEmployeeByFullName(String name);
}
