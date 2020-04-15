package com.dawes.controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dawes.modelo.CategoriaVO;
import com.dawes.modelo.ComentarioVO;
import com.dawes.modelo.EtiquetaPostVO;
import com.dawes.modelo.EtiquetaVO;
import com.dawes.modelo.PostVO;
import com.dawes.service.ServicioCategoria;
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
	 UploadFileService uploadFileService;
	
	@RequestMapping("/listar")
	public String listar(Model modelo) {		
		Iterable<PostVO> post = sp.findAll();
		modelo.addAttribute("post", post);
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
		Iterable<PostVO> post = sp.findAll();
		modelo.addAttribute("post", post);
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
			mod.setCategoria(postt.getCategoria());			
			sp.save(mod);
			Iterable<EtiquetaPostVO> ep = sep.findByPost(mod);
			
				sep.deleteAll(ep);
			
			
			for (int i : etiquetas) {
				sep.save(new EtiquetaPostVO(postt,se.findById(i).get()));
				System.out.println(i);
			}
			Iterable<PostVO> post = sp.findAll();
			modelo.addAttribute("post", post);
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
		Iterable<CategoriaVO> cat = sc.findeAll();
		modelo.addAttribute("categorias", cat);
		Iterable<EtiquetaVO> eti = se.findAll();
		modelo.addAttribute("etiquetas", eti);			
		modelo.addAttribute("comentarios", post1.getComentarios());
		return "/posts/verPost";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarPost(@RequestParam int postid,Model modelo) {		
		PostVO p = sp.findById(postid).get();

			sep.deleteAll(p.getEtiquetapost());
		
		sp.delete(p);
		modelo.addAttribute("categorias", sc.findeAll());
		modelo.addAttribute("etiquetas", se.findAll());
		Iterable<PostVO> post = sp.findAll();
		modelo.addAttribute("post", post);
		return "posts/listaPost";
	}
	
	
	@RequestMapping(value = "/nuevoComentario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody ComentarioVO nuevoComentario(@RequestBody ComentarioVO comentario) {		
		ComentarioVO comentario1= new ComentarioVO(LocalDate.now(),"nuevo",sp.findById(5).get(),su.findById(1).get());
	  return comentario1;
	 }
}
