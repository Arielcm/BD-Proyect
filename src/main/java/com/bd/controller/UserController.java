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
		model.addAttribute("listTab","active");
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

		model.addAttribute("listaUsuario", usuarioService.getAllUsuarios());
		return "user-form/user-view";
	}
	
	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name="id") Long id) throws Exception {
		Usuario user = usuarioService.getUsuarioById(id);
		
		model.addAttribute("userList", usuarioService.getAllUsuarios());
		model.addAttribute("userForm", user);
		model.addAttribute("formTab","active");//Activa el tab del formulario.
		
		model.addAttribute("editMode",true);//Mira siguiente seccion para mas informacion
		
		return "user-form/user-view";
	}
	
	@PostMapping("/editUser")
	public String postEditUserForm(@Valid @ModelAttribute("userForm")Usuario user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
		}else {
			try {
				usuarioService.updateUser(user);
				model.addAttribute("userForm", new Usuario());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab","active");
				model.addAttribute("userList", usuarioService.getAllUsuarios());
				model.addAttribute("editMode","true");
			}
		}
		
		model.addAttribute("listaUsuario", usuarioService.getAllUsuarios());
		return "redirect:/userForm";
		
	}
	
	@GetMapping("/userForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/userForm";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name="id") Long id) {
		try {
			usuarioService.deleteUser(id);
		} catch (Exception e) {
			model.addAttribute("deleteError","The user could not be deleted.");
		}
		return userForm(model);
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/";
	}

	
}
