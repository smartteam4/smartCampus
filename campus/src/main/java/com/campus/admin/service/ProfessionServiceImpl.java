package com.campus.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.entity.ClassRelation;
import com.campus.entity.Profession;
import com.campus.repository.ClassRelationRepository;
import com.campus.repository.ProfessionRepository;

@Service
public class ProfessionServiceImpl implements ProfessionService {

	@Autowired
	ProfessionRepository professionRepository;
	@Autowired
	ClassRelationRepository classRelationRepository;
	
	@Override
	public List<Profession> list() {
		return professionRepository.findAll();
	}

	@Override
	public List<ClassRelation> listByCollege(String collegeId) {
		return classRelationRepository.getProfessionByCollegeId(collegeId);
	}

	@Override
	public Map<String, Object> saveProfession(Profession profession) {
		Map<String, Object> map = new HashMap<>();
		if (professionRepository.save(profession) == null) {
			map.put("code", 0);
			map.put("msg", "保存失败！");
		} else {
			map.put("code", 1);
			map.put("msg", "保存成功！");
		}
		return map;
	}

}
