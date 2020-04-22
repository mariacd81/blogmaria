
package com.dawes.modelo;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "etiqueta_Post")
public class EtiquetaPostVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_etiqueta_post;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_etiqueta")
	private EtiquetaVO etiqueta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="postid")
	private PostVO post; 	

	public EtiquetaPostVO() {
		super();
	}

	public EtiquetaPostVO(PostVO postt, EtiquetaVO etiquetaVO) {
		this.post = postt;
		this.etiqueta = etiquetaVO;
	}

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

	public PostVO getPost() {
		return post;
	}

	public void setPost(PostVO posts) {
		this.post = posts;
	}
	
	
	
	
	
		
	

	

}