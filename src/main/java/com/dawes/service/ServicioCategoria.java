package com.dawes.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dawes.modelo.CategoriaVO;

public interface ServicioCategoria {

	Iterable<CategoriaVO> findeAll();

	Optional<CategoriaVO> findById(int id);


}