package com.dawes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.EtiquetaPostVO;
import com.dawes.modelo.EtiquetaVO;
import com.dawes.modelo.PostVO;
import com.dawes.modelo.UsuarioVO;

@Repository

public interface EtiqetaPostRepository extends CrudRepository<EtiquetaPostVO, Long> {

	List<Integer> deleteByPost(long post);
	Iterable<EtiquetaPostVO> findByPost(PostVO mod);
	//void removeById(long epv);
}