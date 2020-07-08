package com.campus.admin.service;

import java.util.List;

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
	public int saveProfession(Profession profession) {
		return professionRepository.save(profession) == null ? 0 : 1;
	}

}
