/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.natalyscholz.medicare.service;

/**
 *
 * @author natts
 */

import com.natalyscholz.medicare.domain.Rol;
import java.util.List;

public interface RolService {

    List<Rol> getRoles();

    Rol getRol(Long id);

    Rol getRolPorNombre(String nombre);

    void save(Rol rol);

    void delete(Rol rol);
}