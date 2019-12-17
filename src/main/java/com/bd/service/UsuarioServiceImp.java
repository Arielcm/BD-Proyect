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

	@Override
	public Usuario getUsuarioById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El Usuario para Editar no Existe"));
	}

	@Override
	public Usuario updateUser(Usuario fromUser) throws Exception {
		Usuario toUser = getUsuarioById(fromUser.getIdUsuario());
		mapUser(fromUser, toUser);
		return repository.save(toUser);
	}
	
	protected void mapUser(Usuario from,Usuario to) {
		to.setNombreUsuario(from.getNombreUsuario());
		to.setApellidoUsuario(from.getApellidoUsuario());
		to.setDni(from.getDni());
		to.setArea(from.getArea());
		to.setDireccionUsuario(from.getDireccionUsuario());
		to.setTelefonoUsuario(from.getTelefonoUsuario());
		to.setEsJefe(from.getEsJefe());
	}

	@Override
	public void deleteUser(Long id) throws Exception {
		Usuario user = repository.findById(id).orElseThrow(() -> new Exception("UsernotFound in deleteUser -"+this.getClass().getName()));
		repository.delete(user);
		
	}

	@Override
	public Usuario findBydni(String dni) {
		return repository.findBydni(dni);
		
	}


	

}
