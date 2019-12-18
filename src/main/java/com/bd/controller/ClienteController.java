package com.bd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bd.entity.Turno;
import com.bd.service.ClienteService;
import com.bd.service.TurnoService;

@Controller
public class ClienteController {

	@Autowired
	TurnoService turnoService;
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/ClienteForm")
	public String ClienteForm(Model model) {
		model.addAttribute("ClienteForm", new Turno());
		model.addAttribute("usuarios",clienteService.getAllCliente());
		return "Cliente/cliente-view";
	}
}
