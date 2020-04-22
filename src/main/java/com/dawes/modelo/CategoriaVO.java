
package com.dawes.modelo;


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
@Table(name = "categoria")
public class CategoriaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoriaid;	
	private String descripcion;
	
	@OneToMany(mappedBy="categoria",fetch=FetchType.EAGER,cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<PostVO> postca;

	public CategoriaVO() {
		super();
	}
	
	public CategoriaVO(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	
	public List<PostVO> getPostca() {
		return postca;
	}

	public void setPostca(List<PostVO> post) {
		this.postca = post;
	}

	public Long getCategoriaid() {
		return categoriaid;
	}

	public void setCategoriaid(Long id_categoria) {
		this.categoriaid = id_categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((categoriaid == null) ? 0 : categoriaid.hashCode());
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
		CategoriaVO other = (CategoriaVO) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (categoriaid == null) {
			if (other.categoriaid != null)
				return false;
		} else if (!categoriaid.equals(other.categoriaid))
			return false;
		return true;
	}
	
	
	
	
		
	

	

}