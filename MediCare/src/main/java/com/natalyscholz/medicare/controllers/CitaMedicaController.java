/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.natalyscholz.medicare.controllers;

/**
 *
 * @author natts
 */

import com.natalyscholz.medicare.domain.CitaMedica;
import com.natalyscholz.medicare.service.CitaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CitaMedicaController {

    @Autowired
    private CitaMedicaService citaMedicaService;

    @GetMapping("/citas")
    public String listar(Model model) {

        model.addAttribute(
                "citas",
                citaMedicaService.getCitasMedicas()
        );

        return "cita/listado";
    }

    @GetMapping("/citas/nueva")
    public String nueva(Model model) {

        model.addAttribute(
                "citaMedica",
                new CitaMedica()
        );

        return "cita/formulario";
    }

    @PostMapping("/citas/guardar")
    public String guardar(CitaMedica citaMedica) {

        citaMedicaService.save(citaMedica);

        return "redirect:/citas";
    }

    @GetMapping("/citas/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model) {

        CitaMedica citaMedica
                = citaMedicaService.getCitaMedica(id);

        if (citaMedica == null) {
            return "redirect:/citas";
        }

        model.addAttribute("citaMedica", citaMedica);

        return "cita/formulario";
    }

    @GetMapping("/citas/detalle/{id}")
    public String detalle(
            @PathVariable Long id,
            Model model) {

        CitaMedica citaMedica
                = citaMedicaService.getCitaMedica(id);

        if (citaMedica == null) {
            return "redirect:/citas";
        }

        model.addAttribute("citaMedica", citaMedica);

        return "cita/detalle";
    }

    @GetMapping("/citas/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        CitaMedica citaMedica
                = citaMedicaService.getCitaMedica(id);

        if (citaMedica != null) {
            citaMedicaService.delete(citaMedica);
        }

        return "redirect:/citas";
    }
}
