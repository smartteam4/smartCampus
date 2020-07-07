package com.campus.student.service;

import java.util.List;

import com.campus.entity.Curriculum;
import com.campus.entity.Score;
import com.campus.entity.Student;

public interface StudentService{
	//取得所有学生信息
	public List<Student>listAllStudents();
	//通过指定id返回学生信息
	public Student loadStudent(String id);
	//根据学期查看成绩
	public List<Score> loadScore(String id,String schoolTrem);
	//根据学期查看课表
	public List<Curriculum> loadCurriculum(String id,String schoolTerm);
	
	//学生更改自身密码
//	public int updatePassword(String role,String username,String oldpwd,String newpwd);
}
