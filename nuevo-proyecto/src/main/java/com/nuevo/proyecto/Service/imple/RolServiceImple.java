package com.nuevo.proyecto.Service.imple;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.nuevo.proyecto.Model.Rol;
import com.nuevo.proyecto.Repository.RoleRepository;
import com.nuevo.proyecto.Service.RolService;

public class RolServiceImple implements RolService{
    
     @Autowired
    private RoleRepository roleRepository;
    @Override
    public Optional<Rol> findByname(String name) {
        return roleRepository.findByName(name);
    }
}
