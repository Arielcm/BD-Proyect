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
import com.bd.service.ClienteService;
import com.bd.service.TurnoService;
import com.bd.service.UsuarioService;

@Controller
public class TecnicoController {
	@Autowired
	TurnoService turnoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ClienteService clienteService;

	@GetMapping("/TecnicoForm/{id}")
	public String TurnosForm(Model model, @PathVariable(name="id") String id) {
		model.addAttribute("TurnosForm", new Turno());
		model.addAttribute("listaturnos",turnoService.findAllByidUsuario(id));
		model.addAttribute("listTab","active");
		return "Tecnico/tareas-view";
	}
	
	@GetMapping("/TecnicoForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/TecnicoForm/{id}";
	}
	
	@GetMapping("/editTurnoTecnico/{idturno}/{idclte}")
	public String getEdiTurnoForm(Model model, @PathVariable(name="idturno") Long idturno, @PathVariable(name="idclte") Long idclte) throws Exception {
		Turno turno = turnoService.getTurnoById(idturno);
		model.addAttribute("TurnosForm", turno);
		model.addAttribute("usuarioss",clienteService.getClienteById(idclte));	
		model.addAttribute("formTab","active");
		model.addAttribute("editMode",true);//Mira siguiente seccion para mas informacion
		return "Tecnico/tareas-view";
	}
	
	@PostMapping("/tecnicoeditTurno")
	public String postEditUserForm(@ModelAttribute("TurnosForm")Turno turno, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("TurnosForm", turno);
			model.addAttribute("usuarios",usuarioService.getAllUsuariosbyarea("Tecnico"));
			model.addAttribute("usuarioss",clienteService.getAllCliente());
			model.addAttribute("formTab","active");
		}else {	
		try {
				System.out.println(turno.toString());	
				turnoService.updateTurno(turno);
				model.addAttribute("TurnosForm", new Turno());
				model.addAttribute("listaturnos",turnoService.findAllByidUsuario(turno.getIdUsuario()));
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formError",e.getMessage());
				model.addAttribute("TurnosForm", turno);
				model.addAttribute("formTab","active");
				model.addAttribute("listaturnos",turnoService.findAllByidUsuario(turno.getIdUsuario()));
				model.addAttribute("editMode","true");
			}
		
		}
		model.addAttribute("listaturnos",turnoService.findAllByidUsuario(turno.getIdUsuario()));
		return "/Tecnico/tareas-view";
		
	}
}
