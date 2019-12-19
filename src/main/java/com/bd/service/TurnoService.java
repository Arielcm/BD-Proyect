package com.bd.service;

import com.bd.entity.Turno;
import com.bd.entity.Usuario;



public interface TurnoService {

	public Iterable<Turno> getAllTurnos();
	
	public Iterable<Turno> findAllByidUsuario(String idUsuario);
	
	public Turno createTurno(Turno TurnoForm) throws Exception;
	
	public Turno getTurnoById(Long id) throws Exception;
	
	public Turno updateTurno(Turno TurnoForm) throws Exception;
	
	public void deleteTurno(Long id) throws Exception;
}
