package com.dawes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dawes.modelo.CategoriaVO;
import com.dawes.modelo.ComentarioVO;
import com.dawes.modelo.UsuarioRolVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.repository.CategoriaRepository;
import com.dawes.repository.ComentarioRepository;
import com.dawes.repository.UserRepository;
 
@Service
public class ServicioComentarioImpl implements  ServicioComentario {
 
    @Autowired
    private ComentarioRepository cr;

	

	@Override
	public void save(ComentarioVO c) {
		// TODO Auto-generated method stub
		cr.save(c);
		
	}

	@Override
	public void delete(ComentarioVO c) {
		// TODO Auto-generated method stub
		cr.delete(c);
		
	}
 
  
 
}