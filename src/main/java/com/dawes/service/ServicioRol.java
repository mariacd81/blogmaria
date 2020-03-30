package com.dawes.service;

import java.util.Optional;
import com.dawes.modelo.RolVO;

public interface ServicioRol {
	Optional<RolVO> findById(int i);
	Iterable<RolVO> findAll();
}
