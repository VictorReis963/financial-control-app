package com.Victor.demo.controller;

import com.Victor.demo.entity.User;
import com.Victor.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

// define que essa classe e um controlador rest
// permite que a aplicacao receba requisicoes http e retorne respostas em formato json
@RestController
@RequestMapping("/auth")
public class AuthController {

    // servico responsavel pelas regras de negocio relacionadas ao usuario
    private final UserService service;

    // construtor usado para injetar o servico automaticamente
    public AuthController(UserService service) {
        this.service = service;
    }

    // define que esse metodo responde a requisicoes post no caminho auth register
    // usado para cadastrar um novo usuario
    @PostMapping("/register")
    public User register(@RequestBody User user) {

        // recebe os dados enviados no corpo da requisicao
        // encaminha para o servico que executa a logica de registro
        // retorna o usuario salvo
        return service.register(user);
    }
}