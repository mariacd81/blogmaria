package com.dawes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
public class ServicioCategoriaImpl implements  ServicioCategoria {
 
    @Autowired
    private CategoriaRepository cr;

	@Override
	public Iterable<CategoriaVO> findeAll() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Optional<CategoriaVO> findById(int id) {
		// TODO Auto-generated method stub
		return cr.findById((long) id);
	}
 
  
 
}