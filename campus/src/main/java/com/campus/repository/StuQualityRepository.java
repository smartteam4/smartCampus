package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
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

}
