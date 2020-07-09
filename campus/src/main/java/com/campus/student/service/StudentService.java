package com.campus.student.service;

import java.util.List;

import com.campus.entity.Curriculum;
import com.campus.entity.Elective;
import com.campus.entity.Score;
import com.campus.entity.Student;
import com.campus.entity.TchEvaluation;
import com.campus.entity.Teacher;

public interface StudentService{
	//取得所有学生信息
	public List<Student>listAllStudents();
	//通过指定id返回学生信息
	public Student loadStudent(String id);
	//根据学期查看成绩
	public List<Score> loadScore(String id,String schoolTrem);
	//根据学期查看课表
	public List<Curriculum> loadCurriculum(String id,String schoolTerm);
	//获得该学生需要进行的教师评价信息
	public List<Teacher>listTchEvaluations(String id);
	//根据教师id来对教师进行评分和评价
	public int evaluate(TchEvaluation tchEvaluation);
	//学生选课操作
	public int stuEle(Student student,Elective elective);
	//学生更改自身密码
	public int updatePassword(String username,String oldpwd,String newpwd);
}
