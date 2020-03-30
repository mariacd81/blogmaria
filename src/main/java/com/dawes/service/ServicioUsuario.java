package com.dawes.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dawes.modelo.UsuarioVO;

public interface ServicioUsuario {

	UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
	void save(UsuarioVO u);
}