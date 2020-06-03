package com.springboot.CRUDdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.CRUDdemo.entity.Student;

@Repository
public class StudentDaoHibernateImpl implements StudentDAO {

	// define field for entity manager
	
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public StudentDaoHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Student> findAll() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Student> theQuery = 
				currentSession.createQuery("from Student", Student.class);
		
		// execute query and get result list
		List<Student> students = theQuery.getResultList();
		
		// return the result
		return students;
	}

}
