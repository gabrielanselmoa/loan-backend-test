package com.backendchallenge.loan_app.repositories;

import com.backendchallenge.loan_app.domain.loan.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.Set;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
