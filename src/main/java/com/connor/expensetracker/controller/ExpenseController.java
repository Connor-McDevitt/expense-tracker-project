package com.connor.expensetracker.controller;

import com.connor.expensetracker.model.Expense;
import com.connor.expensetracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import com.connor.expensetracker.dto.ExpenseDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Create new expense
    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }

    // Get all expenses
    @GetMapping
    public List<ExpenseDTO> getAllExpenses() {
        return expenseService.getAllExpenses()
                .stream()
                .map(expenseService::convertToDTO)
                .toList();
    }

    // Get expenses for a user
    @GetMapping("/user/{userId}")
    public List<ExpenseDTO> getExpensesByUser(@PathVariable Long userId) {
        return expenseService.getExpensesByUserId(userId)
                .stream()
                .map(expenseService::convertToDTO)
                .toList();
    }

    // Get expense by ID
    @GetMapping("/{id}")
    public Optional<Expense> getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    // Delete expense
    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "Expense deleted with id " + id;
    }
}
