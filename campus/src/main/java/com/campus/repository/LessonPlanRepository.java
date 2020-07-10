package com.campus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.entity.Course;
import com.campus.entity.LessonPlan;

/**
 * 
 * @ClassName: LessonPlanRepository
 * @Description: 课程计划数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:16:19
 */
@Repository
public interface LessonPlanRepository extends MongoRepository<LessonPlan, String> {
	
	//根据班级关系对象id取得课程对象
	@Query(value = "{'classRelation.id':?0}")
	List<Course> listCourses(String id);
	

	@Query(value = "{'schoolTerm': ?0, 'classRelation.id': ?1}")
	List<LessonPlan> findBySchoolTermAndClassRelationId(String schoolTerm, String crId);
	
}
