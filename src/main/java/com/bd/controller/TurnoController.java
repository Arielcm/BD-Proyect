package com.bd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bd.entity.Turno;
import com.bd.entity.Usuario;
import com.bd.service.TurnoService;
import com.bd.service.UsuarioService;

@Controller
public class TurnoController {

	@Autowired
	TurnoService turnoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/TurnosForm")
	public String TurnosForm(Model model) {
		model.addAttribute("TurnosForm", new Turno());
		model.addAttribute("usuarios",usuarioService.getAllUsuarios());
		model.addAttribute("listaturnos",turnoService.getAllTurnos());
		model.addAttribute("listTab","active");
		return "turnos/turno-view";
	}
	
	@GetMapping("/TurnosForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/TurnosForm";
	}
	
	
	@PostMapping("/TurnosForm")
	public String postUserForm(@Valid @ModelAttribute("TurnosForm")Turno turno, BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			model.addAttribute("TurnosForm", turno);
			model.addAttribute("usuarios",usuarioService.getAllUsuarios());
			model.addAttribute("formTab","active");
		}else {
			try {
				turno.setEstadoTurno("Pendiente");
				turnoService.createTurno(turno);
				model.addAttribute("TurnosForm", new Turno());
				model.addAttribute("usuarios",usuarioService.getAllUsuarios());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formError",e.getMessage());
				model.addAttribute("TurnosForm", turno);
				model.addAttribute("formTab","active");
				model.addAttribute("usuarios",usuarioService.getAllUsuarios());
			}
		}

		model.addAttribute("listaturnos",turnoService.getAllTurnos());
		return "turnos/turno-view";
	}
	
	@GetMapping("/editTurno/{id}")
	public String getEdiTurnoForm(Model model, @PathVariable(name="id") Long id) throws Exception {
		Turno turno = turnoService.getTurnoById(id);
		model.addAttribute("listaturnos",turnoService.getAllTurnos());
		model.addAttribute("usuarios",usuarioService.getAllUsuarios());
		model.addAttribute("TurnosForm", turno);
		model.addAttribute("formTab","active");//Activa el tab del formulario.
		
		model.addAttribute("editMode",true);//Mira siguiente seccion para mas informacion
		
		return "turnos/turno-view";
	}
	
	@PostMapping("/editTurno")
	public String postEditUserForm(@Valid @ModelAttribute("TurnosForm")Turno turno, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("TurnosForm", turno);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
		}else {
			try {
				turno.setEstadoTurno("Pendiente");
				turnoService.createTurno(turno);
				model.addAttribute("TurnosForm", new Turno());
				model.addAttribute("usuarios",usuarioService.getAllUsuarios());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formError",e.getMessage());
				model.addAttribute("TurnosForm", turno);
				model.addAttribute("formTab","active");
				model.addAttribute("usuarios",usuarioService.getAllUsuarios());
				model.addAttribute("editMode","true");
			}
		}
		
		model.addAttribute("listaturnos",turnoService.getAllTurnos());
		return "redirect:/TurnosForm";
		
	}
	
	@GetMapping("/deleteTurno/{id}")
	public String deleteUser(Model model, @PathVariable(name="id") Long id) {
		try {
			turnoService.deleteTurno(id);
		} catch (Exception e) {
			model.addAttribute("deleteError","The user could not be deleted.");
		}
		return TurnosForm(model);
	}
}
