package com.backendchallenge.loan_app.controllers;

import com.backendchallenge.loan_app.domain.customer.Customer;
import com.backendchallenge.loan_app.domain.customer.CustomerRequestDTO;
import com.backendchallenge.loan_app.domain.customer.CustomerResponseDTO;
import com.backendchallenge.loan_app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/customer-loans")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO dto){
        var customer = service.createCustomer(dto);
        return ResponseEntity.ok().body(customer);
    }
}
