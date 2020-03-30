
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
@Table(name = "categoria")
public class CategoriaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_categoria;	
	private String descripcion;
	
	@OneToMany(mappedBy="categoria",fetch=FetchType.EAGER,cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<PostVO> post;

	public CategoriaVO(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
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
		result = prime * result + ((id_categoria == null) ? 0 : id_categoria.hashCode());
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
		if (id_categoria == null) {
			if (other.id_categoria != null)
				return false;
		} else if (!id_categoria.equals(other.id_categoria))
			return false;
		return true;
	}
	
	
	
	
		
	

	

}