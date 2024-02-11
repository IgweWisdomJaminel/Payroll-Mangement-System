package com.jaminel.payrollmangementsystem.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
@RestControllerAdvice
public class GlobalExceptionHandler {
     @ExceptionHandler(DepartmentNotFoundException.class)
     @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String>departmentNotFoundExceptionHandler(DepartmentNotFoundException departmentNotFoundException){
        return Map.of("Message",departmentNotFoundException.getMessage());


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DepartmentNotFoundException.class)
    public Map<String,String>departmentNotFoundExceptionHandler(DepartmentNotFoundException departmentNotFoundException){
        return Map.of("Message",departmentNotFoundException.getMessage());

    }

    }
}
