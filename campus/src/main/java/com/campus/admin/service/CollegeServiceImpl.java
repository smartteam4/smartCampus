package com.campus.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.entity.College;
import com.campus.repository.CollegeRepository;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	CollegeRepository collegeRepository;
	
	@Override
	public List<College> findAll() {
		return collegeRepository.findAll();
	}

	@Override
	public int saveCollege(College college) {
		return collegeRepository.save(college) == null ? 0 : 1;
	}

}
