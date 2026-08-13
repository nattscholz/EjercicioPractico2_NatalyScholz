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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/usuarios")
    public String listar(Model model) {
        model.addAttribute(
                "usuarios",
                usuarioService.getUsuarios()
        );
        return "usuario/listado";
    }

    @GetMapping("/usuarios/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.getRoles());
        return "usuario/formulario";
    }

   @PostMapping("/usuarios/guardar")
    public String guardar(
            Usuario usuario,
            @RequestParam Long rolId) {

        Rol rol = rolService.getRol(rolId);

        if (rol == null) {
            return "redirect:/usuarios";
        }

        if (usuario.getId() != null) {

            Usuario usuarioExistente
                    = usuarioService.getUsuario(usuario.getId());

            if (usuarioExistente == null) {
                return "redirect:/usuarios";
            }

            if (usuario.getPassword() == null
                    || usuario.getPassword().isBlank()) {

                usuario.setPassword(
                        usuarioExistente.getPassword()
                );

            } else {

                usuario.setPassword(
                        passwordEncoder.encode(
                                usuario.getPassword()
                        )
                );
            }

        } else {

            usuario.setPassword(
                    passwordEncoder.encode(
                            usuario.getPassword()
                    )
            );
        }

        usuario.setRol(rol);
        usuarioService.save(usuario);

        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model) {

        Usuario usuario = usuarioService.getUsuario(id);

        if (usuario == null) {
            return "redirect:/usuarios";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", rolService.getRoles());

        return "usuario/formulario";
    }

    @GetMapping("/usuarios/detalle/{id}")
    public String detalle(
            @PathVariable Long id,
            Model model) {

        Usuario usuario = usuarioService.getUsuario(id);

        if (usuario == null) {
            return "redirect:/usuarios";
        }

        model.addAttribute("usuario", usuario);
        return "usuario/detalle";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        Usuario usuario = usuarioService.getUsuario(id);

        if (usuario != null) {
            usuarioService.delete(usuario);
        }

        return "redirect:/usuarios";
    }
}