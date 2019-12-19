package com.bd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.entity.Turno;
import com.bd.entity.Usuario;
import com.bd.repository.TurnoRepository;

@Service
public class TurnoServiceImp implements TurnoService{

	@Autowired
	TurnoRepository repository;
	
	@Override
	public Iterable<Turno> getAllTurnos() {
		return repository.findAll();
	}

	@Override
	public Turno createTurno(Turno TurnoForm) throws Exception {
		TurnoForm = repository.save(TurnoForm);		
		return TurnoForm;
	}

	@Override
	public Turno getTurnoById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El Turno para Editar no Existe"));
	}
	
	@Override
	public Turno updateTurno(Turno fromForm) throws Exception {
		Turno toturno = getTurnoById(fromForm.getIdTurno());
		mapUser(fromForm, toturno);
		return repository.save(toturno);
	}

	protected void mapUser(Turno from,Turno to) {
		to.setEstadoTurno(from.getEstadoTurno());
		to.setFechaTurno(from.getFechaTurno());
		to.setIdUsuario(from.getIdUsuario());
	}

	@Override
	public void deleteTurno(Long id) throws Exception {
		Turno turno = repository.findById(id).orElseThrow(() -> new Exception("UsernotFound in deleteUser -"+this.getClass().getName()));
		repository.delete(turno);
		
	}

	@Override
	public Iterable<Turno> findAllByidUsuario(String idUsuario) {
		return repository.findAllByidUsuario(idUsuario);
	}

	

}
