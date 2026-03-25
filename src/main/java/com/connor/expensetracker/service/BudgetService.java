package com.connor.expensetracker.service;

import com.connor.expensetracker.model.Budget;
import com.connor.expensetracker.repository.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public Optional<Budget> getBudget(Long userId, Long categoryId, String month) {
        return budgetRepository.findByUserIdAndCategoryIdAndMonth(userId, categoryId, month);
    }
}