package com.backendchallenge.loan_app.repositories;

import com.backendchallenge.loan_app.domain.loan.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashSet;
import java.util.Set;

public interface LoanRepository extends JpaRepository<Loan, Long> {

//    @Query("SELECT l FROM Loan l WHERE l.type = :type")
//    Loan findByType(@Param("type") String type);
    Loan findByType(String type);
}
