package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.Course;

/**
 * 
 * @ClassName: CourseRepository
 * @Description: 课程数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:14:21
 */
@Repository
public interface CourseRepository extends MongoRepository<Course, String> {

}
