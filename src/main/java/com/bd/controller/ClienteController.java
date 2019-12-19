package com.bd.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.bd.entity.Turno;
import com.bd.service.ClienteService;
import com.bd.service.TurnoService;

@Controller
public class ClienteController {

	@Autowired
	TurnoService turnoServiceClte;
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/ClienteForm")
	public String ClienteForm(Model model) {
		model.addAttribute("TurnosForm", new Turno());
		model.addAttribute("usuarios",clienteService.getAllCliente());
		return "Cliente/cliente-view";
	}
	
	@GetMapping("/ClienteForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/ClienteForm";
	}
	
	@PostMapping("/ClienteForm")
	public String postUserForm(@Valid @ModelAttribute("TurnosForm")Turno turno, BindingResult result, ModelMap model) {
		turno.setEstadoTurno("Pendiente");
		turno.setIdUsuario("2");
/*
		System.out.println(turno.toString()+"Cliente");
		if(result.hasErrors()) {
			model.addAttribute("TurnosForm", turno);
			model.addAttribute("usuarioss",clienteService.getAllCliente());
			model.addAttribute("formTab","active");
		}else {*/
			try {

				System.out.println(turno.toString()+"Cliente");
				turnoServiceClte.createTurno(turno);
				model.addAttribute("TurnosForm", new Turno());
				model.addAttribute("usuarioss",clienteService.getAllCliente());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formError",e.getMessage());
				model.addAttribute("TurnosForm", turno);
				model.addAttribute("formTab","active");
				model.addAttribute("usuarioss",clienteService.getAllCliente());
			}
//		}
		model.addAttribute("usuarios",clienteService.getAllCliente());
		return "Cliente/cliente-view";
	}
}
