package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dawes.modelo.RolVO;
import com.dawes.modelo.UsuarioRolVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.seguridad.EncrytedPasswordUtils;
import com.dawes.service.ServicioCategoria;
import com.dawes.service.ServicioEtiqueta;
import com.dawes.service.ServicioRol;
import com.dawes.service.ServicioUsuario;
import com.dawes.service.ServicioUsuarioRol;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	
	
	@Autowired
	ServicioUsuario su;
	
	@RequestMapping("/ver")
	public String ver(Model modelo) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();     
		UserDetails us = (UserDetails)authentication.getPrincipal();
		String nombre= us.getUsername();
		UsuarioVO usuario = su.findByUsername(nombre);
		modelo.addAttribute("usuario", usuario);
		return "perfil/verUsuario";
	}
	
	@RequestMapping("/modificarForm")
	public String modificarForm( Model modelo) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();     
		UserDetails us = (UserDetails)authentication.getPrincipal();
		String nombre= us.getUsername();
		UsuarioVO usuario = su.findByUsername(nombre);
		modelo.addAttribute("usuario", usuario);
		return "perfil/modificarUsuario";
	}
	
	@RequestMapping("/modificar")
	public String modificar(@ModelAttribute UsuarioVO user, Model modelo) {					
		UsuarioVO usuario = su.findByUsername(user.getUsername());
		usuario.setApellidos(user.getApellidos());
		String pass = EncrytedPasswordUtils.encrytePassword(user.getPassword());
		usuario.setPassword(pass);	
		usuario.setCorreo(user.getCorreo());
		usuario.setNombre(user.getNombre());
		su.save(usuario);
		return "perfil/verUsuario";
	}
}
