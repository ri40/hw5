package com.example.bookmanagement.repo;

import com.example.bookmanagement.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepo extends JpaRepository<Loan, Integer> {
}
