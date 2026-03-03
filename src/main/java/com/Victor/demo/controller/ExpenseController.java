package com.Victor.demo.controller;

import com.Victor.demo.model.Expense;
import com.Victor.demo.entity.User;
import com.Victor.demo.repository.ExpenseRepository;
import com.Victor.demo.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// define que essa classe e um controller rest
@RestController

// define rota base para todas as operacoes
@RequestMapping("/expenses")
public class ExpenseController {

    // repositorio para acessar despesas
    private final ExpenseRepository expenseRepository;

    // repositorio para acessar usuarios
    private final UserRepository userRepository;

    // injecao de dependencia via construtor
    public ExpenseController(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    // endpoint para criar nova despesa

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id,
                                 @RequestBody Expense updatedExpense,
                                 Authentication authentication) {

        User user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));

        if (!expense.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Você não pode editar essa despesa");
        }

        expense.setDescription(updatedExpense.getDescription());
        expense.setAmount(updatedExpense.getAmount());

        return expenseRepository.save(expense);
    }
    @PostMapping
    public Expense createExpense(@RequestBody Expense expense, Authentication authentication) {

        // pega username do usuario autenticado
        String username = authentication.getName();

        // busca usuario no banco
        User user = userRepository.findByUsername(username).orElseThrow();

        // associa despesa ao usuario logado
        expense.setUser(user);

        // salva despesa no banco
        return expenseRepository.save(expense);
    }

    // endpoint para listar despesas do usuario logado
    @GetMapping
    public List<Expense> getUserExpenses(Authentication authentication) {

        // pega username do usuario autenticado
        String username = authentication.getName();

        // busca usuario no banco
        User user = userRepository.findByUsername(username).orElseThrow();

        // retorna apenas despesas daquele usuario
        return expenseRepository.findByUser(user);
    }

    // endpoint para deletar despesa pelo id
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id,
                              Authentication authentication) {

        User user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));

        if (!expense.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Você não pode deletar essa despesa");
        }

        expenseRepository.delete(expense);
    }
}
