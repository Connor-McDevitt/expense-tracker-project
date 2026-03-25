package com.connor.expensetracker.repository;

import com.connor.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserId(Long userId);

    @Query("""
    SELECT SUM(e.amount) FROM Expense e
    WHERE e.user.id = :userId
    AND e.category.id = :categoryId
    AND FUNCTION('FORMATDATETIME', e.date, 'yyyy-MM') = :month
    """)
    Double getTotalSpentByUserAndCategoryAndMonth(
            @Param("userId") Long userId,
            @Param("categoryId") Long categoryId,
            @Param("month") String month
    );
}
