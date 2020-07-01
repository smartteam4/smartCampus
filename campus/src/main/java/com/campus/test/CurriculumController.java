package com.campus.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.campus.entity.Curriculum;


@RestController
public class CurriculumController {
	@Autowired
	CurriculumRepository repository;

	@GetMapping("/curriculum")
	public List<Curriculum> load() {
		return repository.teacherCurriculum("", "");
	}
	
	@PostMapping("/curriculum")
	public ResponseEntity<String> save(@RequestBody Curriculum curriculum) {
		System.out.println("sss");
		repository.save(curriculum);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
}
