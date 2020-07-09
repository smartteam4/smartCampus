package com.campus.admin.service;

import java.util.List;
import java.util.Map;

import com.campus.entity.Student;

/**
 * 管理员功能接口
 * @author Lo
 *
 */
public interface AdminService {
	//取得所有学生信息
	public List<Student> listAllStudents();
	
	//取得指定学生信息，学院、专业、班级的学生信息
	public List<Student> listStudentsBys(String college,String profession,String classes);
	
	//通过id获得学生信息
	public Student loadStudent(String id);
	
	//修改学生信息
	public int updateStudent(Student student);
	
	//添加学生信息
	public int addStudent(Student student);
}
