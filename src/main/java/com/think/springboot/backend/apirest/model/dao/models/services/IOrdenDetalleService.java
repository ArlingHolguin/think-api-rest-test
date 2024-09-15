package com.think.springboot.backend.apirest.model.dao.models.services;

import com.think.springboot.backend.apirest.models.entity.OrdenDetalle;
import java.util.List;

public interface IOrdenDetalleService {
    List<OrdenDetalle> findAll();
    OrdenDetalle findById(Long id);
    OrdenDetalle save(OrdenDetalle ordenDetalle);
    void delete(Long id);
}
