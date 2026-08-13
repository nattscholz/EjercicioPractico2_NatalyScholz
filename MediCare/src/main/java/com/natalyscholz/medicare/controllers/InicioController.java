/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.natalyscholz.medicare.controllers;

/**
 *
 * @author natts
 */


import com.natalyscholz.medicare.service.CitaMedicaService;
import com.natalyscholz.medicare.service.RolService;
import com.natalyscholz.medicare.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    private CitaMedicaService citaMedicaService;

    @GetMapping("/")
    public String inicio(Model model) {

        model.addAttribute(
                "totalUsuarios",
                usuarioService.getUsuarios().size()
        );

        model.addAttribute(
                "totalRoles",
                rolService.getRoles().size()
        );

        model.addAttribute(
                "totalCitas",
                citaMedicaService.getCitasMedicas().size()
        );

        return "index";
    }
}