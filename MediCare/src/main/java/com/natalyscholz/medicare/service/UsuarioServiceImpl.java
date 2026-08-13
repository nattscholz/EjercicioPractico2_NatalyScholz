/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.natalyscholz.medicare.service;

/**
 *
 * @author natts
 */

import com.natalyscholz.medicare.domain.Usuario;
import com.natalyscholz.medicare.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario getUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<Usuario> getUsuariosPorRol(String nombreRol) {
        return usuarioRepository.findByRolNombre(nombreRol);
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}