package com.campus.teacher.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.campus.admin.service.AuthService;
import com.campus.config.FileMongo;
import com.campus.entity.ClassRelation;
import com.campus.entity.Curriculum;
import com.campus.entity.ReleaseHomework;
import com.campus.entity.StuQuality;
import com.campus.entity.Teach;
import com.campus.entity.Teacher;
import com.campus.entity.User;
import com.campus.repository.ClassRelationRepository;
import com.campus.repository.CurriculumRepository;
import com.campus.repository.ReleaseHomeworkRepository;
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
	AuthService authService;
	@Autowired
	ReleaseHomeworkRepository releaseHomeworkRepository;
	@Autowired
	FileMongo filemongo;
	@Autowired
	ClassRelationRepository classRelationRepository;
	@Autowired
	TeacherRepository teacherRepository;
	
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
	 * 教师上传作业
	 */
	@Override
	public Map<String, Object> upFiles(MultipartFile multipartFile,String id,String classesid,String filename,Date day) {
		// TODO Auto-generated method stub
		ReleaseHomework releaseHomework=new ReleaseHomework();
		ClassRelation classRelation=classRelationRepository.findByClasses(classesid).get(0);
		Teacher teacher=teacherRepository.findByIds(id);
		releaseHomework.setClassRelation(classRelation);
		releaseHomework.setTeacher(teacher);
		releaseHomework.setTitle(filename);
		releaseHomework.setReleaseDate(new Date());
		releaseHomework.setSubmitDate(day);
		int i= releaseHomeworkRepository.save(releaseHomework) ==null?0:1;
		if(i==1) {
			filemongo.upFiles(multipartFile, filename);
		}
		HashMap<String, Object>map=new HashMap<String, Object>();
		map.put("code", i);
		return map;
	}
	
	
}
