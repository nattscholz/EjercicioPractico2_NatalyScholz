/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.natalyscholz.medicare.domain;

/**
 *
 * @author natts
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cita_medica")
public class CitaMedica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "paciente_nombre", length = 150)
    private String pacienteNombre;

    @Column(name = "especialidad", length = 100)
    private String especialidad;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "costo")
    private Double costo;

    @Column(name = "activa")
    private boolean activa = true;

    public CitaMedica() {
    }

    public CitaMedica(Long id, String pacienteNombre, String especialidad,
            LocalDate fecha, Double costo, boolean activa) {
        this.id = id;
        this.pacienteNombre = pacienteNombre;
        this.especialidad = especialidad;
        this.fecha = fecha;
        this.costo = costo;
        this.activa = activa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
