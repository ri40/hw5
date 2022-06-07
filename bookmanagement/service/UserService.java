package com.example.bookmanagement.service;

import com.example.bookmanagement.model.User;
import com.example.bookmanagement.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public List<User> getUsers() {
        return userRepo.findAll();
    }
    public void addUser(User user) throws IllegalAccessException{
        userRepo.save(user);
    }
}
