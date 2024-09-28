package com.backendchallenge.loan_app.services.interfaces.impl;

import com.backendchallenge.loan_app.domain.customer.Customer;
import com.backendchallenge.loan_app.services.interfaces.ILoanType;

public class GuaranteedLoanTypeImpl implements ILoanType {

    @Override
    public Boolean type(Customer customer) {

        if (customer.getIncome() > 5000){
            return false;
        }
        if (customer.getIncome() > 3000 && !customer.getLocation().equalsIgnoreCase("SP")){
            return false;
        }
        return true;
    }
}
