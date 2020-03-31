package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/registro")
public class RegistroController {
	
	
	@Autowired
	ServicioUsuario su;
	
	@Autowired
	ServicioRol sr;
	
	@Autowired
	ServicioUsuarioRol sur;	


	@RequestMapping("/form")
	public String registro(Model modelo) {
		UsuarioVO u = new UsuarioVO();
		modelo.addAttribute("usuario", u);
		return "registroForm";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute UsuarioVO user, Model modelo) {
		String pass = EncrytedPasswordUtils.encrytePassword(user.getPassword());
		user.setPassword(pass);
		su.save(user);
		RolVO rol = sr.findById(2).get();
		sur.save(new UsuarioRolVO(user,rol));
		return "/registrado/index";
	}
}
