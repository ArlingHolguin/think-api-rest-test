package com.think.springboot.backend.apirest.controllers;

import com.think.springboot.backend.apirest.model.dao.models.services.IRolService;
import com.think.springboot.backend.apirest.models.entity.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/roles")
public class RolRestController {

    @Autowired
    private IRolService rolService;

    
    @GetMapping
    public List<Rol> index() {
        return rolService.findAll();
    }

   
    @GetMapping("/{id}")
    public Rol show(@PathVariable Long id) {
        return rolService.findById(id);
    }

    
    @PostMapping
    public Rol create(@RequestBody Rol rol) {
        return rolService.save(rol);
    }

    
    @PutMapping("/{id}")
    public Rol update(@RequestBody Rol rol, @PathVariable Long id) {
        Rol currentRol = rolService.findById(id);

        if (currentRol != null) {
            currentRol.setNombre(rol.getNombre());
            return rolService.save(currentRol);
        } else {
            
            return null; 
        }
    }

    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        rolService.deleteById(id);
    }
}
