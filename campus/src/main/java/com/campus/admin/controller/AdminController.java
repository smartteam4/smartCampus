package com.campus.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.campus.admin.service.AdminService;
import com.campus.entity.User;
import com.campus.repository.UserRepository;
import com.campus.entity.Curriculum;
import com.campus.entity.Elective;
import com.campus.entity.LessonPlan;
import com.campus.entity.StuAttendance;
import com.campus.entity.StuQuality;
import com.campus.entity.TchEvaluation;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	AdminService adminService;

	@GetMapping("/user")
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/user/{username}")
	public User find(@PathVariable String username) {
		return userRepository.findByUsername(username);
	}

	@PutMapping("/user")
	public User update(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	//获得指定学期的全部教师评价--ok
	@GetMapping("/tchevaluation/{schoolTerm}")
	public List<TchEvaluation> listTchEvaluationByschoolTerm(
			@PathVariable String schoolterm) {
		return adminService.listTchEvaluationByschoolTerm(schoolterm);
	}

	//获得指定职工号的全部教师评价--ok
	@GetMapping("/tchevaluation/byid/{tchid}")
	public List<TchEvaluation> listTchEvaluationBytchId(
			@PathVariable String tchid){
		return adminService.listTchEvaluationBytchId(tchid);
		
	}
	
	//获得指定学期的全部学生素质--ok
	@GetMapping("/stuquality/{schoolTerm}")
	public List<StuQuality> listStuQualityByschoolTerm(
			@PathVariable String schoolTerm){
		return adminService.listStuQualityByschoolTerm(schoolTerm);
	}
	
	//获得指定学院、专业、班级的学生素质ok
	@GetMapping("/stuquality")
	public Map<String, List<StuQuality>> listStuQualitiesByStudent(
			@RequestParam(name = "col") String college,
			@RequestParam(name = "pro") String profession,
			@RequestParam(name = "cla") String classes
			){
		return adminService.listStuQualitiesByStudent(college, profession, classes);		
	}
	
	//通过指定班级、学号、日期等查看学生考勤信息 ???
	@GetMapping("/stuattendance/{date}")
	public List<StuAttendance> listStuAttendanceByStudentAndDate(
			@PathVariable(required = false) String date,
			@RequestBody(required = false) StuAttendance stuAttendance) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return adminService.listStuAttendance(sdf.parse(date), stuAttendance);
		
	}
	
	//通过指定学期、班级关系id（学院、专业、班级）查找课表 ???
	@GetMapping("/curriculum")
	public List<Curriculum> loadCurriculumByschoolTermAndClassRelation(
			@PathVariable(required = false) String date,
			@RequestBody(required = false) Curriculum curriculum) throws ParseException {
		return adminService.listCurriculum(curriculum);
	}

	//通过指定学期、学院、专业和班级查找课程计划  ???
	@GetMapping("/lessonplan")
	public List<LessonPlan> listLessonPlanByLessonPlans(@RequestBody LessonPlan lessonPlan){
		return adminService.listLessonPlan(lessonPlan);
	}
		
	//学生考勤信息修改  ???
	@PutMapping("/stuattendance/{stuAttendance}")
	public int updateStuAttendanceByStuAttendeance(
			@RequestBody StuAttendance stuAttendance) {
		return adminService.updateStuAttendanceByStuAttendeance(stuAttendance);
	}
	
	//保存课表信息  ???
	@PostMapping("/curriculum")
	public int saveCurriculumByCurriculum(
			@RequestBody Curriculum curriculum) {
				return adminService.saveCurriculumByCurriculum(curriculum);
	}


	//修改课表信息  ???
	@PutMapping("/curriculum/{curriculum}")
	public int updateCurriculumByCurriculum(
			@RequestBody Curriculum curriculum) {
			
		return adminService.updateCurriculumByCurriculum(curriculum);
		
	}

	//修改选课信息  ???
	@PutMapping("/elective")
	public int updateElectiveByElective(
			@RequestBody Elective elective) {
		return adminService.updateElectiveByElective(elective);
		
	}

	//保存课程计划  ???
	@PostMapping("/lessonplan")
	public int saveLessonPlanByLessonPlan(
			@RequestBody LessonPlan lessonPlan) {
		return adminService.saveLessonPlanByLessonPlan(lessonPlan);
		
	}

	//修改课程计划  ???
	@PutMapping("/lessonplan")
	public int updateLessonPlanByLessonPlan(
			@RequestBody LessonPlan lessonPlan) {
		return adminService.updateLessonPlanByLessonPlan(lessonPlan);
	}

}
