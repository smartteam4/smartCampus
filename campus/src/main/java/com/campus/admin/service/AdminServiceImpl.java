package com.campus.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			return studentRespository.getClassRelation(classRelation.getId());
		}

		//通过id获得学生信息
		@Override
		public Student loadStudent(String id) {
			return studentRespository.getStudent(id);
		}

		//修改学生信息
		@Override
		public Map<String, Object> updateStudent(Student student) {
			Map<String, Object> map = new HashMap<>();
			if (studentRespository.save(student) == null) {
				map.put("code", 0);
				map.put("msg", "修改失败！");
			} else {
				map.put("code", 1);
				map.put("msg", "修改成功！");
			}
			return map;
		}
		
		//添加学生信息
		@Override
		public Map<String, Object> addStudent(Student student) {Map<String, Object> map = new HashMap<>();
			if (studentRespository.save(student) == null) {
				map.put("code", 0);
				map.put("msg", "添加失败！");
			} else {
				map.put("code", 1);
				map.put("msg", "添加成功！");
			}
			return map;
		}
}
