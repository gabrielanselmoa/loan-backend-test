package com.backendchallenge.loan_app.services.interfaces;

import com.backendchallenge.loan_app.domain.customer.Customer;
import com.backendchallenge.loan_app.domain.customer.CustomerRequestDTO;
import com.backendchallenge.loan_app.domain.customer.CustomerResponseDTO;
import com.backendchallenge.loan_app.domain.loan.Loan;
import com.backendchallenge.loan_app.domain.loan.LoanDTO;

public interface ILoanType {

    public Boolean type(Customer customer);
}
