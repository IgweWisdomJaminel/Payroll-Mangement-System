package com.jaminel.payrollmangementsystem.data.controller;

import com.jaminel.payrollmangementsystem.data.dto.DeductionDto;
import com.jaminel.payrollmangementsystem.data.model.Deduction;
import com.jaminel.payrollmangementsystem.data.service.DeductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/deductions")
@RequiredArgsConstructor
public class DeductionController {

    private final DeductionService deductionService;

    @PostMapping
    public ResponseEntity<Deduction> createDeduction(@RequestBody DeductionDto deductionDto) {
        return deductionService.createDeduction(deductionDto);
    }


    @PutMapping("/{type}")
    public ResponseEntity<Deduction> updateDeduction(@PathVariable String type, @RequestBody DeductionDto deductionDto) {
        return deductionService.updateDeduction(type, deductionDto);
    }


    @GetMapping("/{type}")
    public ResponseEntity<Deduction> findDeductionByType(@PathVariable String type) {
        return deductionService.findDeductionByType(type);
    }


    @DeleteMapping("/{type}")
    public ResponseEntity<Map<String, String>> deleteDeductionByType(@PathVariable String type) {
        return new ResponseEntity<>(deductionService.deleteDeductionByType(type), HttpStatus.OK);
    }
}
