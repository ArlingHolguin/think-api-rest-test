package com.think.springboot.backend.apirest.model.dao;

import org.springframework.data.repository.CrudRepository;
import com.think.springboot.backend.apirest.models.entity.Rol;

public interface IRolDao extends CrudRepository<Rol, Long> {
}
