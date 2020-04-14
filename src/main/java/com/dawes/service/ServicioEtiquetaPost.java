package com.dawes.service;

import java.util.Optional;

import com.dawes.modelo.EtiquetaPostVO;
import com.dawes.modelo.PostVO;

public interface ServicioEtiquetaPost {
	Iterable<EtiquetaPostVO> findAll();
	void save(EtiquetaPostVO ep);
	void deleteByPost(int i);
	Iterable<EtiquetaPostVO> findByPost(PostVO mod);
	void deleteAll( Iterable<EtiquetaPostVO> entities);
	void removeById(long epv);
	Optional<EtiquetaPostVO> findById(long i);
}