package com.campus.teacher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public int saveStuquality(StuQuality sq) {
		return stuQualityRepository.save(sq) == null ? 0 : 1;
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
	public int updetePassword(String username, String pwd) {
		User user = userRepository.findByUsername(username);
		user.setPassword(pwd);
		return userRepository.save(user) == null ? 0 : 1;
	}


	

	

	
	
	
	
}
