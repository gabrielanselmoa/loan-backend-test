package com.backendchallenge.loan_app.controllers;

import com.backendchallenge.loan_app.domain.loan.Loan;
import com.backendchallenge.loan_app.domain.loan.LoanDTO;
import com.backendchallenge.loan_app.services.CustomerService;
import com.backendchallenge.loan_app.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService service;

    @GetMapping
    public ResponseEntity<List<LoanDTO>> findAll(){
        List<LoanDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<LoanDTO> createLoan(@RequestBody LoanDTO dto){
        var loan = service.createLoan(dto);
        return ResponseEntity.ok().body(loan);
    }
}
