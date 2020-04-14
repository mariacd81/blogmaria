package com.dawes.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dawes.modelo.PostVO;

@Repository
public class PostRepositoryImp {
	 @PersistenceContext
	 private EntityManager entityManager;
	 
	 public List<PostVO> findOrderedBySeatNumberLimitedTo(int limit) {
	        return entityManager.createQuery("SELECT p FROM Passenger p ORDER BY p.seatNumber",
	        		PostVO.class).setMaxResults(limit).getResultList();
	 }
}
