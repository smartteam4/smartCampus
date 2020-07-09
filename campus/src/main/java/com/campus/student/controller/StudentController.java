package com.campus.student.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.campus.entity.Curriculum;
import com.campus.entity.Elective;
import com.campus.entity.Score;
import com.campus.entity.Student;
import com.campus.entity.TchEvaluation;
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
	@GetMapping("/{id}/tchevaluation")
	public List<Teacher>listTeacher(@PathVariable String id){
		return studentService.listTchEvaluations(id);
	}
	//根据教师id来对教师进行评分和评价
	@PostMapping("/{id}/tchevaluation")
	public Map<String, Object> saveTchEvaluation(@RequestBody TchEvaluation tchEvaluation,@PathVariable String id) {
		Teacher teacher=new Teacher();
		teacher.setId(id);
		tchEvaluation.setTeacher(teacher);
		int i= studentService.evaluate(tchEvaluation);
		Map<String, Object>map=new HashedMap<>();
		map.put("code", i);
		return map;
	}
	//学生选课
	@PostMapping("/{id}/elective")
	public Map<String, Object> stuElective(@PathVariable String id,@RequestParam Elective elective) {
		Student student=new Student();
		student.setId(id);
		int i= studentService.stuEle(student, elective);
		Map<String, Object>map=new HashedMap<>();
		map.put("code", i);
		return map;
	}
	
	
	//学生修改密码
	@PutMapping("/{id}/password")
	public Map<String, Object> updatePassword(@RequestParam(name = "u") String username,@RequestParam(name = "o") String oldpwd,@RequestParam(name = "n") String newpwd) {
		int i= studentService.updatePassword(username, oldpwd, newpwd);
		Map<String, Object>map=new HashedMap<>();
		map.put("code", i);
		return map;
	}
	
}
