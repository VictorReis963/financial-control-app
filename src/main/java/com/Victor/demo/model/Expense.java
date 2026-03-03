package com.Victor.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import com.Victor.demo.entity.User;

// define que essa classe representa uma tabela no banco de dados
@Entity
public class Expense {

    // identificador unico da despesa
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // descricao da despesa
    private String description;

    // valor da despesa
    private Double amount;

    // data em que a despesa ocorreu
    private LocalDate date;

    @JsonIgnore

    // relacionamento muitos para um
    // varias despesas pertencem a um unico usuario
    @ManyToOne

    // define a coluna que sera usada como chave estrangeira
    @JoinColumn(name = "user_id")
    private User user;

    // construtor vazio obrigatorio para o jpa
    public Expense() {}

    // construtor usado para criar nova despesa com todos os campos
    public Expense(String description, Double amount, LocalDate date, User user) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.user = user;
    }

    // retorna o id da despesa
    public Long getId() { return id; }

    // retorna a descricao
    public String getDescription() { return description; }

    // altera a descricao
    public void setDescription(String description) { this.description = description; }

    // retorna o valor
    public Double getAmount() { return amount; }

    // altera o valor
    public void setAmount(Double amount) { this.amount = amount; }

    // retorna a data
    public LocalDate getDate() { return date; }

    // altera a data
    public void setDate(LocalDate date) { this.date = date; }

    // retorna o usuario dono da despesa
    public User getUser() { return user; }

    // altera o usuario dono da despesa
    public void setUser(User user) { this.user = user; }
}