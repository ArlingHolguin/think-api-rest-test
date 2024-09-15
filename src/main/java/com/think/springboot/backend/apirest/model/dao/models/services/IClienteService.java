package com.think.springboot.backend.apirest.model.dao.models.services;

import java.util.List;

import com.think.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();

}
