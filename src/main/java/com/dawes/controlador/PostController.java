package com.dawes.controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dawes.modelo.CategoriaVO;
import com.dawes.modelo.ComentarioVO;
import com.dawes.modelo.EtiquetaPostVO;
import com.dawes.modelo.EtiquetaVO;
import com.dawes.modelo.PostVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.service.ServicioCategoria;
import com.dawes.service.ServicioComentario;
import com.dawes.service.ServicioEtiqueta;
import com.dawes.service.ServicioPost;
import com.dawes.service.ServicioUsuario;
import com.dawes.service.UploadFileService;
import com.dawes.service.ServicioEtiquetaPost;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	ServicioUsuario su;
	
	@Autowired
	ServicioPost sp;
	
	@Autowired
	ServicioCategoria sc;
	
	@Autowired
	ServicioEtiqueta se;
	
	@Autowired
	ServicioEtiquetaPost sep;
	
	@Autowired
	ServicioComentario sco;
	
	 @Autowired
	 UploadFileService uploadFileService;
	
	@RequestMapping("/listar")
	public String listar(Model modelo) {		
		buscarTodos(modelo);
		aside(modelo);
		return "posts/listaPost";
	}

	
	
	@RequestMapping("/crear")
	public String crearForm(Model modelo, @RequestParam int[] etiquetas, @ModelAttribute PostVO postt, @RequestParam("file") MultipartFile file ) {	
		
		if (!file.isEmpty()) {            
        try {
	            uploadFileService.saveFile(file);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}		
		postt.setFoto(file.getOriginalFilename());
		postt.setFecha(LocalDate.now());	
		sp.save(postt);
		
		for (int i : etiquetas) {
			sep.save(new EtiquetaPostVO(postt,se.findById(i).get()));
			System.out.println(i);
		}
		buscarTodos(modelo);
		aside(modelo);
		return "posts/listaPost";
	}	
	  
	@RequestMapping("/crearPost")
	public String crearPost(Model modelo) {	
		modelo.addAttribute("postt", new PostVO());
		modelo.addAttribute("categorias", sc.findeAll());
		modelo.addAttribute("etiquetas", se.findAll());
		return "posts/CerarPost";
	}
	
	@RequestMapping("/modificarForm")
	public String modificarForm(@RequestParam int postid,Model modelo) {		
		PostVO post = sp.findById(postid).get();
		modelo.addAttribute("post", post);
		modelo.addAttribute("categorias", sc.findeAll());
		modelo.addAttribute("etiquetas", se.findAll());
		return "posts/modificarPost";
	}
	
	@RequestMapping("/modificar")
	public String modificar(Model modelo, @RequestParam int[] etiquetas, @ModelAttribute PostVO postt, @RequestParam("file") MultipartFile file ) {				
		PostVO mod = sp.findById(postt.getPostid()).get();
		if (!file.isEmpty()) {            
	        try {
		            uploadFileService.saveFile(file);
		            mod.setFoto(file.getOriginalFilename());
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}	
			mod.setTitulo(postt.getTitulo());
			mod.setPost(postt.getPost());
			mod.setCategoria(postt.getCategoria());			
			sp.save(mod);
			Iterable<EtiquetaPostVO> ep = sep.findByPost(mod);
			
				sep.deleteAll(ep);
			
			
			for (int i : etiquetas) {
				sep.save(new EtiquetaPostVO(postt,se.findById(i).get()));
				System.out.println(i);
			}
			aside(modelo);
			buscarTodos(modelo);
			return "posts/listaPost";
	}
	
	@RequestMapping("/verpost")
	public String verPost(@RequestParam int id, Model modelo) { 
		List<PostVO> post = sp.findByOrderByPostidDesc();
		int tamano = post.size();
		PostVO post1 = sp.findById(id).get();
		int i=0;
		while(post.get(i).getPostid() != id ) {
			i++;
		}
		modelo.addAttribute("post", post1);
		if(tamano > i+1)		
			modelo.addAttribute("sig", post.get(i+1));	
		if(tamano > i+2)
			modelo.addAttribute("sig1", post.get(i+2));
		if(tamano > i+3)
			modelo.addAttribute("sig2", post.get(i+3));

		modelo.addAttribute("ruta", "../files/");
		aside(modelo);			
		modelo.addAttribute("comentarios", post1.getComentarios());
		return "/posts/verPost";
	}


	
	@RequestMapping("/eliminar")
	public String eliminarPost(@RequestParam int postid,Model modelo) {		
		PostVO p = sp.findById(postid).get();
		sp.delete(p);
		aside(modelo);
		buscarTodos(modelo);
		return "posts/listaPost";
	}
	
	@RequestMapping("/guardarComentario")
	public String guardarComentario(@RequestParam int postid, @RequestParam String comentario, Model modelo) { 
		PostVO post1 = sp.findById(postid).get();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();     
		UserDetails us = (UserDetails)authentication.getPrincipal();
		String nombre= us.getUsername();
		UsuarioVO usuario = su.findByUsername(nombre);
		sco.save(new ComentarioVO(LocalDate.now(), comentario, post1, usuario ));
		
		listapost(postid, modelo, post1);

		modelo.addAttribute("ruta", "../files/");
		aside(modelo);
		modelo.addAttribute("comentarios", post1.getComentarios());
		return "/posts/verPost";
	}

		
	@RequestMapping("/etiquetas")
	public String etiquetas(@RequestParam int id_etiqueta, Model modelo) { 
		Iterable<EtiquetaPostVO> ep = sep.findByEtiqueta(se.findById((long)id_etiqueta).get());
		modelo.addAttribute("posts", ep);
		modelo.addAttribute("ruta", "../files/");
		aside(modelo);
		return "/posts/Filtrado"; 
	}
	
	@RequestMapping("/categoria") 
	public String categoria(@RequestParam int id_categoria, Model modelo) { 
		Optional<CategoriaVO> categ = sc.findById(id_categoria);
		Iterable<PostVO> postss = categ.get().getPostca();
		modelo.addAttribute("posts", postss);
		modelo.addAttribute("ruta", "../files/");
		aside(modelo);
		return "/posts/FiltradoC";
	}
	
	private void buscarTodos(Model modelo) {
		Iterable<PostVO> post = sp.findAll();
		modelo.addAttribute("post", post);
	}
	
	private void aside(Model modelo) {
		Iterable<CategoriaVO> cat = sc.findeAll();
		modelo.addAttribute("categorias", cat);
		Iterable<EtiquetaVO> eti = se.findAll();
		modelo.addAttribute("etiquetas", eti);
	}
	
	private void listapost(int postid, Model modelo, PostVO post1) {
		List<PostVO> post = sp.findByOrderByPostidDesc();
		int tamano = post.size();
		int i=0;
		while(post.get(i).getPostid() != postid ) {
			i++;
		}
		modelo.addAttribute("post", post1);
		if(tamano > i+1)		
			modelo.addAttribute("sig", post.get(i+1));	
		if(tamano > i+2)
			modelo.addAttribute("sig1", post.get(i+2));
		if(tamano > i+3)
			modelo.addAttribute("sig2", post.get(i+3));
	}
	
	
	
}
