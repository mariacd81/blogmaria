package com.dawes.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.dawes.modelo.UsuarioVO;
import com.dawes.repository.UserRepository;
 
@Service
public class ServicioUsuarioImpl implements UserDetailsService, ServicioUsuario {
 
    @Autowired
    private UserRepository ur;
 

	@Override
	 public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	       UsuarioVO u = ur.findByUsername(userName);
	       
	       if (u == null) {
	            throw new UsernameNotFoundException("Usuario " + userName + " no existe en la base de datos");
	       }

	 

	       UserDetails userDetails = (UserDetails) new User(u.getUsername(), //
	               u.getPassword(), u.getRoles()
	               .stream()
	               .map(x->new SimpleGrantedAuthority(x.getRol().getRoleName()))
	               .collect(Collectors.toList()));

	       return userDetails;
	   }


	@Override
	public void save(UsuarioVO u) {
		ur.save(u);
	}


	@Override
	public UsuarioVO findByUsername(String nombre) {
		return ur.findByUsername(nombre);
	}


	@Override
	public Optional<UsuarioVO> findById(int id) {
		return ur.findById((long) id);
	}


	@Override
	public Iterable<UsuarioVO> findAll() {
		return ur.findAll();
	}


	@Override
	public void delete(UsuarioVO usuario) {
		// TODO Auto-generated method stub
		ur.delete(usuario);
	}
 
  
 
}