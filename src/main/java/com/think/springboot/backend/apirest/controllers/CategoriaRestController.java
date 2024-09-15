package com.think.springboot.backend.apirest.controllers;

import com.think.springboot.backend.apirest.model.dao.models.services.ICategoriaService;
import com.think.springboot.backend.apirest.models.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/categorias")
public class CategoriaRestController {

    @Autowired
    private ICategoriaService categoriaService;

   
    @GetMapping
    public List<Categoria> index() {
        return categoriaService.findAll();
    }

    
    @GetMapping("/{id}")
    public Categoria show(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

   
    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    
    @PutMapping("/{id}")
    public Categoria update(@RequestBody Categoria categoria, @PathVariable Long id) {
        Categoria currentCategoria = categoriaService.findById(id);

        if (currentCategoria != null) {
            currentCategoria.setName(categoria.getName());
            return categoriaService.save(currentCategoria);
        } else {
            return null; 
        }
    }

    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoriaService.deleteById(id);
    }
}
