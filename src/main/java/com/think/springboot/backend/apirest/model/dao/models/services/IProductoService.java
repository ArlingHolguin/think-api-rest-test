package com.think.springboot.backend.apirest.model.dao.models.services;

import com.think.springboot.backend.apirest.models.entity.Producto;
import java.util.List;

public interface IProductoService {
    List<Producto> findAll();
    Producto save(Producto producto);
    Producto findById(Long id);
    void deleteById(Long id);
}
