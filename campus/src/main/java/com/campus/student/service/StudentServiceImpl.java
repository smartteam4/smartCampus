package com.campus.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.entity.ClassRelation;
import com.campus.entity.Course;
import com.campus.entity.Curriculum;
import com.campus.entity.Score;
import com.campus.entity.Student;
import com.campus.entity.TchEvaluation;
import com.campus.entity.Teacher;
import com.campus.repository.CurriculumRepository;
import com.campus.repository.LessonPlanRepository;
import com.campus.repository.ScoreRepository;
import com.campus.repository.StudentRepository;
import com.campus.repository.TeachRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRespository;
	@Autowired
	ScoreRepository scoreRepository;
	@Autowired
	CurriculumRepository curriculumRepository;
	@Autowired
	LessonPlanRepository lessonPlanRepository;
	@Autowired
	TeachRepository teachRepository;
	
	//取得所有学生信息
	@Override
	public List<Student> listAllStudents() {
		// TODO Auto-generated method stub
		List<Student>list=studentRespository.findAll();
		return list;
	}
	//通过id获得学生信息
	@Override
	public Student loadStudent(String id) {
		// TODO Auto-generated method stub
		return studentRespository.getStudent(id);
	}
	
	//根据学期查看成绩
	@Override
	public List<Score> loadScore(String id,String schoolTrem) {
		// TODO Auto-generated method stub
		return scoreRepository.getScore(id, schoolTrem);
	}
	//学生更改自身密码
//	@Override
//	public int updatePassword(String role, String username, String oldpwd, String newpwd) {
//		// TODO Auto-generated method stub
//		return userRepository.updatePassword(role, username, oldpwd, newpwd);
//	}
	//根据学期查看课表
	@Override
	public List<Curriculum> loadCurriculum(String id, String schoolTerm) {
		// TODO Auto-generated method stub
		return curriculumRepository.getCurriculum(studentRespository.loadRelation(id).getClassRelation().getId(), schoolTerm);
	}
	//获得该学生需要进行的教师评价信息
	@Override
	public List<Teacher> listTchEvaluations(String id) {
		// TODO Auto-generated method stub
		//取得班级关系对象
		ClassRelation classRelation=studentRespository.loadRelation(id).getClassRelation();
		List<Course>listCourses=lessonPlanRepository.getCourses(classRelation.getId());
		List<Teacher>listTeachers=new ArrayList<>();
		for(Course c:listCourses) {
			listTeachers.add(teachRepository.getTeacher(c.getId()));
		}
		return listTeachers;
	}
	//根据教师id来对教师进行评分和评价
	@Override
	public int evaluate(TchEvaluation tchEvaluation) {
		// TODO Auto-generated method stub
		
		return 1;
	}

	

}
