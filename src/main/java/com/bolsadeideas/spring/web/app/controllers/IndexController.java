package com.bolsadeideas.spring.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.spring.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController{	
	
	@GetMapping({"/index", "/", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "hola spring framework");
		return "index";
}
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario= new Usuario();
		usuario.setNombre("Roger");
		usuario.setApellido("Luna");
		usuario.setEmail("roger@correo.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
		
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios=  Arrays.asList(
				new Usuario("Roger","Luna","roger@correo.com"),
				new Usuario("Mary","Alvarez","mary@correo.com"),
				new Usuario("Luis","Luna","lu@correo.com"),
				new Usuario("Martha","Cruz","mart@correo.com")
				);  
		
		
		
		
		model.addAttribute("titulo","Listado de Usuarios");
		model.addAttribute("usuarios",usuarios);
		return "listar";
	}
	
}
