package com.campus.teacher.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.entity.ClassRelation;

import com.campus.admin.service.AuthService;

import com.campus.entity.Curriculum;
import com.campus.entity.Score;
import com.campus.entity.StuAttendance;
import com.campus.entity.StuQuality;
import com.campus.entity.Teach;
import com.campus.entity.Teacher;
import com.campus.entity.User;
import com.campus.repository.ClassRelationRepository;
import com.campus.repository.CurriculumRepository;
import com.campus.repository.ScoreRepository;
import com.campus.repository.StuAttendanceRepository;
import com.campus.repository.StuQualityRepository;
import com.campus.repository.TeachRepository;
import com.campus.repository.TeacherRepository;
import com.campus.repository.UserRepository;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	StuQualityRepository stuQualityRepository;
	@Autowired
	CurriculumRepository curriculumRepository;
	@Autowired
	TeachRepository teachRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	StuAttendanceRepository stuAttendanceRepository;
	@Autowired
	ScoreRepository scoreRepository;
	@Autowired
	ClassRelationRepository classRelationRepository;
	AuthService authService;

	@Override
	public Map<String, Object> saveStuquality(StuQuality sq) {
		Map<String, Object> map = new HashMap<>();
		if (authService.selectStuQuality()) {
			if (stuQualityRepository.save(sq) == null) {
				map.put("code", 0); 
				map.put("msg", "评价失败！");
						
			} else {
				map.put("code", 1);
				map.put("msg", "评价成功！");
			}
		} else {
			map.put("msg", "权限未开启！");
		}
		return map;
	}

	@Override
	public List<Curriculum> listCurriculum(String id, String st) {
		List<Curriculum> list = new ArrayList<>();
		List<Teach> teachList = teachRepository.listId(id);
		System.out.println(teachList);
		for (int i = 0; i < teachList.size(); i++) {
			list.addAll(curriculumRepository.listCurriculum( st, teachList.get(i).getId()));
		}
		return list;
	}

	@Override
	public Map<String, Object> updetePassword(String username, String pwd) {
		Map<String, Object> map = new HashMap<>();
		User user = userRepository.findByUsername(username);
		user.setPassword(pwd);
		if (userRepository.save(user) == null) {
			map.put("code", 0); 
			map.put("msg", "更新失败！");
					
		} else {
			map.put("code", 1);
			map.put("msg", "更新成功！");
		}
		return  map;
	}


	/**
	 * 查询当前教师基本信息
	 */
	@Override
	public Teacher loadTeacher(String id) {
		
		return teacherRepository.findById(id).get();
	}

	/**
	 * 
	 * 通过指定班级/学号/日期等查看学生考勤信息 ?
	 */
	@Override
	public List<StuAttendance> listStuAttendance(String id) {
		
		return stuAttendanceRepository.listStuAttendance(id);
	}
	//日期
	@Override
	public List<StuAttendance> listStuAttendancea(Date date) {
		
		return stuAttendanceRepository.findByDate(date);
	}
	//班级
	@Override
	public List<StuAttendance> findByClaName(String id) {
		List<StuAttendance> list = new ArrayList<>();
		List<ClassRelation> classlist = classRelationRepository.findByName(id);
		System.out.println(classlist);
		
		for (int i = 0; i < classlist.size(); i++) {
			list.addAll(stuAttendanceRepository.findByClaName(classlist.get(i).getId()));
		}
		
		return list;
	}

	
	/**
	 * 学生考勤信息添加（仅添加缺勤信息）
	 */
	@Override
	public int saveStuAttendance(StuAttendance stua) {
		return stuAttendanceRepository.save(stua) == null ? 0 : 1;
	}

	/**
	 * 学生考勤信息修改
	 */
	@Override
	public int updateStuAttendance(StuAttendance stua) {
		return stuAttendanceRepository.save(stua) == null ? 0 : 1;
	}

	/***
	 * 学生成绩的录入
	 */
	@Override
	public int saveScore(Score score) {
		return scoreRepository.save(score) == null ? 0 : 1;
	}

	/**
	 * 学生成绩的修改
	 */
	@Override
	public int updateScore(Score score) {
		return scoreRepository.save(score) == null ? 0 : 1;
	}

	
	
}
