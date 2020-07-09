package com.campus.admin.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.entity.Auth;
import com.campus.repository.AuthRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	/**
	 * 权限id
	 */
	private final String AUTH_ID = "1";
	
	@Autowired
	AuthRepository authRepository;

	@Override
	public Auth load(String id) {
		return authRepository.findById(AUTH_ID).get();
	}
	
	@Override
	public Map<String, Object> save(Auth auth) {
		auth.setId(AUTH_ID);
		Map<String, Object> map = new HashMap<>();
		if (authRepository.save(auth) == null) {
			map.put("code", 0);
			map.put("msg", "添加失败！");
		} else {
			map.put("code", 1);
			map.put("msg", "添加成功！");
		}
		return map;
	}


	@Override
	public boolean selectScore() {
		return authRepository.findById(AUTH_ID).get().getScore();
	}

	@Override
	public boolean selectStuQuality() {
		return authRepository.findById(AUTH_ID).get().getStuQuality();
	}

	@Override
	public boolean selectTchEvaluation() {
		return authRepository.findById(AUTH_ID).get().getTchEvaluation();
	}

	@Override
	public boolean selectElective() {
		return authRepository.findById(AUTH_ID).get().getElective();
	}
}
