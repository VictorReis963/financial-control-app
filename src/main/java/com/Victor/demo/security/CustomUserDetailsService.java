package com.Victor.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.Victor.demo.repository.UserRepository;

// marca a classe como um servico gerenciado pelo spring
// o spring cria automaticamente uma instancia e injeta onde for preciso
@Service
public class CustomUserDetailsService implements UserDetailsService {

    // repositorio responsavel por acessar os dados do usuario no banco
    private final UserRepository repository;

    // construtor  para injetar o repositorio
    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // busca o usuario pelo username no banco
        // se nao encontrar lança uma excecao de usuario nao encontrado
        var user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // cria um objeto User do spring security
        // define username senha e papel do usuario
        // esse objeto sera usado pelo spring para validar autenticacao
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}