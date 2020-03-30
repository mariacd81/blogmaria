package com.dawes.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dawes.modelo.UsuarioRolVO;
import com.dawes.modelo.UsuarioVO;

public interface ServicioUsuarioRol {

	void save(UsuarioRolVO u);
}