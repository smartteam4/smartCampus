package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.ClassRelation;

/**
 * 
 * @ClassName: ClassRelationRepository
 * @Description: 班级关系数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:12:12
 */
@Repository
public interface ClassRelationRepository extends MongoRepository<ClassRelation, String> {

}
