package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.TchEvaluation;

/**
 * 
 * @ClassName: TchEvaluationRepository
 * @Description: 教师评价数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:22:27
 */
@Repository
public interface TchEvaluationRepository extends MongoRepository<TchEvaluation, String> {

}
