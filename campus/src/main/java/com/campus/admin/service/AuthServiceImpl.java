package com.campus.admin.service;

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
	public int save(Auth auth) {
		auth.setId(AUTH_ID);
		return authRepository.save(auth) == null ? 0 : 1;
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
