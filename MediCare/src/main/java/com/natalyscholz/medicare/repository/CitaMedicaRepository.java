/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.natalyscholz.medicare.repository;

/**
 *
 * @author natts
 */

import com.natalyscholz.medicare.domain.CitaMedica;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaMedicaRepository
        extends JpaRepository<CitaMedica, Long> {

    List<CitaMedica> findByActiva(boolean activa);

    List<CitaMedica> findByFechaBetween(
            LocalDate fechaInicio,
            LocalDate fechaFin
    );

    List<CitaMedica> findByEspecialidadContainingIgnoreCase(
            String especialidad
    );
}
