
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
@Table(name = "comentario")
public class ComentarioVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_comentario;
	private LocalDate fecha;
	private String comentario;
	@ManyToOne
	@JoinColumn(name = "id_post")
	private PostVO post;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioVO userid;

	public ComentarioVO(LocalDate fecha, String comentario, PostVO post, UsuarioVO userid) {
		super();
		this.fecha = fecha;
		this.comentario = comentario;
		this.post = post;
		this.userid = userid;
	}

	public Long getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(Long id_comentario) {
		this.id_comentario = id_comentario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public PostVO getPost() {
		return post;
	}

	public void setPost(PostVO post) {
		this.post = post;
	}

	public UsuarioVO getUserid() {
		return userid;
	}

	public void setUserid(UsuarioVO userid) {
		this.userid = userid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((id_comentario == null) ? 0 : id_comentario.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		ComentarioVO other = (ComentarioVO) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id_comentario == null) {
			if (other.id_comentario != null)
				return false;
		} else if (!id_comentario.equals(other.id_comentario))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

	
	
}