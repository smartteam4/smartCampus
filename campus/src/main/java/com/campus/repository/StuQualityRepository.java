package com.campus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.entity.StuQuality;

/**
 * 
 * @ClassName: StuQualityRepository
 * @Description: 学生素质数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:21:32
 */
@Repository
public interface StuQualityRepository extends MongoRepository<StuQuality, String> {
	
	//根据学期取得素质数据
	@Query(value = "{'schoolTerm':?0}")
	List<StuQuality> listStuQuality(String schoolTerm);
	
	//根据学生对象取得素质数据
	@Query(value = "{'student.id':?0}")
	List<StuQuality> listStuQualitiesByStudent(String id);
}
