package com.think.springboot.backend.apirest.model.dao.models.services;

import com.think.springboot.backend.apirest.models.entity.Empresa;
import java.util.List;

public interface IEmpresaService {
    List<Empresa> findAll();
    Empresa save(Empresa empresa);
    Empresa findById(String nit);
    void deleteById(String nit);
}
