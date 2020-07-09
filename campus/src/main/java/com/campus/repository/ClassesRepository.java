package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
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

	//根据名称取得对象
	@Query(value = "{'name':?0}")
	Classes getClassesid(String name);
}
