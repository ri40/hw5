package com.example.bookmanagement.repo;

import com.example.bookmanagement.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository<Books, Integer> {
}
