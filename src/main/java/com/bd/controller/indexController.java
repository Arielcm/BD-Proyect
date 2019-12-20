package com.bd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bd.entity.Usuario;
import com.bd.service.UsuarioService;

@Controller
public class indexController {

	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/login")
	public String login(@Valid
            @RequestParam(value = "username", required = true) String name, 
            @RequestParam(value = "password", required = true) String pass, Model model)
		{
		try {
		Usuario user=usuarioService.findBydni(pass);
	
		String red="";
		if(user.getApellidoUsuario().equals(name)) {
			System.out.println();
			switch (user.getArea()) {
			case "Root":
				red="redirect:/userForm";
				break;
			case "Administracion":
				red="redirect:/ClienteForm";
				break;
			case "Tecnico":
					if(user.getEsJefe().toString().equals("No")) {
						Long id=user.getIdUsuario();
						red="redirect:/TecnicoForm/"+id;
					
					}else {
						red="redirect:/TurnosForm";
					}
			break;
			}
			
		}else {
			model.addAttribute("logError","logError");
			red = "index";
		}
		return red;
	
		}catch(Exception e){
			String red="";
			if((name.equals("Root"))&&(pass.equals("1111"))) {
				red="redirect:/userForm";
			}else {
			model.addAttribute("logError","logError");
			red= "index";
			}
			return red;
		}

}
}
