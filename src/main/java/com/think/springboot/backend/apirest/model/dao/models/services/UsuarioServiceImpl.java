package com.think.springboot.backend.apirest.model.dao.models.services;

import com.think.springboot.backend.apirest.model.dao.IUsuarioDao;
import com.think.springboot.backend.apirest.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        usuarioDao.deleteById(id);
    }
}
