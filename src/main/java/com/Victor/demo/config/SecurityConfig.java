package com.Victor.demo.config;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// indica que essa classe contem configuracoes de seguranca
// o spring vai carregar essas definicoes ao iniciar a aplicacao
@Configuration
public class SecurityConfig {

    // define o filtro principal de seguranca da aplicacao
    // SecurityFilterChain controla como as requisicoes http serao protegidas
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // desativa protecao csrf
                // comum em apis stateless que usam autenticacao via header
                .cors(cors -> {})
                .csrf(csrf -> csrf.disable())

                // define regras de autorizacao para as rotas
                .authorizeHttpRequests(auth -> auth

                        // permite acesso livre para rota de registro
                        .requestMatchers("/auth/register").permitAll()

                        // exige autenticacao para qualquer outra requisicao
                        .anyRequest().authenticated()
                )

                // ativa autenticacao basica via http basic
                // usuario e senha sao enviados no header da requisicao
                .httpBasic(httpBasic -> {});

        // constroi e retorna a configuracao final de seguranca
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}