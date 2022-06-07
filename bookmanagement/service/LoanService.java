package com.example.bookmanagement.service;

import com.example.bookmanagement.model.Loan;
import com.example.bookmanagement.repo.LoanRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LoanService {
    private final LoanRepo loanRepo;
    private final BooksService booksService;
    public List<Loan> getLoans() {
        return loanRepo.findAll();
    }

    public void addLoan(Loan loan) {
        loanRepo.save(loan);
    }
}
