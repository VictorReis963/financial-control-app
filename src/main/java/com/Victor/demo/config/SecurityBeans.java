package com.Victor.demo.config;

/** beans são objetos geradas automaticamente;
 exp:
 * cria UM objeto e guarda ele pra mim
 * quando alguem precisar eu entrego automaticamente**/
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// indica que essa classe contem configuracoes do spring
// o spring vai ler essa classe ao iniciar a aplicacao
@Configuration
public class SecurityBeans {

    // define um bean que sera gerenciado pelo spring
    // esse bean sera usado para criptografar senhas
    @Bean
    public PasswordEncoder passwordEncoder() {

        // retorna uma instancia de BCryptPasswordEncoder
        // bcrypt aplica hash seguro na senha antes de salvar no banco
        return new BCryptPasswordEncoder();
    }
}