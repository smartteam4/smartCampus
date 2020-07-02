package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

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

}
