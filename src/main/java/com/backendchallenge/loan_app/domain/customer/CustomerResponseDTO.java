package com.backendchallenge.loan_app.domain.customer;

import com.backendchallenge.loan_app.domain.loan.LoanDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerResponseDTO {

    private String name;

    private List<LoanDTO> loans = new ArrayList<>();

    public CustomerResponseDTO(){}

    public CustomerResponseDTO(String name) {
        this.name = name;
    }

    public CustomerResponseDTO(Long id, String name) {
        this.name = name;
    }

    public CustomerResponseDTO(Customer customer){
        this.name = customer.getName();
        this.loans = customer.getLoans().stream().map(LoanDTO::new).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LoanDTO> getLoans() {
        return loans;
    }

}
