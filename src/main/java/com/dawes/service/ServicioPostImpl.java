package com.dawes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import com.dawes.repository.PostRepository;
import com.dawes.repository.UserRepository;
 
@Service
public class ServicioPostImpl implements ServicioPost {
 
    @Autowired
    private PostRepository pr;
 
/*
	@Override
	public void save(EtiquetaVO e) {
		er.save(e);
	}*/


	@Override
	public Iterable<PostVO> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Optional<PostVO> findById(int postid) {
		// TODO Auto-generated method stub
		return pr.findById( postid);
	}

	@Override
	public void save(PostVO postt) {
		pr.save(postt);
		
	}

	@Override
	public List<PostVO> findByOrderByPostidDesc() {
		// TODO Auto-generated method stub
		return pr.findByOrderByPostidDesc();
	}

	@Override
	public void delete(PostVO postid) {
		// TODO Auto-generated method stub
		pr.delete(postid);
	}
 
  
 
}