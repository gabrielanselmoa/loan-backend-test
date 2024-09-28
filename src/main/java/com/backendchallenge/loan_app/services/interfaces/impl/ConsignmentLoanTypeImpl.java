package com.backendchallenge.loan_app.services.interfaces.impl;

import com.backendchallenge.loan_app.domain.customer.Customer;
import com.backendchallenge.loan_app.services.interfaces.ILoanType;

public class ConsignmentLoanTypeImpl implements ILoanType {

    @Override
    public Boolean type(Customer customer) {

        if (customer.getIncome() < 5000){
            return false;
        }
        return true;
    }
}
