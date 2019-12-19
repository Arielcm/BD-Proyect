package com.bd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bd.entity.Turno;
import com.bd.entity.Usuario;

@Repository
public interface TurnoRepository extends CrudRepository<Turno, Long>{

	public Iterable<Turno> findAllByidUsuario(String idUsuario);
}
