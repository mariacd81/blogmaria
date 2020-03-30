
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
@Table(name = "etiqueta")
public class EtiquetaPostVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_etiqueta_post;
	@ManyToOne
	@JoinColumn(name="id_etiqueta")
	private EtiquetaVO etiqueta;
	
	@ManyToOne
	@JoinColumn(name="id_post")
	private PostVO post;

	public Long getId_etiqueta_post() {
		return id_etiqueta_post;
	}

	public void setId_etiqueta_post(Long id_etiqueta_post) {
		this.id_etiqueta_post = id_etiqueta_post;
	}

	public EtiquetaVO getEtiquetas() {
		return etiqueta;
	}

	public void setEtiquetas(EtiquetaVO etiquetas) {
		this.etiqueta = etiquetas;
	}

	public PostVO getPosts() {
		return post;
	}

	public void setPosts(PostVO posts) {
		this.post = posts;
	}
	
	
	
	
	
		
	

	

}