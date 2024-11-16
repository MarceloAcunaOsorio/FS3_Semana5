package com.nuevo.proyecto.Service;

import java.util.Optional;

import com.nuevo.proyecto.Model.Rol;

public interface RolService {
    
     public Optional<Rol> findByname(String name);
}
