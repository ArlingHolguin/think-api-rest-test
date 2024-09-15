package com.think.springboot.backend.apirest.model.dao.models.services;

import com.think.springboot.backend.apirest.models.entity.Categoria;
import java.util.List;

public interface ICategoriaService {
    List<Categoria> findAll();
    Categoria save(Categoria categoria);
    Categoria findById(Long id);
    void deleteById(Long id);
}
