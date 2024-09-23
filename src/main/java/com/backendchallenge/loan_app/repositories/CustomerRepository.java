package com.backendchallenge.loan_app.repositories;

import com.backendchallenge.loan_app.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
