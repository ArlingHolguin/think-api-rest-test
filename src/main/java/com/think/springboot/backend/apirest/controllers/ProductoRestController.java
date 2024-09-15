package com.think.springboot.backend.apirest.controllers;

import com.think.springboot.backend.apirest.model.dao.models.services.IProductoService;
import com.think.springboot.backend.apirest.models.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    @Autowired
    private IProductoService productoService;

   
    @GetMapping
    public List<Producto> index() {
        return productoService.findAll();
    }

    
    @GetMapping("/{id}")
    public Producto show(@PathVariable Long id) {
        return productoService.findById(id);
    }

    
    @PostMapping
    public Producto create(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    
    @PutMapping("/{id}")
    public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
        Producto currentProducto = productoService.findById(id);

        if (currentProducto != null) {
            currentProducto.setName(producto.getName());
            currentProducto.setFeatures(producto.getFeatures());
            currentProducto.setPriceUsd(producto.getPriceUsd());
            currentProducto.setPriceEur(producto.getPriceEur());
            currentProducto.setEmpresa(producto.getEmpresa());
            currentProducto.setCategorias(producto.getCategorias());
            return productoService.save(currentProducto);
        } else {
           
            return null; 
        }
    }

   
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productoService.deleteById(id);
    }
}
