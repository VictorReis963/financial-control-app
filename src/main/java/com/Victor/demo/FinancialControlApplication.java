package com.Victor.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// define o ponto de entrada principal da aplicacao spring boot
// a anotacao SpringBootApplication ativa configuracao automatica
// escaneamento de componentes e configuracao da aplicacao
@SpringBootApplication
public class FinancialControlApplication {

	// metodo principal responsavel por iniciar a aplicacao
	// SpringApplication executa o bootstrap do projeto
	// carrega o contexto do spring e inicia o servidor embarcado
	public static void main(String[] args) {
		SpringApplication.run(FinancialControlApplication.class, args);
	}

}