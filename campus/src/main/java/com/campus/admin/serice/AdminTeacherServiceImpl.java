package com.campus.admin.serice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
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
	public int saveTeacher(Teacher teacher) {
		if (MAX_ID==0) {
			cha();
		}
		teacher.setId((++MAX_ID).toString());
		
		return teacherRepository.save(teacher) == null ? 0 : 1 ;
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
	public int update(Teacher teacher) {
		return teacherRepository.save(teacher) == null ? 0 : 1;
	}

	
}
