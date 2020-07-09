package com.campus.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, Object> saveCollege(College college) {
		Map<String, Object> map = new HashMap<>();
		if (collegeRepository.save(college) == null) {
			map.put("code", 0);
			map.put("msg", "保存失败！");
		} else {
			map.put("code", 1);
			map.put("msg", "保存成功！");
		}
		return map;
	}

}
