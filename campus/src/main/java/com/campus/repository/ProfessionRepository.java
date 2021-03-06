package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.entity.Profession;

/**
 * 
 * @ClassName: ProfessionRepository
 * @Description: 专业数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:16:58
 */
@Repository
public interface ProfessionRepository extends MongoRepository<Profession, String> {
	
	//根据名称取得对象
	@Query(value = "{'name':?0}")
	Profession getProfessionid(String name);
}
