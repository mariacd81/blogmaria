package com.dawes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.EtiquetaVO;
import com.dawes.modelo.UsuarioVO;

@Repository

public interface EtiqetaRepository extends CrudRepository<EtiquetaVO, Long> {

	
}