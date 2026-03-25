package com.connor.expensetracker.dto;

import java.util.List;

public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private List<Long> expenseIds; // optional: list of expense IDs

    // Constructors
    public UserDTO() {}

    public UserDTO(Long id, String username, String email, List<Long> expenseIds) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.expenseIds = expenseIds;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Long> getExpenseIds() { return expenseIds; }
    public void setExpenseIds(List<Long> expenseIds) { this.expenseIds = expenseIds; }
}
