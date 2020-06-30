package com.campus.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.student.service.StudentService;

@RestController
@RequestMapping("/stu")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	
}
