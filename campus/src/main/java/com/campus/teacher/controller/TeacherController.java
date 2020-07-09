package com.campus.teacher.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RestController;

import com.campus.entity.Curriculum;
import com.campus.entity.Score;
import com.campus.entity.StuAttendance;
import com.campus.entity.StuQuality;
import com.campus.entity.Teacher;
import com.campus.teacher.service.TeacherService;


@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
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
	
	//查询当前教师基本信息
	@GetMapping("/{id}")
	public Teacher loadTeacher(@PathVariable String id) {
		return  teacherService.loadTeacher(id);
	}
	
	//通过指定班级/学号/日期等查看学生考勤信息 ?
	//学号
	@GetMapping("/StuAttendance/{id}")
	public List<StuAttendance> listStuAttendance(@PathVariable String id){
		return teacherService.listStuAttendance(id);
	}

	//日期
	@GetMapping("/StuAttendancea/{date}")
	public List<StuAttendance> listStuAttendancea(@PathVariable String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dates = sdf.parse(date);
		return teacherService.listStuAttendancea(dates);
	}
	//班级
	@GetMapping("/StuAttendanceb/{id}")
	public List<StuAttendance> findByClaName(@PathVariable String id){
		return teacherService.findByClaName(id);
	}
	
	
	//添加考勤信息
	@PostMapping("/saveStuAttendance")
	public Map<String, Object> saveStuAttendance(@RequestBody StuAttendance stua) {		
		return teacherService.saveStuAttendance(stua);
	}
	
	//修改考勤信息
	@PutMapping("/updateStuAttendance")
	public Map<String, Object> updateStuAttendance(
			@RequestBody StuAttendance stua
			) {
		return teacherService.updateStuAttendance(stua);
	}
	
	//学生成绩录入
	@PostMapping("/saveScore")
	public Map<String, Object> saveScore(
			@RequestBody Score score
			) {
		
		return teacherService.saveScore(score);
	}
	
	//学生成绩修改
	@PutMapping("/updateScore")
	public Map<String, Object> updateScore(
			@RequestBody Score score
			) {
		return teacherService.saveScore(score);
	}
	
	
}
