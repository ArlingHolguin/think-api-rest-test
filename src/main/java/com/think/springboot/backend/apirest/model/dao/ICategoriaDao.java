package com.think.springboot.backend.apirest.model.dao;

import org.springframework.data.repository.CrudRepository;
import com.think.springboot.backend.apirest.models.entity.Categoria;

public interface ICategoriaDao extends CrudRepository<Categoria, Long> {
}
