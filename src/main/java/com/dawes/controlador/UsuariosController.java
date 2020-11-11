package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.CategoriaVO;
import com.dawes.modelo.EtiquetaVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.seguridad.EncrytedPasswordUtils;
import com.dawes.service.ServicioCategoria;
import com.dawes.service.ServicioEtiqueta;
import com.dawes.service.ServicioUsuario;

@Controller
@RequestMapping("/usuario")
public class UsuariosController {
	
	
	@Autowired
	ServicioUsuario su;
	
	@Autowired
	ServicioEtiqueta se;
	@Autowired
	ServicioCategoria sc;
	
	@RequestMapping("/listar")
	public String listar(Model modelo) {		
		Iterable<UsuarioVO> usuario = su.findAll();
		modelo.addAttribute("usuario", usuario);
		aside(modelo);	
		return "usuarios/listaUsuario";
	}
	
	
	@RequestMapping("/modificarForm")
	public String modificarForm(@RequestParam int userid,Model modelo) {		
		UsuarioVO usuario = su.findById(userid).get();
		modelo.addAttribute("usuario", usuario);		
		aside(modelo);			
		return "usuarios/modificarUsuario";
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam int userid,Model modelo) {		
		UsuarioVO usuario = su.findById(userid).get();
		su.delete(usuario);
		Iterable<UsuarioVO> usuarios = su.findAll();
		modelo.addAttribute("usuario", usuarios);
		aside(modelo);
		return "usuarios/listaUsuario";
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
		aside(modelo);
		return "usuarios/listaUsuario";
	}
	
	public void aside(Model modelo) {
		Iterable<CategoriaVO> cat = sc.findeAll();
		modelo.addAttribute("categorias", cat);
		Iterable<EtiquetaVO> eti = se.findAll();
		modelo.addAttribute("etiquetas", eti);
	}

	
}
