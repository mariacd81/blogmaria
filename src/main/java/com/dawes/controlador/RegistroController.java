package com.dawes.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dawes.modelo.CategoriaVO;
import com.dawes.modelo.EtiquetaVO;
import com.dawes.modelo.PostVO;
import com.dawes.modelo.RolVO;
import com.dawes.modelo.UsuarioRolVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.seguridad.EncrytedPasswordUtils;
import com.dawes.service.ServicioCategoria;
import com.dawes.service.ServicioEtiqueta;
import com.dawes.service.ServicioPost;
import com.dawes.service.ServicioRol;
import com.dawes.service.ServicioUsuario;
import com.dawes.service.ServicioUsuarioRol;

@Controller
@RequestMapping("/registro")
public class RegistroController {
	
	@Autowired
	ServicioPost sp;
	
	@Autowired
	ServicioUsuario su;
	
	@Autowired
	ServicioRol sr;
	
	@Autowired
	ServicioEtiqueta se;
	
	@Autowired
	ServicioCategoria sc ;
	
	@Autowired
	ServicioUsuarioRol sur;	


	@RequestMapping("/form")
	public String registro(Model modelo) {
		UsuarioVO u = new UsuarioVO();
		modelo.addAttribute("usuario", u);		
		Iterable<CategoriaVO> cat = sc.findeAll();
		modelo.addAttribute("categorias", cat);
		Iterable<EtiquetaVO> eti = se.findAll();
		modelo.addAttribute("etiquetas", eti);
		modelo.addAttribute("error","");
		return "registroForm";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute UsuarioVO user, Model modelo) {
		//debe elegir otro usuario
		//
		if(su.findByUsername(user.getUsername()) != null)
		{
			UsuarioVO u = new UsuarioVO();
			modelo.addAttribute("usuario", u);	
			modelo.addAttribute("error","El usuario ya existe");
			cargar(modelo);
			return "registroForm";
		}
		String pass = EncrytedPasswordUtils.encrytePassword(user.getPassword());
		user.setPassword(pass);
		su.save(user);
		RolVO rol = sr.findById(2).get();
		UsuarioVO usuario = su.findByUsername(user.getUsername());
		sur.save(new UsuarioRolVO(usuario,rol));
		cargar(modelo);
		return "login";
	}
	
	private void cargar(Model modelo) {
		List<PostVO> post = sp.findByOrderByPostidDesc();
		PostVO post1 = post.get(0);
		modelo.addAttribute("post", post1);
		modelo.addAttribute("sig", post.get(1));
		modelo.addAttribute("sig1", post.get(2));
		modelo.addAttribute("sig2", post.get(3));
		modelo.addAttribute("ruta", "../files/");
		Iterable<CategoriaVO> cat = sc.findeAll();
		modelo.addAttribute("categorias", cat);
		Iterable<EtiquetaVO> eti = se.findAll();
		modelo.addAttribute("etiquetas", eti);
	}
	
}
