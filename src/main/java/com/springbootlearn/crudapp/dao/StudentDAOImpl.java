package com.springbootlearn.crudapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootlearn.crudapp.entity.Student;
import jakarta.persistence.EntityManager;

@Repository // provides that component scanning and JDBC exception handling
public class StudentDAOImpl implements StudentDAO{
	// define field of the entityManager
	private EntityManager entityManager;
	
	//injecting entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	// implement save method
	@Override
	@Transactional // operating
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	
}
