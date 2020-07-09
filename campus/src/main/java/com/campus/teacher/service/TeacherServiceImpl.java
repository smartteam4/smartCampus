package com.campus.teacher.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.admin.service.AuthService;
import com.campus.entity.Curriculum;
import com.campus.entity.StuQuality;
import com.campus.entity.Teach;
import com.campus.entity.User;
import com.campus.repository.CurriculumRepository;
import com.campus.repository.StuQualityRepository;
import com.campus.repository.TeachRepository;
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


	

	

	
	
	
	
}
