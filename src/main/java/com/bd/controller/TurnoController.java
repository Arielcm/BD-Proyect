package com.bd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bd.entity.Turno;
import com.bd.service.TurnoService;

@Controller
public class TurnoController {

	@Autowired
	TurnoService turnoService;
	
	@GetMapping("/TurnosForm")
	public String TurnosForm(Model model) {
		model.addAttribute("TurnoForm", new Turno());
		model.addAttribute("listaturnos",turnoService.getAllTurnos());
		model.addAttribute("listTab","active");
		return "turnos/turno-view";
	}
}
