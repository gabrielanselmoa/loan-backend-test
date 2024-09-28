package com.backendchallenge.loan_app.services;

import com.backendchallenge.loan_app.domain.customer.Customer;
import com.backendchallenge.loan_app.domain.customer.CustomerRequestDTO;
import com.backendchallenge.loan_app.domain.customer.CustomerResponseDTO;
import com.backendchallenge.loan_app.domain.loan.LoanDTO;
import com.backendchallenge.loan_app.repositories.CustomerRepository;
import com.backendchallenge.loan_app.repositories.LoanRepository;
import com.backendchallenge.loan_app.services.interfaces.impl.ConsignmentLoanTypeImpl;
import com.backendchallenge.loan_app.services.interfaces.impl.GuaranteedLoanTypeImpl;
import com.backendchallenge.loan_app.services.interfaces.impl.PersonalLoanTypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerLoanService {

    private CustomerRepository customerRepository;
    private LoanRepository loanRepository;

    @Autowired
    public CustomerLoanService(CustomerRepository customerRepository, LoanRepository loanRepository){
        this.customerRepository = customerRepository;
        this.loanRepository = loanRepository;
    }

    // this method will return a user assigned or not with its loans access.
    // Also, it will use the LoanTypeImpl services to assign it
    public CustomerResponseDTO loanAssign(Customer customer){

        var personal = new PersonalLoanTypeImpl();
        var consignment = new ConsignmentLoanTypeImpl();
        var guaranteed = new GuaranteedLoanTypeImpl();

        if (personal.type(customer)){
            customer.getLoans().add(loanRepository.findByType("PERSONAL"));
        };
        if (consignment.type(customer)){
            customer.getLoans().add(loanRepository.findByType("CONSIGNMENT"));
        }
        if (guaranteed.type(customer)) {
            customer.getLoans().add(loanRepository.findByType("GUARANTEED"));
        }

        return new CustomerResponseDTO(customer);
    }
}
