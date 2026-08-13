/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.natalyscholz.medicare.config;

/**
 *
 * @author natts
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Autowired
    private ManejadorInicioSesion manejadorInicioSesion;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(autorizar -> autorizar

                // Recursos y páginas públicas
                .requestMatchers(
                        "/webjars/**",
                        "/css/**",
                        "/images/**",
                        "/login",
                        "/registro",
                        "/registro/guardar",
                        "/error"
                ).permitAll()

                // Solamente ADMIN
                .requestMatchers(
                        "/usuarios/**",
                        "/roles/**"
                ).hasRole("ADMIN")

                // ADMIN y MEDICO pueden gestionar citas
                .requestMatchers(
                        "/citas/nueva",
                        "/citas/guardar",
                        "/citas/editar/**",
                        "/citas/eliminar/**"
                ).hasAnyRole("ADMIN", "MEDICO")

                // Los tres roles pueden visualizar citas
                .requestMatchers(
                        "/citas",
                        "/citas/detalle/**",
                        "/consultas/**"
                ).hasAnyRole(
                        "ADMIN",
                        "MEDICO",
                        "PACIENTE"
                )

                // Las demás páginas requieren autenticación
                .anyRequest().authenticated()
                )

                .formLogin(formulario -> formulario
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(manejadorInicioSesion)
                .failureUrl("/login?error")
                .permitAll()
                )

                .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                );

        return http.build();
    }
}
