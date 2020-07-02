package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.Teacher;

/**
 * 
 * @ClassName: TeacherRepository
 * @Description: 教师数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:23:55
 */
@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {

}
