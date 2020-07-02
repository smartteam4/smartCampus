package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.Curriculum;

/**
 * 
 * @ClassName: CurriculumRepository
 * @Description: 课表数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:14:59
 */
@Repository
public interface CurriculumRepository extends MongoRepository<Curriculum, String> {

}
