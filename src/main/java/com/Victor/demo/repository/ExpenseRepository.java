package com.Victor.demo.repository;

import com.Victor.demo.model.Expense;
import com.Victor.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUser(User user);
}