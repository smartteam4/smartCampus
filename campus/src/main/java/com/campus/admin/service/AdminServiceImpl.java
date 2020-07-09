package com.campus.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.entity.ClassRelation;
import com.campus.entity.Student;
import com.campus.repository.ClassRelationRepository;
import com.campus.repository.StudentRepository;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	StudentRepository studentRespository;
	@Autowired
	ClassRelationRepository classRelationRepository;
	
	//取得所有学生信息
		@Override
		public List<Student> listAllStudents() {
			// TODO Auto-generated method stub
			List<Student>list=studentRespository.findAll();
			return list;
		}

		//取得指定学生信息，学院、专业、班级的学生信息
		@Override
		public List<Student> listStudentsBys(String college,String profession,String classes) {
			// TODO Auto-generated method stub
			ClassRelation classRelation=classRelationRepository.getClassRelationls(college, profession, classes);
			if(classRelation==null) {
				return null;
			}else {
				return studentRespository.getClassRelation(classRelation.getId());				
			}
		}

		//通过id获得学生信息
		@Override
		public Student loadStudent(String id) {
			return studentRespository.getStudent(id);
		}

		//修改学生信息
		@Override
		public int updateStudent(Student student) {
			return studentRespository.save(student) == null ? 0 : 1;
		}
		
		//添加学生信息
		@Override
		public int addStudent(Student student) {
			return studentRespository.save(student) == null ? 0 : 1;
		}
}
