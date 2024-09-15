package com.think.springboot.backend.apirest.model.dao.models.services;

import com.think.springboot.backend.apirest.model.dao.IEmpresaDao;
import com.think.springboot.backend.apirest.models.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    @Autowired
    private IEmpresaDao empresaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Empresa> findAll() {
        return (List<Empresa>) empresaDao.findAll();
    }

    @Override
    @Transactional
    public Empresa save(Empresa empresa) {
        return empresaDao.save(empresa);
    }

    @Override
    @Transactional(readOnly = true)
    public Empresa findById(String nit) {
        return empresaDao.findById(nit).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(String nit) {
        empresaDao.deleteById(nit);
    }
}
