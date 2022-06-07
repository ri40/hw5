package com.example.bookmanagement.controller;

import com.example.bookmanagement.DOT.Api;
import com.example.bookmanagement.model.Books;
import com.example.bookmanagement.service.BooksService;
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
@RequestMapping("api/v1/book")
public class BooksController {

    private final BooksService booksService;

    Logger logger= LoggerFactory.getLogger(BooksController.class);

    @GetMapping
    public ResponseEntity<List<Books>> getBooks(){
        logger.info("Get Books");
        return ResponseEntity.status(200).body(booksService.getBooks());
    }

    @PostMapping
    public ResponseEntity<Api> addBook(@RequestBody @Valid Books books){
        logger.info("Add Books");
        booksService.addBook(books);
        return ResponseEntity.status(201).body(new Api("Book added",201));
    }

    @GetMapping("{id}")
    public ResponseEntity getBookId(@PathVariable Integer id){
        logger.info("Get Book");
        return ResponseEntity.status(200).body(booksService.getBookId(id));
    }
    /////////////===================//////////////
    @PostMapping("lendBook/{bookId}/{userId}")
    public ResponseEntity<?> lendBook(@PathVariable Integer bookId  , @PathVariable Integer userId ){
        booksService.lendBook(bookId,userId);
        return ResponseEntity.status(200).body("Lend Book");
    }

    @PostMapping("return/{bookId}")
    public ResponseEntity returnBook(@PathVariable Integer bookId) {
        booksService.returnBook(bookId);
        return ResponseEntity.status(200).body("Return the loan book");
    }
}
