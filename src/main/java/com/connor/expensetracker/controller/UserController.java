package com.connor.expensetracker.controller;

import com.connor.expensetracker.dto.UserDTO;
import com.connor.expensetracker.model.User;
import com.connor.expensetracker.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Get all users
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(userService::convertToDTO)
                .toList();
    }

    // Get user by id
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(userService::convertToDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
