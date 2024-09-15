package com.think.springboot.backend.apirest.model.dao.models.services;

import com.think.springboot.backend.apirest.models.entity.Usuario;
import java.util.List;

public interface IUsuarioService {
    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    Usuario findById(Long id);
    Usuario findByUsername(String username);
    void deleteById(Long id);
}
