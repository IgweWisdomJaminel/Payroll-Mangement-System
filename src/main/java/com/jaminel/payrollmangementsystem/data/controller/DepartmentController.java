package com.jaminel.payrollmangementsystem.data.controller;

import com.jaminel.payrollmangementsystem.data.dto.DepartmentDto;
import com.jaminel.payrollmangementsystem.data.model.Department;
import com.jaminel.payrollmangementsystem.data.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> addDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.addDepartment(departmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateDepartment(@PathVariable String id, @RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.updateDepartment(id, departmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteDepartment(@PathVariable String id) {
        return new ResponseEntity<>(departmentService.deleteDepartment(id), HttpStatus.OK);
    }
}

