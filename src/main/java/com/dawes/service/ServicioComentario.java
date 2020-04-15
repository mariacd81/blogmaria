package com.dawes.service;

import java.util.Optional;

import com.dawes.modelo.ComentarioVO;
import com.dawes.modelo.RolVO;

public interface ServicioComentario {
	void save(ComentarioVO c);
	void delete( ComentarioVO c);
}
