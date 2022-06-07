package com.example.bookmanagement.controller;

import com.example.bookmanagement.DOT.Api;
import com.example.bookmanagement.model.User;
import com.example.bookmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        logger.info("Get Users");
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<Api> register(@RequestBody @Valid User user) throws IllegalAccessException {
        logger.info("Add Users");
        userService.addUser(user);
        return ResponseEntity.status(201).body(new Api("User added",201));
    }
}
