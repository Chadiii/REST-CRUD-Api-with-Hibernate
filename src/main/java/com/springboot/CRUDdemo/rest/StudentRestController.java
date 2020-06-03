package com.springboot.CRUDdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.CRUDdemo.dao.StudentDAO;
import com.springboot.CRUDdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private StudentDAO studentDAO;
	
	// quick inject of student DAO (constructor injection)
	@Autowired
	public StudentRestController(StudentDAO theStudentDAO) {
		studentDAO = theStudentDAO;
	}
	
	// expose "/student" and return list of employees
	@GetMapping("/students")
	public List<Student> findAll(){
		return studentDAO.findAll();
	}

}
