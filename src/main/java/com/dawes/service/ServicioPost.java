package com.dawes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.dawes.modelo.PostVO;

public interface ServicioPost {

	Iterable<PostVO> findAll();
	Optional<PostVO> findById(int postid);
	void save(PostVO postt);
	List<PostVO> findByOrderByPostidDesc();
	void delete(PostVO postid);

}
