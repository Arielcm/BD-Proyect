package com.bd.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.entity.Cliente;
import com.bd.repository.ClienteRepository;


@Service
public class ClienteSeriveImp implements ClienteService{

	@Autowired
	ClienteRepository repository;
	
	@Override
	public Iterable<Cliente> getAllCliente() {
		return repository.findAll();
	}

	@Override
	public Cliente getClienteById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El Cliente no Existe"));
	}

}
