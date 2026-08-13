/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.natalyscholz.medicare.config;

/**
 *
 * @author natts
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class ManejadorInicioSesion
        implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication)
            throws IOException, ServletException {

        for (GrantedAuthority autoridad
                : authentication.getAuthorities()) {

            String rol = autoridad.getAuthority();

            if (rol.equals("ROLE_ADMIN")) {
                response.sendRedirect("/usuarios");
                return;
            }

            if (rol.equals("ROLE_MEDICO")) {
                response.sendRedirect("/citas");
                return;
            }

            if (rol.equals("ROLE_PACIENTE")) {
                response.sendRedirect("/citas");
                return;
            }
        }

        response.sendRedirect("/");
    }
}
