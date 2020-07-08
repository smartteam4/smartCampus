package com.campus.admin.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.admin.serice.AdminTeacherService;
import com.campus.entity.Teacher;
import com.campus.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminTeacherController {
	@Autowired
	AdminTeacherService adminTeacherService;
	
	@Autowired
	UserRepository userRepository;
	/**
	 * 查询所有教师的信息
	 * @return 返回教师集合
	 */
	@GetMapping("/teacher")
	public List<Teacher> listTeacher(){
		return adminTeacherService.listTeachers();
	}
	/**
	 * 根据指定id查询教师信息
	 * @param id 教师id
	 * @return
	 */
	@GetMapping("/teacher/{id}")
	public Teacher loadTeacher(@PathVariable String id) {
		
		return adminTeacherService.loadTeacher(id);
		
	}
	/**
	 * 添加教师
	 * @param teacher	教师对象
	 * @return 返回1或0
	 */
	@PostMapping("/teacher")
	public int saveTeacher(@RequestBody Teacher teacher) {
		return adminTeacherService.saveTeacher(teacher);
	}
	/**
	 * 修改教师基本信息
	 * @param teacher
	 * @return
	 */
	@PutMapping("/teacher")
	public int update(@RequestBody Teacher teacher) {
		return adminTeacherService.update(teacher);
		
	}

}
