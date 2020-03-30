package com.dawes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.UsuarioRolVO;
import com.dawes.repository.UserRepository;
import com.dawes.repository.UserRolRepository;

@Service
public class ServcicioUsuarioRolImp implements ServicioUsuarioRol {
	@Autowired
	UserRolRepository sur;
	
	@Override
	public void save(UsuarioRolVO u) {
		sur.save(u);
	}

}
