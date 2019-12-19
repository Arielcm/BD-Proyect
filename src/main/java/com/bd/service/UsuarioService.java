package com.bd.service;

import com.bd.entity.Usuario;

public interface UsuarioService {

	public Iterable<Usuario> getAllUsuarios();
	
	public Iterable<Usuario> getAllUsuariosbyarea(String area);
	
	public Usuario createUser(Usuario formUser) throws Exception;
	
	public Usuario getUsuarioById(Long id) throws Exception;
	
	public Usuario updateUser(Usuario user) throws Exception;
	
	public void deleteUser(Long id) throws Exception;
	
	public Usuario findBydni(String dni);
}
