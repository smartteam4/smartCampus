package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.College;

@Repository
public interface CollegeRepository extends MongoRepository<College, String> {

}
