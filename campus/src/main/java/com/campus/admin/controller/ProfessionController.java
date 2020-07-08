package com.campus.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.admin.service.ProfessionService;
import com.campus.entity.ClassRelation;
import com.campus.entity.Profession;
import com.campus.repository.ClassRelationRepository;

@RequestMapping("/admin/profession")
@RestController
public class ProfessionController {

	@Autowired
	ProfessionService professionService;
	@Autowired
	ClassRelationRepository classRelationRepository;
	
	@GetMapping
	public List<Profession> list() {
		return professionService.list();
	}
	
	@GetMapping("/{collegeId}")
	public List<ClassRelation> listByCollege(@PathVariable String collegeId) {
		return professionService.listByCollege(collegeId);
	}
	
	@PutMapping
	public int update(@RequestBody Profession profession) {
		return professionService.saveProfession(profession);
	}
	

	@PostMapping
	public int save(@RequestBody Profession profession) {
		return professionService.saveProfession(profession);
	}
	
}
