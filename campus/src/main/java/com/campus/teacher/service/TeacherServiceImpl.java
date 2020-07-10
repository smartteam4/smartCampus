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
	@Autowired
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
	public List<StuAttendance> listStuAttendance(String tchId, String stuIds) {
		// 通过教师id获得课表集合
		List<Curriculum> cList = getByTchId(tchId);
		// 声明一个学生考勤集合
		List<StuAttendance> stuAttList = new ArrayList<>();
		for (Curriculum c : cList) {
			stuAttList.addAll(stuAttendanceRepository.listStuAttendance(c.getId(), stuIds));
		}
		return stuAttList;
	}
	
	//日期
	@Override
	public List<StuAttendance> listStuAttendancea(String tchId, Date date) {
		// 通过教师id获得课表集合
		List<Curriculum> cList = getByTchId(tchId);
		// 声明一个学生考勤集合
		List<StuAttendance> stuAttList = new ArrayList<>();
		for (Curriculum c : cList) {
			stuAttList.addAll(stuAttendanceRepository.findByDate(c.getId(), date));
		}
		return stuAttList;
	}
	
	//班级
	@Override
	public List<StuAttendance> findByClassId(String tchId, String classId) {
		// 通过教师id获得课表集合
		List<Curriculum> cList = getByTchId(tchId);
		// 声明一个学生考勤集合
		List<StuAttendance> stuAttList = new ArrayList<>();
		List<ClassRelation> relations = classRelationRepository.findByClasses(classId);
		// 通过教室id获得班级关系对象id
		ClassRelation classRelation = relations.size() > 0 ? relations.get(0): null;
		if (classRelation != null) {
			for (Curriculum c : cList) {
				stuAttList.addAll(stuAttendanceRepository.findByClass(c.getId(), classRelation.getId()));
			}
		}
		return stuAttList;
		
	}
	
	/**
	 * 通过教师id查询课表
	 * @param TchId
	 * @return 课表对象
	 */
	public List<Curriculum> getByTchId(String tchId) {
		// 通过教师id查询教授id
		List<Teach> teachList = teachRepository.findByTeacher(new Teacher(tchId));
		List<Curriculum> curriculumList = new ArrayList<>();
		for (Teach t : teachList) {
			// 通过教授id查询课表
			curriculumList.addAll(curriculumRepository.findByTeach(t));
		}
		return curriculumList;
	}

	
	/**
	 * 学生考勤信息添加（仅添加缺勤信息）
	 */
	@Override
	public Map<String, Object> saveStuAttendance(StuAttendance stua) {
		Map<String, Object> map = new HashMap<>();
		if (stuAttendanceRepository.save(stua) == null) {
			map.put("code", 0); 
			map.put("msg", "添加失败！");
					
		} else {
			map.put("code", 1);
			map.put("msg", "添加成功！");
		}
		return  map;
	}

	/**
	 * 学生考勤信息修改
	 */
	@Override
	public Map<String, Object> updateStuAttendance(StuAttendance stua) {
		
		Map<String, Object> map = new HashMap<>();
		if (stuAttendanceRepository.save(stua) == null) {
			map.put("code", 0); 
			map.put("msg", "更新失败！");
					
		} else {
			map.put("code", 1);
			map.put("msg", "更新成功！");
		}
		return  map;
	}

	/***
	 * 学生成绩的录入
	 */
	@Override
	public Map<String, Object> saveScore(Score score) {
		
		Map<String, Object> map = new HashMap<>();
		if (scoreRepository.save(score) == null) {
			map.put("code", 0); 
			map.put("msg", "录入失败！");
					
		} else {
			map.put("code", 1);
			map.put("msg", "录入成功！");
		}
		return  map;
	}

	/**
	 * 学生成绩的修改
	 */
	@Override
	public Map<String, Object> updateScore(Score score) {
		Map<String, Object> map = new HashMap<>();
		if (scoreRepository.save(score) == null) {
			map.put("code", 0); 
			map.put("msg", "更新失败！");
					
		} else {
			map.put("code", 1);
			map.put("msg", "更新成功！");
		}
		return  map;
	}

	
	
}
