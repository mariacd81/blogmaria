package com.dawes.service;

import java.util.Optional;
import com.dawes.modelo.EtiquetaVO;

public interface ServicioEtiqueta {
	Iterable<EtiquetaVO> findAll();
	Optional<EtiquetaVO> findById(long i);
}