package com.bd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.entity.Usuario;
import com.bd.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	UsuarioRepository repository;
	
	@Override
	public Iterable<Usuario> getAllUsuarios() {
		return repository.findAll();
	}

	@Override
	public Usuario createUser(Usuario usuario) throws Exception {
		usuario = repository.save(usuario);		
		return usuario;
	}

}
