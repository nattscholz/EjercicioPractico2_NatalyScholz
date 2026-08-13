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
import java.util.List;

public interface UsuarioService {

    List<Usuario> getUsuarios();

    Usuario getUsuario(Long id);

    Usuario getUsuarioPorEmail(String email);

    List<Usuario> getUsuariosPorRol(String nombreRol);

    void save(Usuario usuario);

    void delete(Usuario usuario);
}
