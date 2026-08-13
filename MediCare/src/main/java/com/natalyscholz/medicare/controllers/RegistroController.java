/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.natalyscholz.medicare.controllers;

/**
 *
 * @author natts
 */

import com.natalyscholz.medicare.domain.Rol;
import com.natalyscholz.medicare.domain.Usuario;
import com.natalyscholz.medicare.service.RolService;
import com.natalyscholz.medicare.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {

        model.addAttribute("usuario", new Usuario());

        return "registro";
    }

    @PostMapping("/registro/guardar")
    public String guardarRegistro(Usuario usuario) {

        Usuario usuarioExistente
                = usuarioService.getUsuarioPorEmail(
                        usuario.getEmail()
                );

        if (usuarioExistente != null) {
            return "redirect:/registro?existente";
        }

        Rol rolPaciente
                = rolService.getRolPorNombre("PACIENTE");

        if (rolPaciente == null) {
            return "redirect:/registro?error";
        }

        usuario.setPassword(
                passwordEncoder.encode(usuario.getPassword())
        );

        usuario.setRol(rolPaciente);
        usuario.setActivo(true);

        usuarioService.save(usuario);

        return "redirect:/login?registro";
    }
}