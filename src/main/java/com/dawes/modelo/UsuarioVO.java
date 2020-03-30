
package com.dawes.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;

	@Column(length = 36, unique = true)
	private String username;

	@Column(length = 128)
	private String password;
	
	private String nombre;
	private String apellidos;
	private String correo;
	
	

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval = true)
	private Set<UsuarioRolVO> roles;
	
	

	public UsuarioVO() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userId) {
		this.userid = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String encrytedPassword) {
		this.password = encrytedPassword;
	}

	public Set<UsuarioRolVO> getRoles() {
		return roles;
	}

	public void setRoles(Set<UsuarioRolVO> roles) {
		this.roles = roles;
	}

}