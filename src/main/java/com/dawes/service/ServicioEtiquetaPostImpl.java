package com.dawes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.EtiquetaPostVO;
import com.dawes.modelo.EtiquetaVO;
import com.dawes.modelo.PostVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.repository.EtiqetaPostRepository;
import com.dawes.repository.EtiqetaRepository;
import com.dawes.repository.UserRepository;
 
@Service
public class ServicioEtiquetaPostImpl implements ServicioEtiquetaPost {
 
    @Autowired
    private EtiqetaPostRepository epr;

	@Override
	public Iterable<EtiquetaPostVO> findAll() {
		return epr.findAll();
	}

	@Override
	public void save(EtiquetaPostVO ep) {
		// TODO Auto-generated method stub
		epr.save(ep);
	}

	@Override
	public void deleteByPost(int post) {
		// TODO Auto-generated method stub
		epr.deleteByPost(post);
	}

	@Override
	public Iterable<EtiquetaPostVO> findByPost(PostVO mod) {
		// TODO Auto-generated method stub
		return epr.findByPost(mod) ;
	}

	@Override
	public void deleteAll( Iterable<EtiquetaPostVO> entities) {
		// TODO Auto-generated method stub
		epr.deleteAll(entities);
	}

	@Override
	public void removeById(long epv) {
		// TODO Auto-generated method stub
		//epr.removeById(epv);
	}

	@Override
	public Optional<EtiquetaPostVO> findById(long i) {
		// TODO Auto-generated method stub
		return epr.findById(i);
	}

	@Override
	public Iterable<EtiquetaPostVO> findByEtiqueta(EtiquetaVO etiqueta) {
		// TODO Auto-generated method stub
		return epr.findByEtiqueta(etiqueta);
	}

	@Override
	public void delete(EtiquetaPostVO eti) {
		// TODO Auto-generated method stub
		 epr.delete(eti);
	}
	
	
 
  
 
}