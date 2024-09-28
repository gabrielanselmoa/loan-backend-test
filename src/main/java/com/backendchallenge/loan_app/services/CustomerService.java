package com.backendchallenge.loan_app.services;

import com.backendchallenge.loan_app.domain.customer.Customer;
import com.backendchallenge.loan_app.domain.customer.CustomerRequestDTO;
import com.backendchallenge.loan_app.domain.customer.CustomerResponseDTO;
import com.backendchallenge.loan_app.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerLoanService customerLoanService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerLoanService customerLoanService){
        this.customerRepository = customerRepository;
        this.customerLoanService = customerLoanService;
    }

    public List<CustomerResponseDTO> findAll(){
        var customers = customerRepository.findAll();
        if (customers.isEmpty()){
            throw new EntityNotFoundException("No customers were found!");
        }

        return customers.stream()
                .map(CustomerResponseDTO::new)
                .collect(Collectors.toList());
    }

    public CustomerResponseDTO findById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()){
            throw new EntityNotFoundException("No customer were found!");
        }
        var customerLoan = customerLoanService.loanAssign(customer.get());
        return customerLoan;
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
