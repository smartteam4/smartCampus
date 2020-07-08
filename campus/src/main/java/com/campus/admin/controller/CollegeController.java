package com.campus.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.admin.service.CollegeService;
import com.campus.entity.College;

/**
 * 
 * @ClassName: CollegeController
 * @Description: 学院控制器
 * @Author 12878
 * @DateTime 2020年7月7日 上午9:31:54
 */
@RequestMapping("/admin/college")
@RestController
public class CollegeController {

	@Autowired
	CollegeService collegeService;
	
	/**
	 * 
	 * @Title: findAll
	 * @Description: 取得所有学院信息
	 * @Author 12878
	 * @DateTime 2020年7月7日 上午9:36:53
	 * @return
	 */
	@GetMapping
	public List<College> findAll() {
		return collegeService.findAll();
	}
	
	/**
	 * 
	 * @Title: updateCollege
	 * @Description: 更新或保存学院信息
	 * @Author 12878
	 * @DateTime 2020年7月7日 下午2:22:13
	 * @param college
	 * @return
	 */
	@PutMapping
	@PostMapping
	public int updateCollege(@RequestBody College college) {
		return collegeService.saveCollege(college);
		
	}

}
