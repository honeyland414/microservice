package com.example.userservice.service;


import com.example.userservice.pojo.User;
import com.example.userservice.pojo.LoginRequest;
import com.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUsernamePassword(LoginRequest request) {
        return userRepository.findByUsernamePassword(request.getUsername(), request.getPassword());
    }

}
