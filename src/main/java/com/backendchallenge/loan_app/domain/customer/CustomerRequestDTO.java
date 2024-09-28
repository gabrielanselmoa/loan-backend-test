package com.backendchallenge.loan_app.domain.customer;

import com.backendchallenge.loan_app.domain.loan.Loan;
import com.backendchallenge.loan_app.domain.loan.LoanDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerRequestDTO {

    private String name;
    private int age;
    private String cpf;
    private Double income;
    private String location;

    private List<LoanDTO> loans = new ArrayList<>();

    public CustomerRequestDTO(){}

    public CustomerRequestDTO(String name, int age, String cpf, Double income, String location) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.income = income;
        this.location = location;
    }

    public CustomerRequestDTO(Customer customer){
        this.name = customer.getName();
        this.age = customer.getAge();
        this.cpf = customer.getCpf();
        this.income = customer.getIncome();
        this.location = customer.getLocation();
        this.loans = customer.getLoans().stream()
                .map(LoanDTO::new)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<LoanDTO> getLoans() {
        return loans;
    }
}
