package com.campus.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campus.admin.service.AdminService;
import com.campus.entity.Student;

@RestController
@RequestMapping("/admin/student")
public class AdminStudentController {

	@Autowired
	AdminService adminService;

	// 取得所有学生信息//取得指定学生信息，学院、专业、班级的学生信息
	@GetMapping
	public List<Student> getAllStudent(@RequestParam(required = false, name = "col") String college,
			@RequestParam(required = false, name = "pro") String profession,
			@RequestParam(required = false, name = "cla") String classes) {
		List<Student> list = new ArrayList<Student>();
		if (college == null && profession == null && classes == null) {
			list = adminService.listAllStudents();
		} else {
			list = adminService.listStudentsBys(college, profession, classes);
		}
		return list;
	}

	// 指定学号
	@GetMapping("/{id}")
	public Student loadStudent(@PathVariable String id) {
		return adminService.loadStudent(id);
	}

	// 修改学生信息
	@PutMapping
	public Map<String, Object> updateStudent(@RequestBody Student student) {
		return adminService.updateStudent(student);
	}

	// 添加学生信息
	@PostMapping
	public Map<String, Object> addStudent(@RequestBody Student student) {
		return adminService.addStudent(student);
	}
}
