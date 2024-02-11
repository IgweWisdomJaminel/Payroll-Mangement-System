package com.jaminel.payrollmangementsystem.data.service;

import com.jaminel.payrollmangementsystem.data.dto.DepartmentDto;
import com.jaminel.payrollmangementsystem.data.exception.DepartmentNotFoundException;
import com.jaminel.payrollmangementsystem.data.model.Department;
import com.jaminel.payrollmangementsystem.data.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentService {
    private final DepartmentRepository departmentRepository;


    public ResponseEntity<Department> getDepartmentById(String id) {
        try {
            return new ResponseEntity<>(departmentRepository.findById(id)
                    .orElseThrow(DepartmentNotFoundException::new), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public Map<String,String> addDepartment(DepartmentDto departmentDto){
        try{
            log.info("input new Department",departmentDto.getDepartmentName());
            departmentRepository.save(new Department(departmentDto.getDepartmentName()));
            return Map.of("Message","Department added");
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            return Map.of("Message",e.getMessage());

        }
    }
    public Map<String, String> updateDepartment(String id, DepartmentDto departmentDto) {
        try {
            Department departmentToBeUpdated = departmentRepository.findById(id)
                    .orElseThrow(DepartmentNotFoundException::new);

            departmentToBeUpdated.setId(departmentDto.getDepartmentName());
            departmentToBeUpdated.setDepartmentName(departmentDto.getDepartmentName());

            departmentRepository.save(departmentToBeUpdated);

            return Map.of("message", "Successfully update Department");

        } catch (Exception e) {
            e.printStackTrace();
            return Map.of("message", e.getMessage());
        }

    }
    public Map<String, String> deleteDepartment(String id) {
        try {
            departmentRepository.deleteById(id);

            return Map.of("message", "Successfully delete Department");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Map.of("message", "Something went wrong");
    }


}
