package com.backendchallenge.loan_app.services;

import com.backendchallenge.loan_app.domain.customer.Customer;
import com.backendchallenge.loan_app.domain.customer.CustomerRequestDTO;
import com.backendchallenge.loan_app.domain.customer.CustomerResponseDTO;
import com.backendchallenge.loan_app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto){
        var customer = new Customer();
        customer.setName(dto.getName());
        customer.setAge(dto.getAge());
        customer.setCpf(dto.getCpf());
        customer.setIncome(dto.getIncome());
        customer.setLocation(dto.getLocation());
        var customerSaved = customerRepository.save(customer);
        return new CustomerResponseDTO(customerSaved);
    }

}
