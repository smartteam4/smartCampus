package com.campus.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.admin.service.AuthService;
import com.campus.entity.Auth;

/**
 * 
 * @ClassName: AuthController
 * @Description: 
 * @Author 12878
 * @DateTime 2020年7月8日 上午9:32:25
 */
@RequestMapping("/admin/auth")
@RestController
public class AuthController {
	
	@Autowired
	AuthService authService;

	@PostMapping
	public int save(@RequestBody Auth auth) {
		return authService.save(auth);
	}
	
	@GetMapping("/stu")
	public boolean selectStuQuality() {
		return authService.selectStuQuality();
	}
	
	@GetMapping("/tch")
	public boolean selectTchEvaluation() {
		return authService.selectTchEvaluation();
	}
	
	@GetMapping("/elective")
	public boolean selectElective() {
		return authService.selectElective();
	}

	@GetMapping("/score")
	public boolean selectScore() {
		return authService.selectScore();
	}
}
