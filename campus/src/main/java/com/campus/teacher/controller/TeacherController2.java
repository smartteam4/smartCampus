package com.campus.teacher.controller;

import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.multipart.MultipartFile;

import com.campus.entity.Curriculum;
import com.campus.entity.StuQuality;
import com.campus.entity.Teacher;
import com.campus.teacher.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController2 {
	@Autowired
	TeacherService teacherService;
	
	/**
	 * 添加学生素质信息
	 * @param id 教师id
	 * @param sq 学生对象
	 * @return
	 */
	@PostMapping("/{id}/stuquality")
	public Map<String, Object> saveStuquality(@PathVariable String id,
			@RequestBody StuQuality sq) {
		Teacher tc = new Teacher();
		tc.setId(id);
		sq.setTeacher(tc);
		return teacherService.saveStuquality(sq);
	}
	/**
	 * 教师查询自己的授课情况
	 * @param id	教师id
	 * @param schoolTerm 学期
	 * @return 课表集合
	 */
	@GetMapping("/{id}/curriculum/{schoolTerm}")
	public List<Curriculum> listCurriculum(@PathVariable String id,
			@PathVariable String schoolTerm) {
		return teacherService.listCurriculum(id, schoolTerm);
	}
	/**
	 * 教师修改自己的密码
	 * @param id	教师的id
	 * @param map 密码
	 * @return 返回0或1
	 */
	@PutMapping("/{id}/password")
	public Map<String, Object> updetePassword(@PathVariable String id,@RequestBody HashMap<String, String> map) {
		return teacherService.updetePassword(id, map.get("pwd"));
	}
	
	/**
	 * 教师上传作业
	 * @param multipartFile 文件
	 * @param releaseHomework 作业对象
	 * @return
	 */
	@PostMapping("/homework")
	public Map<String, Object> upFiles(@RequestParam(name = "file") MultipartFile multipartFile,
			@RequestParam String id,
			@RequestParam String classesid,
			@RequestParam String filename,
			@RequestParam Date day
			){
		return teacherService.upFiles(multipartFile, id, classesid, filename,day);
	}

}
