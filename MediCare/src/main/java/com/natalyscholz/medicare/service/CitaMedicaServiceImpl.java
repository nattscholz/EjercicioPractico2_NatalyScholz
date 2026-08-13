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
import com.natalyscholz.medicare.repository.CitaMedicaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaMedicaServiceImpl implements CitaMedicaService {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    @Override
    public List<CitaMedica> getCitasMedicas() {
        return citaMedicaRepository.findAll();
    }

    @Override
    public CitaMedica getCitaMedica(Long id) {
        return citaMedicaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CitaMedica citaMedica) {
        citaMedicaRepository.save(citaMedica);
    }

    @Override
    public void delete(CitaMedica citaMedica) {
        citaMedicaRepository.delete(citaMedica);
    }

    @Override
    public List<CitaMedica> getCitasPorEstado(boolean activa) {
        return citaMedicaRepository.findByActiva(activa);
    }

    @Override
    public List<CitaMedica> getCitasPorRangoFechas(
            LocalDate fechaInicio,
            LocalDate fechaFin) {
        return citaMedicaRepository.findByFechaBetween(
                fechaInicio,
                fechaFin
        );
    }

    @Override
    public List<CitaMedica> getCitasPorEspecialidad(
            String especialidad) {
        return citaMedicaRepository
                .findByEspecialidadContainingIgnoreCase(especialidad);
    }
}