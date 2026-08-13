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
import com.natalyscholz.medicare.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/roles")
    public String listar(Model model) {
        model.addAttribute("roles", rolService.getRoles());
        return "rol/listado";
    }

    @GetMapping("/roles/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("rol", new Rol());
        return "rol/formulario";
    }

    @PostMapping("/roles/guardar")
    public String guardar(Rol rol) {
        rolService.save(rol);
        return "redirect:/roles";
    }

    @GetMapping("/roles/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {

        Rol rol = rolService.getRol(id);

        if (rol == null) {
            return "redirect:/roles";
        }

        model.addAttribute("rol", rol);
        return "rol/formulario";
    }

    @GetMapping("/roles/detalle/{id}")
    public String detalle(@PathVariable Long id, Model model) {

        Rol rol = rolService.getRol(id);

        if (rol == null) {
            return "redirect:/roles";
        }

        model.addAttribute("rol", rol);
        return "rol/detalle";
    }

    @GetMapping("/roles/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        Rol rol = rolService.getRol(id);

        if (rol != null) {
            rolService.delete(rol);
        }

        return "redirect:/roles";
    }
}