package com.bd.service;

import com.bd.entity.Usuario;

public interface UsuarioService {

	public Iterable<Usuario> getAllUsuarios();
	
	public Usuario createUser(Usuario formUser) throws Exception;
}
