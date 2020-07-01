package com.campus.test;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.entity.Curriculum;


@Repository
public interface CurriculumRepository extends MongoRepository<Curriculum, String> {

	@Query(value = "{'schoolTerm': ?0, 'teacher.tchId': ?1}")
	List<Curriculum> teacherCurriculum(String schoolTerm, String tchId);
	
}
