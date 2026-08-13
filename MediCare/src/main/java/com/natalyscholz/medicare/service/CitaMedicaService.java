/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.natalyscholz.medicare.service;

/**
 *
 * @author natts
 */

import com.natalyscholz.medicare.domain.CitaMedica;
import java.time.LocalDate;
import java.util.List;

public interface CitaMedicaService {

    List<CitaMedica> getCitasMedicas();

    CitaMedica getCitaMedica(Long id);

    void save(CitaMedica citaMedica);

    void delete(CitaMedica citaMedica);

    List<CitaMedica> getCitasPorEstado(boolean activa);

    List<CitaMedica> getCitasPorRangoFechas(
            LocalDate fechaInicio,
            LocalDate fechaFin
    );

    List<CitaMedica> getCitasPorEspecialidad(String especialidad);
}