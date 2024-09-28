package com.backendchallenge.loan_app.services;

import com.backendchallenge.loan_app.domain.customer.Customer;
import com.backendchallenge.loan_app.domain.customer.CustomerRequestDTO;
import com.backendchallenge.loan_app.domain.customer.CustomerResponseDTO;
import com.backendchallenge.loan_app.domain.loan.Loan;
import com.backendchallenge.loan_app.domain.loan.LoanDTO;
import com.backendchallenge.loan_app.repositories.CustomerRepository;
import com.backendchallenge.loan_app.repositories.LoanRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoanService {

    private LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }

    public List<LoanDTO> findAll(){
        var loans = loanRepository.findAll();
        if (loans.isEmpty()){
            throw new EntityNotFoundException("No loans were found!");
        }
        return loans.stream()
                .map(LoanDTO::new)
                .collect(Collectors.toList());
    }

    public LoanDTO createLoan(LoanDTO dto){
        var loan = new Loan();
        loan.setType(dto.getType());
        loan.setInterest_rate(dto.getInterest_rate());
        var loanSaved = loanRepository.save(loan);
        return new LoanDTO(loanSaved);
    }


}
