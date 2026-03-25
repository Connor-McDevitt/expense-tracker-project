package com.connor.expensetracker.dto;

import java.time.LocalDate;

public class ExpenseDTO {

    private Long id;
    private String description;
    private double amount;
    private LocalDate date;
    private String categoryName;
    private String username;

    // Constructors
    public ExpenseDTO() {}

    public ExpenseDTO(Long id, String description, double amount, LocalDate date, String categoryName, String username) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.categoryName = categoryName;
        this.username = username;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
