package com.Victor.demo.repository;

//spring framework Ela fornece métodos prontos para salvar,
// buscar, deletar e atualizar dados no banco.

import org.springframework.data.jpa.repository.JpaRepository;
import com.Victor.demo.entity.User;

// Optional é usado para evitar retornar null e diminuir risco
// de NullPointerException.
import java.util.Optional;

// Declara a interface UserRepository.
// Ela herda funcionalidades de JpaRepository.
public interface UserRepository extends JpaRepository<User, Long> {

    /** Método personalizado que busca um usuário pelo username.
     O Spring cria automaticamente a consulta SQL baseada no nome do método
    ele retorna um Optional<User>, o usuario pode existir ou não
     **/
    Optional<User> findByUsername(String username);
}
