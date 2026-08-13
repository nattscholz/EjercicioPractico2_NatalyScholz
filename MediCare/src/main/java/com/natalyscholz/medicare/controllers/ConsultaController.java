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
import java.time.LocalDate;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConsultaController {

    @Autowired
    private CitaMedicaService citaMedicaService;

    @GetMapping("/consultas")
    public String mostrarConsultas(Model model) {

        model.addAttribute(
                "resultados",
                Collections.emptyList()
        );

        return "consulta/listado";
    }

    @GetMapping("/consultas/estado")
    public String buscarPorEstado(
            @RequestParam boolean activa,
            Model model) {

        model.addAttribute(
                "resultados",
                citaMedicaService.getCitasPorEstado(activa)
        );

        model.addAttribute(
                "mensaje",
                activa
                        ? "Citas médicas activas"
                        : "Citas médicas inactivas"
        );

        return "consulta/listado";
    }

    @GetMapping("/consultas/fechas")
    public String buscarPorFechas(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fechaInicio,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fechaFin,
            Model model) {

        model.addAttribute(
                "resultados",
                citaMedicaService.getCitasPorRangoFechas(
                        fechaInicio,
                        fechaFin
                )
        );

        model.addAttribute(
                "mensaje",
                "Citas entre " + fechaInicio
                        + " y " + fechaFin
        );

        return "consulta/listado";
    }

    @GetMapping("/consultas/especialidad")
    public String buscarPorEspecialidad(
            @RequestParam String especialidad,
            Model model) {

        model.addAttribute(
                "resultados",
                citaMedicaService
                        .getCitasPorEspecialidad(especialidad)
        );

        model.addAttribute(
                "mensaje",
                "Resultados para la especialidad: "
                        + especialidad
        );

        return "consulta/listado";
    }
}
