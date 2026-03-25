package com.connor.expensetracker.dto;

public class ExpenseSummaryDTO {

    private String categoryName;
    private double totalSpent;
    private double budget;
    private double remaining;

    public ExpenseSummaryDTO(String categoryName, double totalSpent, double budget, double remaining) {
        this.categoryName = categoryName;
        this.totalSpent = totalSpent;
        this.budget = budget;
        this.remaining = remaining;
    }

    // Getters
    public String getCategoryName() { return categoryName; }
    public double getTotalSpent() { return totalSpent; }
    public double getBudget() { return budget; }
    public double getRemaining() { return remaining; }
}