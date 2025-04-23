package com.springbootlearn.crudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootlearn.crudapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository // provides that component scanning and JDBC exception handling
public class StudentDAOImpl implements StudentDAO{
	// define field of the entityManager
	private EntityManager entityManager;
	
	// injecting entity manager using constructor injection
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
	
	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		
		// create query
		TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);
		
		// return query results
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		
		// create query
		TypedQuery<Student> theQuery = entityManager.createQuery(
				"From Student Where lastName=:theData", Student.class);
		
		// set querY parameters
		theQuery.setParameter("theData", lastName);
		
		// return query results
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
			entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		
		// retrieve the student
		Student theStudent = entityManager.find(Student.class, id);
				
		// delete the student
				entityManager.remove(theStudent);
	}

	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted = entityManager.createQuery("Delete from Student").executeUpdate();
		return numRowsDeleted;
	}
	
}
