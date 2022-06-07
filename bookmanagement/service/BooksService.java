package com.example.bookmanagement.service;

import com.example.bookmanagement.exceptions.InvalidIdException;
import com.example.bookmanagement.model.Books;
import com.example.bookmanagement.model.Loan;
import com.example.bookmanagement.model.User;
import com.example.bookmanagement.repo.BooksRepo;
import com.example.bookmanagement.repo.LoanRepo;
import com.example.bookmanagement.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BooksService {
    private final BooksRepo booksRepo;
    private final UserRepo userRepo;
    private final LoanRepo loanRepo;
    public List<Books> getBooks() {
        return booksRepo.findAll();
    }
    public void addBook(Books books) {
        booksRepo.save(books);
    }
    public Books getBookId(Integer id) {
        return booksRepo.findById(id).get();
    }
    /////////////////================//////////////
    public void lendBook(Integer bookId, Integer userId) {
        Books books = booksRepo.findById(bookId).orElseThrow(()->new InvalidIdException("Invalid ID"));
        User user = userRepo.findById(userId).orElseThrow(()->new InvalidIdException("Invalid ID"));
        Loan loan = new Loan(null,userId,bookId,null);
        loanRepo.save(loan);
    }

    public void returnBook(Integer bookId) {
        Books books = booksRepo.findById(bookId).orElseThrow(()->new InvalidIdException("Invalid book ID"));
    }
}
