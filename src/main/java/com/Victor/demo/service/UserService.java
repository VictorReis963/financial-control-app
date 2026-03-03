package com.Victor.demo.service;

import com.Victor.demo.entity.User;
import com.Victor.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// marca a classe como servico gerenciado pelo spring
// o spring cria e injeta essa classe automaticamente quando necessario
@Service
public class UserService {

    // repositorio responsavel por acessar e salvar usuarios no banco
    private final UserRepository repository;

    // responsavel por criptografar senhas antes de salvar
    private final PasswordEncoder passwordEncoder;

    // construtor usado para injetar as dependencias
    public UserService(UserRepository repository,
                       PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    // metodo responsavel por registrar um novo usuario
    public User register(User user) {

        // pega a senha enviada pelo usuario
        // aplica criptografia usando passwordEncoder
        // substitui a senha original pela versao criptografada
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // salva o usuario ja com senha criptografada no banco
        // retorna o usuario salvo
        return repository.save(user);
    }
}