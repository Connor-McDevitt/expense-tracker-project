package com.connor.expensetracker.service;

import com.connor.expensetracker.model.Expense;
import com.connor.expensetracker.model.User;
import com.connor.expensetracker.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.connor.expensetracker.dto.UserDTO;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserDTO convertToDTO(User user) {
        List<Long> expenseIds = user.getExpenses()
                .stream()
                .map(Expense::getId)
                .toList();

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                expenseIds
        );
    }
}
