package com.example.bookmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Loan {

    @Id
    @NotEmpty(message = "id is required")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    @NotEmpty(message = "id is required")
    private Integer userId;
    @Column(nullable = false)
    @NotEmpty(message = "id is required")
    private Integer bookId;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Books>books;
}
