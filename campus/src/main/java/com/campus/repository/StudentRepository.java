package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.Student;

/**
 * 
 * @ClassName: StudentRepository
 * @Description: 学生数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:20:27
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

}
