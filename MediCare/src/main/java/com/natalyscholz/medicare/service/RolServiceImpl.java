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
import com.natalyscholz.medicare.repository.RolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> getRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol getRol(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public Rol getRolPorNombre(String nombre) {
        return rolRepository.findByNombre(nombre).orElse(null);
    }

    @Override
    public void save(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void delete(Rol rol) {
        rolRepository.delete(rol);
    }
}
