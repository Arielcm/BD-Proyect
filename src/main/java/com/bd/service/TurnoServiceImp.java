package com.bd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.entity.Turno;
import com.bd.repository.TurnoRepository;

@Service
public class TurnoServiceImp implements TurnoService{

	@Autowired
	TurnoRepository repository;
	
	@Override
	public Iterable<Turno> getAllTurnos() {
		return repository.findAll();
	}

}
