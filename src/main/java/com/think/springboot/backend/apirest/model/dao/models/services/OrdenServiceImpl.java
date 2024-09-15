package com.think.springboot.backend.apirest.model.dao.models.services;

import com.think.springboot.backend.apirest.model.dao.IOrdenDao;
import com.think.springboot.backend.apirest.models.entity.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdenServiceImpl implements IOrdenService {

    @Autowired
    private IOrdenDao ordenDao;

    @Override
    @Transactional(readOnly = true)
    public List<Orden> findAll() {
        return (List<Orden>) ordenDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Orden findById(Long id) {
        return ordenDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Orden save(Orden orden) {
        return ordenDao.save(orden);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ordenDao.deleteById(id);
    }
}
