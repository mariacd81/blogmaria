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

import com.dawes.modelo.EtiquetaVO;
import com.dawes.modelo.PostVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.repository.EtiqetaRepository;
import com.dawes.repository.UserRepository;
 
@Service
public class ServicioEtiquetaImpl implements ServicioEtiqueta {
 
    @Autowired
    private EtiqetaRepository er;
 


	@Override
	public Iterable<EtiquetaVO> findAll() {
		return er.findAll();
	}



	@Override
	public Optional<EtiquetaVO> findById(long i) {
		// TODO Auto-generated method stub
		return er.findById(i);
	}
 
  
 
}