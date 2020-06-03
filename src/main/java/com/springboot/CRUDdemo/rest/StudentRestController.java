package com.springboot.CRUDdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.CRUDdemo.dao.StudentDAO;
import com.springboot.CRUDdemo.entity.Student;
import com.springboot.CRUDdemo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private StudentService studentService;
	
	// quick inject of student DAO (constructor injection)
	@Autowired
	public StudentRestController(StudentService theStudentService) {
		studentService = theStudentService;
	}
	
	// expose "/student" and return list of employees
	@GetMapping("/students")
	public List<Student> findAll(){
		return studentService.findAll();
	}
	
	

}
