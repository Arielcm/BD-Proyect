package com.bd.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bd.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	 public Usuario findBydni(String dni);
	 
	 public Iterable<Usuario> findByarea(String area);
}
