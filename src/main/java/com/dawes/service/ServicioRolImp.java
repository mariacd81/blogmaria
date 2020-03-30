package com.dawes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.RolVO;
import com.dawes.repository.RolRepository;

@Service
public class ServicioRolImp implements ServicioRol {
	
	@Autowired 
	private RolRepository rr;
	
	@Override
	public Optional<RolVO> findById(int i) {
		return rr.findById((long) i);
	}
	
	public Iterable<RolVO> findAll() {
		return rr.findAll();
	}

}
