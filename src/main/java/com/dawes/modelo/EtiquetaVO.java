
package com.dawes.modelo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "etiqueta")
public class EtiquetaVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long etiquetaid;
	
	private String descripcion;
	
	@OneToMany(mappedBy="etiqueta",fetch=FetchType.EAGER,cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<EtiquetaPostVO> etiquetapost;
	
	public EtiquetaVO() {
		super();
	}
	

	public EtiquetaVO(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Long getEtiquetaid() {
		return etiquetaid;
	}

	public void setEtiquetaid(Long id_categoria) {
		this.etiquetaid = id_categoria;
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
		result = prime * result + ((etiquetaid == null) ? 0 : etiquetaid.hashCode());
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
		if (etiquetaid == null) {
			if (other.etiquetaid != null)
				return false;
		} else if (!etiquetaid.equals(other.etiquetaid))
			return false;
		return true;
	}
	
	
	
	
		
	

	

}