package com.campus.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.admin.service.ClassesService;
import com.campus.entity.ClassRelation;

/**
 * 
 * @ClassName: ClassesController
 * @Description: 班级控制器
 * @Author 12878
 * @DateTime 2020年7月7日 下午9:39:24
 */
@RequestMapping("/admin/classes")
@RestController
public class ClassesController {

	@Autowired
	ClassesService classesService;
	
	@GetMapping
	public List<ClassRelation> list(@RequestBody(required = false) ClassRelation classRelation) {
		if (classRelation != null) {
			return classesService.listByClassRelation(classRelation);
		}
		return classesService.list();
	}
	
	@PostMapping
	public Map<String, Object> save(@RequestBody ClassRelation classRelation) {
		return classesService.save(classRelation);
	}
	
	@PutMapping
	public Map<String, Object> update(@RequestBody ClassRelation classRelation) {
		return classesService.save(classRelation);
	}
}
