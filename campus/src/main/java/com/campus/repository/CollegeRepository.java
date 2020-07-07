package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.entity.College;

@Repository
public interface CollegeRepository extends MongoRepository<College, String> {
	
	//根据名称取得对象
	@Query(value = "{'name':?0}")
	College getCollegeId(String name);
}
