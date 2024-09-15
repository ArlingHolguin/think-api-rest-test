package com.think.springboot.backend.apirest.model.dao.models.services;

import com.think.springboot.backend.apirest.model.dao.IOrdenDetalleDao;
import com.think.springboot.backend.apirest.models.entity.OrdenDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdenDetalleServiceImpl implements IOrdenDetalleService {

    @Autowired
    private IOrdenDetalleDao ordenDetalleDao;

    @Override
    @Transactional(readOnly = true)
    public List<OrdenDetalle> findAll() {
        return (List<OrdenDetalle>) ordenDetalleDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public OrdenDetalle findById(Long id) {
        return ordenDetalleDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public OrdenDetalle save(OrdenDetalle ordenDetalle) {
        return ordenDetalleDao.save(ordenDetalle);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ordenDetalleDao.deleteById(id);
    }
}
