package com.campus.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.entity.Teacher;
import com.campus.repository.TeacherRepository;
import com.campus.repository.UserRepository;

@Service
public class AdminTeacherServiceImpl implements AdminTeacherService {
	private static Integer MAX_ID;
	@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Teacher> listTeachers() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher loadTeacher(String id) {
		Teacher teacher= teacherRepository.findById(id).get();
		return teacher;
	}
	
	@Override
	public Map<String, Object> saveTeacher(Teacher teacher) {
		if (MAX_ID == null) {
			cha();
		}
		teacher.setId((++MAX_ID).toString());
		Map<String, Object> map = new HashedMap<>();
		if (teacherRepository.save(teacher) == null) {
			map.put("code", 0); 
			map.put("msg", "保存失败！");
					
		} else {
			map.put("code", 1);
			map.put("msg", "保存成功！");
		}
		return  map;
	}

	@Override
	public void cha() {
		List<String> list= userRepository.findname();
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			list2.add(i, Integer.parseInt(list.get(i)));
		}
		for(int i = 0; i < list2.size()-1; i++) {
			if(list2.get(i)>list2.get(i+1)) {
				MAX_ID=list2.get(i);
			}else {
				MAX_ID=list2.get(i+1);
			}
		}
	}

	@Override
	public Map<String, Object> update(Teacher teacher) {
		Map<String, Object> map = new HashedMap<>();
		if (teacherRepository.save(teacher) == null) {
			map.put("code", 0); 
			map.put("msg", "更新失败！");
					
		} else {
			map.put("code", 1);
			map.put("msg", "更新成功！");
		}
		return  map;
	}

	
}
