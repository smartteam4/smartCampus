package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.StuElective;

@Repository
public interface StuElectiveRepostory extends MongoRepository<StuElective, String>  {

}
