
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
public class EtiquetaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_etiqueta;
	
	private String descripcion;
	
	@OneToMany(mappedBy="etiqueta",fetch=FetchType.EAGER,cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<EtiquetaPostVO> etiquetapost;
	
	

	public EtiquetaVO(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Long getId_etiqueta() {
		return id_etiqueta;
	}

	public void setId_etiqueta(Long id_categoria) {
		this.id_etiqueta = id_categoria;
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
		result = prime * result + ((id_etiqueta == null) ? 0 : id_etiqueta.hashCode());
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
		EtiquetaVO other = (EtiquetaVO) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id_etiqueta == null) {
			if (other.id_etiqueta != null)
				return false;
		} else if (!id_etiqueta.equals(other.id_etiqueta))
			return false;
		return true;
	}
	
	
	
	
		
	

	

}