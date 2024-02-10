package com.jaminel.payrollmangementsystem.data.service;

import com.jaminel.payrollmangementsystem.data.dto.EmployeeDto;
import com.jaminel.payrollmangementsystem.data.model.Department;
import com.jaminel.payrollmangementsystem.data.model.Employee;
import com.jaminel.payrollmangementsystem.data.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private EmployeeRepository employeeRepository;
    private DepartmentService departmentService;


    public List<Employee>getAllEmployees(){return employeeRepository.findAll();}

    public Employee addEmployee(EmployeeDto employeeDto){
        Department department = departmentService.getDepartmentById(employeeDto.getDepartmentId()).getBody();
        Employee employee =
                new Employee(employeeDto.getFullName()
                        ,employeeDto.getDateEmployed(),employeeDto
                                .getGender(),employeeDto.getPhoneNumber(),department,employeeDto.getEmail());
        return employeeRepository.save(employee);
    }


    public ResponseEntity<Employee> updateEmployee(String id, EmployeeDto employeeDto) {
        try {
            Employee employee = employeeRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            employee =
                    Employee.builder()
                            .fullName(employee.getFullName())
                            .email(employee.getEmail())
                            .dateEmployed(employeeDto.getDateEmployed())
                            .department(departmentService.getDepartmentById(employeeDto.getDepartmentId())
                                    .getBody()).gender(employeeDto.getGender())
                            .phoneNumber(employeeDto.getPhoneNumber()).build();
            return new ResponseEntity<>(employeeRepository.save(employee),HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    public Map<String,String>deleteEmployee(String id){
        try{
            employeeRepository.deleteById(id);
            return Map.of("Message :","Deleted Succefully");
        }catch (Exception e){
            e.printStackTrace();
            return Map.of("message",e.getMessage());
        }
    }
    public ResponseEntity<Employee>getEmployeeById(String id){
        try{
          return new ResponseEntity<>(employeeRepository.findById(id).
                  orElseThrow(ChangeSetPersister.NotFoundException::new),HttpStatus.OK);


        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();

        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<Employee> getEmployeeByName(String name){
        try {
            return new ResponseEntity<>(employeeRepository.getEmployeeByFullName(name),HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound e){
            e.printStackTrace();
            e.getMessage();
            return new ResponseEntity<>(null,e.getStatusCode());
        }
    }


    }
