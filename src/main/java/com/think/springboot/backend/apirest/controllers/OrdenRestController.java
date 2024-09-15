package com.think.springboot.backend.apirest.controllers;

import com.think.springboot.backend.apirest.model.dao.models.services.IOrdenService;
import com.think.springboot.backend.apirest.models.entity.Orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200"})
public class OrdenRestController {

    @Autowired
    private IOrdenService ordenService;

    @GetMapping("/ordenes")
    public List<Orden> index() {
        return ordenService.findAll();
    }

    @GetMapping("/ordenes/{id}")
    public Orden show(@PathVariable Long id) {
        return ordenService.findById(id);
    }

    @PostMapping("/ordenes")
    public Orden create(@RequestBody Orden orden) {
        return ordenService.save(orden);
    }

    @PutMapping("/ordenes/{id}")
    public Orden update(@RequestBody Orden orden, @PathVariable Long id) {
        Orden ordenActual = ordenService.findById(id);
        if (ordenActual != null) {
            ordenActual.setCliente(orden.getCliente());
            ordenActual.setDetalles(orden.getDetalles());
            ordenActual.setFecha(orden.getFecha());
            return ordenService.save(ordenActual);
        }
        return null;
    }

    @DeleteMapping("/ordenes/{id}")
    public void delete(@PathVariable Long id) {
        ordenService.delete(id);
    }
}
