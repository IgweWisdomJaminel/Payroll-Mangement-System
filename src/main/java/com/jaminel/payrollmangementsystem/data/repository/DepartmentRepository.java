package com.jaminel.payrollmangementsystem.data.repository;

import com.jaminel.payrollmangementsystem.data.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,String> {

}
