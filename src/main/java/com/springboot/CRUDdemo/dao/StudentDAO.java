package com.springboot.CRUDdemo.dao;

import java.util.List;

import com.springboot.CRUDdemo.entity.Student;

public interface StudentDAO {

	public List<Student> findAll();
	
}
