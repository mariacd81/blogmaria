package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/usuario")
public class UsuariosController {
	
	
	@Autowired
	ServicioUsuario su;
	
	@RequestMapping("/listar")
	public String listar(Model modelo) {		
		Iterable<UsuarioVO> usuario = su.findAll();
		modelo.addAttribute("usuario", usuario);
		return "usuarios/listaUsuario";
	}
	
	
	@RequestMapping("/modificarForm")
	public String modificarForm(@RequestParam int userid,Model modelo) {		
		UsuarioVO usuario = su.findById(userid).get();
		modelo.addAttribute("usuario", usuario);
		return "usuarios/modificarUsuario";
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
		return "usuarios/listaUsuario";
	}
}
