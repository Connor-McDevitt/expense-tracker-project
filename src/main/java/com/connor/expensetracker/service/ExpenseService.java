package com.connor.expensetracker.service;

import com.connor.expensetracker.model.Expense;
import com.connor.expensetracker.repository.BudgetRepository;
import com.connor.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;
import com.connor.expensetracker.dto.ExpenseDTO;

import java.util.List;
import java.util.Optional;
import com.connor.expensetracker.dto.ExpenseSummaryDTO;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    private final BudgetRepository budgetRepository;

    public ExpenseService(ExpenseRepository expenseRepository,
                          BudgetRepository budgetRepository) {
        this.expenseRepository = expenseRepository;
        this.budgetRepository = budgetRepository;
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

    public List<ExpenseSummaryDTO> getMonthlySummary(Long userId, String month) {

        return expenseRepository.findAll().stream()
                .filter(e -> e.getUser().getId().equals(userId))
                .collect(Collectors.groupingBy(e -> e.getCategory()))
                .entrySet()
                .stream()
                .map(entry -> {
                    var category = entry.getKey();

                    double totalSpent = entry.getValue()
                            .stream()
                            .mapToDouble(e -> e.getAmount())
                            .sum();

                    double budgetAmount = budgetRepository
                            .findByUserIdAndCategoryIdAndMonth(userId, category.getId(), month)
                            .map(b -> b.getAmount())
                            .orElse(0.0);

                    return new ExpenseSummaryDTO(
                            category.getName(),
                            totalSpent,
                            budgetAmount,
                            budgetAmount - totalSpent
                    );
                })
                .toList();
    }
}
