package com.backendchallenge.loan_app.domain.customer;

import com.backendchallenge.loan_app.domain.loan.LoanDTO;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerResponseDTO {

    private Long id;

    private String name;

    private Set<LoanDTO> loans = new HashSet<>();

    public CustomerResponseDTO(){}

    public CustomerResponseDTO(String name) {
        this.name = name;
    }

    public CustomerResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CustomerResponseDTO(Customer customer){
        this.id = customer.getId();
        this.name = customer.getName();
        this.loans = customer.getLoans().stream().map(LoanDTO::new).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<LoanDTO> getLoans() {
        return loans;
    }

}
