package com.dawes.controlador;

import java.net.http.HttpRequest;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dawes.modelo.CategoriaVO;
import com.dawes.modelo.EtiquetaVO;
import com.dawes.modelo.PostVO;
import com.dawes.repository.PostRepository;
import com.dawes.service.ServicioCategoria;
import com.dawes.service.ServicioEtiqueta;
import com.dawes.service.ServicioPost;

@Controller
public class Seguro {
	@Autowired
	ServicioPost sp;
	
	@Autowired
	ServicioCategoria sc;
	
	@Autowired
	ServicioEtiqueta se;
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin/a";
	}

	@RequestMapping("/registrado")
	public String registrado(Model modelo, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();     
		UserDetails us = (UserDetails)authentication.getPrincipal();
		session.setAttribute("username", us.getUsername());
		String role = "ROLE_ADMIN";
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) {
			if(authority.getAuthority().equals(role))
			{
				session.setAttribute("admin", us.getUsername());
				String nombre= us.getUsername();
				modelo.addAttribute("nombre", nombre);
				modelo.addAttribute("admin",true);
				cargar(modelo);
				return "admin/index";
			}
		  }
		String nombre= us.getUsername();
		modelo.addAttribute("nombre", nombre);
		cargar(modelo);
		return "registrado/index";
	}

	@RequestMapping("/index")
	public String index(Model modelo) { 
		cargar(modelo);		
		return "index";
	}
	
	@RequestMapping("/")
	public String index2(Model modelo) { 
		cargar(modelo);		
		return "index";
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

	@RequestMapping("/login")
	public String login(HttpSession session, Model modelo) {
		cargar(modelo);
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(Model modelo) {
		cargar(modelo);		
		return "index";
	}

	@RequestMapping(value = "/403")
	public String accesoDenegado(Model modelo) {

		modelo.addAttribute("message", "No tienes permiso de acceso a esta página");
		return "403Page";
	}
	
	
}
