package com.bd.service;

import com.bd.entity.Cliente;


public interface ClienteService {

	public Iterable<Cliente> getAllCliente();
	
	public Cliente getClienteById(Long id) throws Exception;
}
