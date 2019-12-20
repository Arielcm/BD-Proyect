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

import com.bd.entity.Cliente;
import com.bd.entity.Turno;
import com.bd.entity.Usuario;
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
	public String TurnosForm(Model model, @PathVariable(name="id") String id) throws Exception {
		model.addAttribute("TurnosForm", new Turno());
		model.addAttribute("listaturnos",turnoService.findAllByidUsuario(id));
		model.addAttribute("listTab","active");
		return "Tecnico/tareas-view";
	}
	
	@GetMapping("/editTurnoTecnico/{idturno}")
	public String getEdiTurnoForm(Model model, @PathVariable(name="idturno") Long idturno) throws Exception {
		Turno turno = turnoService.getTurnoById(idturno);
		model.addAttribute("TurnosForm", turno);
		model.addAttribute("formTab","active");
		model.addAttribute("editMode",true);//Mira siguiente seccion para mas informacion
		return "Tecnico/tareas-view";
	}
	
	@PostMapping("/tecnicoeditTurno")
	public String postEditUserForm(@ModelAttribute("TurnosForm")Turno turno, BindingResult result, ModelMap model) {
		String Estado=turno.getEstadoTurno();
		
		if(result.hasErrors()) {
			model.addAttribute("TurnosForm", turno);
			model.addAttribute("usuarios",usuarioService.getAllUsuariosbyarea("Tecnico"));
			model.addAttribute("formTab","active");
		}else {	
		try {
				turno=turnoService.getTurnoById(turno.getIdTurno());
				turno.setEstadoTurno(Estado);
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
	
	@GetMapping("/detalleCliente/{idCliente}")
	public String getUserInformation(Model model,@PathVariable(name="idCliente") Long idclte) throws Exception {
		model.addAttribute("usuarioss", new Cliente());
		model.addAttribute("usuarioss", clienteService.getClienteById(idclte));
		model.addAttribute("formTab","active");
		model.addAttribute("editMode",true);//Mira siguiente seccion para mas informacion
		return "Tecnico/DetalleCliente";
	}
}
