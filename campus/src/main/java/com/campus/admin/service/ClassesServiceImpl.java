package com.campus.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.entity.ClassRelation;
import com.campus.repository.ClassRelationRepository;
import com.campus.repository.ClassesRepository;

@Service
public class ClassesServiceImpl implements ClassesService {

	@Autowired
	ClassesRepository classesRepository;
	@Autowired
	ClassRelationRepository classRelationRepository;
	
	@Override
	public List<ClassRelation> list() {
		return classRelationRepository.findAll();
	}

	@Override
	public List<ClassRelation> listByClassRelation(ClassRelation classRelation) {
		// 判断班级
		if (classRelation.getClasses() != null && classRelation.getClasses().getId() != null) {
			System.out.println(1);
			return classRelationRepository.findByClasses(classRelation.getClasses().getId());
		}
		// 判断专业
		if (classRelation.getProfession() != null && classRelation.getProfession().getId() != null) {
			System.out.println(2);
			return classRelationRepository.findByProfession(classRelation.getProfession().getId());
		}
		// 判断学院
		if (classRelation.getCollege() != null && classRelation.getCollege().getId() != null) {
			System.out.println(3);
			return classRelationRepository.findByCollege(classRelation.getCollege().getId());
		}
		System.out.println(4);
		return null;
	}

	@Override
	public Map<String, Object> save(ClassRelation classRelation) {
		Map<String, Object> map = new HashMap<>();
		if (classesRepository.save(classRelation.getClasses()) == null
				|| classRelationRepository.save(classRelation) == null) {
			map.put("code", 0);
			map.put("msg", "保存失败！");
		} else {
			map.put("code", 1);
			map.put("msg", "保存成功！");
		}
		return map;
	}

}
