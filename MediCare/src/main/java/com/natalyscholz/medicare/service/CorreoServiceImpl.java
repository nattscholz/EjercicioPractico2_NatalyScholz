/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.natalyscholz.medicare.service;

/**
 *
 * @author natts
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CorreoServiceImpl implements CorreoService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void enviarCorreoBienvenida(
            String destinatario,
            String nombre) {

        SimpleMailMessage mensaje
                = new SimpleMailMessage();

        mensaje.setTo(destinatario);
        mensaje.setSubject("Bienvenido a MediCare");

        mensaje.setText(
                "Hola " + nombre + ",\n\n"
                + "Su cuenta en MediCare fue creada "
                + "correctamente.\n\n"
                + "Ya puede iniciar sesión y consultar "
                + "las citas médicas disponibles.\n\n"
                + "Saludos,\n"
                + "Equipo MediCare"
        );

        javaMailSender.send(mensaje);
    }
}
