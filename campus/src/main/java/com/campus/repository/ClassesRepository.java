package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.Classes;

/**
 * 
 * @ClassName: ClassesRepository
 * @Description: 班级数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:10:54
 */
@Repository
public interface ClassesRepository extends MongoRepository<Classes, String> {

}
