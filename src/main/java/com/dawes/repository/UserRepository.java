package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.UsuarioVO;

@Repository

public interface UserRepository extends CrudRepository<UsuarioVO, Long> {

	public UsuarioVO findByUsername(String userName);
	 
	
	
}