package com.jaminel.payrollmangementsystem.data.repository;
import com.jaminel.payrollmangementsystem.data.model.Department;
import com.jaminel.payrollmangementsystem.data.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findByDateEmployed(LocalDate dateEmployed);

    Employee findByDepartment (Department department);

    List<Employee> findBySalaryBetween (Double lowestSalary, Double highestSalary);

}
