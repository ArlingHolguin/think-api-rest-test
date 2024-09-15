package com.think.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.think.springboot.backend.apirest.model.dao.models.services.IEmpresaService;
import com.think.springboot.backend.apirest.models.entity.Empresa;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/empresas")
public class EmpresaRestController {

	@Autowired
	private IEmpresaService empresaService;

	@GetMapping
	public List<Empresa> index() {
		return empresaService.findAll();
	}

	@GetMapping("/{nit}")
	public Empresa show(@PathVariable String nit) {
		return empresaService.findById(nit);
	}

	@PostMapping
	public Empresa create(@RequestBody Empresa empresa) {
		return empresaService.save(empresa);
	}

	@PutMapping("/{nit}")
	public Empresa update(@RequestBody Empresa empresa, @PathVariable String nit) {
		Empresa currentEmpresa = empresaService.findById(nit);

		if (currentEmpresa != null) {
			currentEmpresa.setName(empresa.getName());
			currentEmpresa.setAddress(empresa.getAddress());
			currentEmpresa.setPhone(empresa.getPhone());
			return empresaService.save(currentEmpresa);
		} else {

			return null;
		}
	}

	@DeleteMapping("/{nit}")
	public void delete(@PathVariable String nit) {
		empresaService.deleteById(nit);
	}
}
