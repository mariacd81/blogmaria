package com.dawes.controlador;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Seguro {
	@RequestMapping("/admin")
	public String admin() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();     
		UserDetails us = (UserDetails)authentication.getPrincipal();
		String nombre= us.getUsername();
		return "admin/a";
	}

	@RequestMapping("/registrado")
	public String registrado(Model modelo) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();     
		UserDetails us = (UserDetails)authentication.getPrincipal();
		String nombre= us.getUsername();
		modelo.addAttribute("nombre", nombre);
		return "/registrado/index";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}

	@RequestMapping(value = "/403")
	public String accesoDenegado(Model modelo) {

		modelo.addAttribute("message", "No tienes permiso de acceso a esta página");
		return "403Page";
	}
}
