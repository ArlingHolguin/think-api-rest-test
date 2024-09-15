package com.think.springboot.backend.apirest.model.dao.models.services;

import com.think.springboot.backend.apirest.models.entity.Rol;
import java.util.List;

public interface IRolService {
    List<Rol> findAll();
    Rol save(Rol rol);
    Rol findById(Long id);
    void deleteById(Long id);
}
