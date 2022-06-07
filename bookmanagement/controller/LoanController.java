package com.example.bookmanagement.controller;

import com.example.bookmanagement.DOT.Api;
import com.example.bookmanagement.model.Loan;
import com.example.bookmanagement.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/loan")
public class LoanController {
    private final LoanService loanService;
    Logger logger= LoggerFactory.getLogger(LoanController.class);

    @GetMapping
    public ResponseEntity<List<Loan>> getLoans() {
        logger.info("Get Loans");
        return ResponseEntity.status(200).body(loanService.getLoans());
    }

    @PostMapping
    public ResponseEntity<Api> register(@RequestBody @Valid Loan loan) {
        logger.info("Add Loans");
        loanService.addLoan(loan);
        return ResponseEntity.status(201).body(new Api("Book loan added", 201));
    }
}
