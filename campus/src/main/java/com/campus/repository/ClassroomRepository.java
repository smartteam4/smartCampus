package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.Classroom;

/**
 * 
 * @ClassName: ClassroomRepository
 * @Description: 教室数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:12:58
 */
@Repository
public interface ClassroomRepository extends MongoRepository<Classroom, String> {

}
