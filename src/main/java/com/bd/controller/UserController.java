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

import com.bd.entity.Usuario;
import com.bd.service.UsuarioService;

@Controller
public class UserController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/userForm")
	public String userForm(Model model) {
		model.addAttribute("userForm", new Usuario());
		model.addAttribute("listaUsuario",usuarioService.getAllUsuarios());
		return "user-form/user-view";
	}
	
	@PostMapping("/userForm")
	public String postUserForm(@Valid @ModelAttribute("userForm")Usuario user, BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("formTab","active");
		}else {
			try {//Aca tendras error porque este metodo no existe, pero lo crearemos en la siguiente seccion.
				usuarioService.createUser(user);
				model.addAttribute("userForm", new Usuario());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formError",e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab","active");
			}
		}

		model.addAttribute("userList", usuarioService.getAllUsuarios());
		return "user-form/user-view";
	}
}
