package com.campus.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campus.entity.Curriculum;
import com.campus.entity.Score;
import com.campus.entity.Student;
import com.campus.entity.Teacher;
import com.campus.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	//通过学号查看信息
	@GetMapping("/{id}")
	public Student loadStudent(@PathVariable String id) {
		return studentService.loadStudent(id);
	}
	//根据学期查看成绩
	@GetMapping("/{id}/score/{schoolTerm}")
	public List<Score> loadScore(@PathVariable String schoolTerm,@PathVariable String id) {
		return studentService.loadScore(id,schoolTerm);
	}
	//根据学期查看课表
	@GetMapping("/{id}/curriculum/{schoolTerm}")
	public List<Curriculum> loadCurriculum(@PathVariable String id,@PathVariable String schoolTerm) {
		return studentService.loadCurriculum(id, schoolTerm);
	} 
	//查看需要评价的教师
	@GetMapping("/student/{id}/tchevaluation")
	public List<Teacher>listTeacher(@PathVariable String id){
		return studentService.listTchEvaluations(id);
	}
	
	//学生修改密码
//	@PutMapping("/{id}/passwork")
//	public int updatePassword(String role,String username,String oldpwd,String newpwd) {
//		return studentService.updatePassword(role, username, oldpwd, newpwd);
//	}
	
}
