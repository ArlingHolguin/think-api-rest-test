package com.think.springboot.backend.apirest.controllers;

import com.think.springboot.backend.apirest.model.dao.models.services.IUsuarioService;
import com.think.springboot.backend.apirest.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    
    @GetMapping
    public List<Usuario> index() {
        return usuarioService.findAll();
    }

    
    @GetMapping("/{id}")
    public Usuario show(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

   
    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    
    @PutMapping("/{id}")
    public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
        Usuario currentUsuario = usuarioService.findById(id);

        if (currentUsuario != null) {
            currentUsuario.setUsername(usuario.getUsername());
            currentUsuario.setPassword(usuario.getPassword());
            currentUsuario.setEnabled(usuario.isEnabled());
            currentUsuario.setRoles(usuario.getRoles());
            return usuarioService.save(currentUsuario);
        } else {
            
            return null; 
        }
    }

   
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
}
