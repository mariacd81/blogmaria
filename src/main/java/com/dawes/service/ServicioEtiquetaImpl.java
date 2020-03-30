package com.dawes.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dawes.modelo.EtiquetaVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.repository.EtiqetaRepository;
import com.dawes.repository.UserRepository;
 
@Service
public class ServicioEtiquetaImpl implements ServicioEtiqueta {
 
    @Autowired
    private EtiqetaRepository er;
 

	@Override
	public void save(EtiquetaVO e) {
		er.save(e);
	}
 
  
 
}