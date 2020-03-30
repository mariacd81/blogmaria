
package com.dawes.modelo;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class PostVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_post;
	private String post;
	private LocalDate fecha;
	private String titulo;
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private CategoriaVO categoria;
	private Blob foto;
	
	@OneToMany(mappedBy="post",fetch=FetchType.EAGER,cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<EtiquetaPostVO> etiquetapost;
	
	/*mensajes
	@OneToMany(mappedBy="post",fetch=FetchType.EAGER,cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<AlumnoCursoVO> cursos;
	*/
		
	
	public PostVO(String post, LocalDate fecha, String titulo, CategoriaVO categoria, Blob foto) {
		super();
		this.post = post;
		this.fecha = fecha;
		this.titulo = titulo;
		this.categoria = categoria;
		this.foto = foto;
	}
	public Long getPostid() {
		return id_post;
	}
	public void setPostid(Long postid) {
		this.id_post = postid;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public CategoriaVO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaVO categoria) {
		this.categoria = categoria;
	}
	public Blob getFoto() {
		return foto;
	}
	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((id_post == null) ? 0 : id_post.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostVO other = (PostVO) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (id_post == null) {
			if (other.id_post != null)
				return false;
		} else if (!id_post.equals(other.id_post))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	
}