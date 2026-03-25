package com.connor.expensetracker.service;

import com.connor.expensetracker.model.Expense;
import com.connor.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import com.connor.expensetracker.dto.ExpenseDTO;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public ExpenseDTO convertToDTO(Expense expense) {
        String categoryName = expense.getCategory() != null ? expense.getCategory().getName() : null;
        String username = expense.getUser() != null ? expense.getUser().getUsername() : null;

        return new ExpenseDTO(
                expense.getId(),
                expense.getDescription(),
                expense.getAmount(),
                expense.getDate(),
                categoryName,
                username
        );
    }
}
