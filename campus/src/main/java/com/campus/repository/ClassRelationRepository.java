package com.campus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
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
	
	//根据学院id，专业id，班级id得到班级关系对象
	@Query(value = "{'college.id':?0,'profession.id':?1,'classes.id':?2}")
	ClassRelation getClassRelationls(String collegeid,String professionid,String classesid);
	
	@Query(value = "{'_id':?0}")
	List<ClassRelation> findByIds(String id);
	
	
}
