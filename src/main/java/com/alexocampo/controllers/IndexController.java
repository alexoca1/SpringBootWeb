package com.alexocampo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexocampo.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
			
		model.addAttribute("titulo", "hola spring framework");
		return "prueba";
	}
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Alex");
		usuario.setApellido("Oca");
		usuario.setEmail("alexoca@gmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "perfil del usuario: ".concat(usuario.getNombre()));
		
		return "perfil";
	}
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado usuarios");
		
		return "listar";
	}
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Alex", "Oca", "andres@correo.com"),
				new Usuario("John", "Ramirez", "john@correo.com"),
				new Usuario("Diana", "Lane", "diana@correo.com"),
				new Usuario("Marcela", "Marin", "roe@correo.com"));
		
		return usuarios;
	}
}
