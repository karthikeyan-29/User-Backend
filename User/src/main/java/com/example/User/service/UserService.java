package com.example.User.service;

import com.example.User.model.User;
import com.example.User.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    // Constructor Injection
    public UserService(UserRepo userRepository) {
        this.userRepo = userRepository;
    }

    // Create User
    public User createUser(User user) {
        return userRepo.save(user);
    }

    // Get All Users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // Get User By Id
    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found with id: " + id)
                );
    }
}