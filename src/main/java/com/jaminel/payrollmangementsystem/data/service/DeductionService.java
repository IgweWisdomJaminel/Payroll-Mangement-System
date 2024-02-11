package com.jaminel.payrollmangementsystem.data.service;

import com.jaminel.payrollmangementsystem.data.dto.DeductionDto;
import com.jaminel.payrollmangementsystem.data.model.Deduction;
import com.jaminel.payrollmangementsystem.data.repository.DeductionRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeductionService {

    private final DeductionRepository deductionRepository;

    public ResponseEntity<Deduction>createDeduction(DeductionDto deductionDto){
        try{
            Deduction deduction = Deduction.builder().type(deductionDto.getType()).amount(deductionDto.getAmount()).build();
            return new ResponseEntity<>(deductionRepository.save(deduction), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    } public ResponseEntity<Deduction>updateDeduction(String type,DeductionDto deductionDto){
        try{
            Deduction deduction = deductionRepository.getDeductionByType(type);

            deduction = Deduction.builder().type(deductionDto.getType()).amount(deductionDto.getAmount()).build();

            return new ResponseEntity<>(deductionRepository.save(deduction), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

   public ResponseEntity<Deduction> findDeductionByType(String type){

        try {
            return new ResponseEntity<>(deductionRepository.getDeductionByType(type),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            e.getMessage();
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

   }
   public Map<String,String> deleteDeductionByType(String type){
        try {
            Deduction deduction = deductionRepository.getDeductionByType(type);
      deductionRepository.deleteById(deduction.getId());

            return Map.of("Message :","deleted");
        }catch(Exception e){
            e.printStackTrace();
            e.getMessage();
            return Map.of("Message",e.getMessage());
        }

   }
}




