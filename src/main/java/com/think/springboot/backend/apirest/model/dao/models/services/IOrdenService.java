package com.think.springboot.backend.apirest.model.dao.models.services;

import com.think.springboot.backend.apirest.models.entity.Orden;
import java.util.List;

public interface IOrdenService {
    List<Orden> findAll();
    Orden findById(Long id);
    Orden save(Orden orden);
    void delete(Long id);
}
