package com.dawes.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.PostVO;
import com.dawes.repository.PostRepository;
 
@Service
public class ServicioPostImpl implements ServicioPost {
 
    @Autowired
    private PostRepository pr;
 

	@Override
	public Iterable<PostVO> findAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Optional<PostVO> findById(int postid) {
		// TODO Auto-generated method stub
		return pr.findById( postid);
	}

	@Override
	public void save(PostVO postt) {
		pr.save(postt);
		
	}

	@Override
	public List<PostVO> findByOrderByPostidDesc() {
		// TODO Auto-generated method stub
		return pr.findByOrderByPostidDesc();
	}

	@Override
	public void delete(PostVO postid) {
		// TODO Auto-generated method stub
		pr.delete(postid);
	}
 
  
 
}