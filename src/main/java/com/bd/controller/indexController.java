package com.bd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
            @RequestParam(value = "password", required = true) String pass)
		{
			
		Usuario user=usuarioService.findBydni(pass);
	
		String red="";
		if(user.getApellidoUsuario().equals(name)) {
			System.out.println("Ingreso Correcto");
			
			switch (user.getArea()) {
			case "Root":
				red="redirect:/userForm";
				break;
			case "Administracion":
				red="redirect:/ClienteForm";
				break;
			case "Tecnico":
					if(user.getEsJefe().equals("Si")) {
					red="redirect:/TurnosForm";
					}else {
						System.out.println("Sale por aca");
					}
			break;
			}
			
		}else {
			System.out.println("Los Datos no Son Correctos");
		}
		return red;
		}
}
