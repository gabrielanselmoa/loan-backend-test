package com.backendchallenge.loan_app.services;

import com.backendchallenge.loan_app.domain.customer.CustomerResponseDTO;
import com.backendchallenge.loan_app.domain.loan.Loan;
import com.backendchallenge.loan_app.domain.loan.LoanDTO;
import com.backendchallenge.loan_app.repositories.CustomerRepository;
import com.backendchallenge.loan_app.repositories.LoanRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanEvaluationService {

    private CustomerRepository customerRepository;
    private LoanRepository loanRepository;

    @Autowired
    public LoanEvaluationService(CustomerRepository customerRepository, LoanRepository loanRepository) {
        this.customerRepository = customerRepository;
        this.loanRepository = loanRepository;
    }

    public CustomerResponseDTO evaluate(Long id, LoanDTO loanDTO){
        var customer = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Customer not found!"
        ));

        var loan = loanRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "Customer not found!"
        ));

        List<LoanDTO> list = new ArrayList<>();

        if (customer.getIncome() <= 3000){
            var newLoan = new Loan(null, "PERSONAL", 4.5);
            var tempLoan = new LoanDTO(newLoan);
            list.add(tempLoan);

        } else if (customer.getIncome() >= 3000 && customer.getIncome() <= 5000 || customer.getAge() < 30 && customer.getLocation().equals("SP")) {

        }
        customer.getLoans().add(list.stream().map(x -> new Loan().collect(Collectors.toSet()));
        return null;
    }
}
