package com.Victor.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// define que essa classe e um controlador rest
// responsavel por receber requisicoes http e retornar respostas
@RestController
public class UserController {

    // define um endpoint get no caminho user me
    // esse endpoint retorna informacoes do usuario autenticado
    @GetMapping("/user/me")
    public String getLoggedUser(Authentication authentication) {

        // o objeto Authentication e injetado automaticamente pelo spring
        // ele contem os dados do usuario que fez login
        // getName retorna o username do usuario autenticado
        return "usuario logado " + authentication.getName();
    }
}