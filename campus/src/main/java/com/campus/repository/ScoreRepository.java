package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.Score;

/**
 * 
 * @ClassName: ScoreRepository
 * @Description: 成绩数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:19:32
 */
@Repository
public interface ScoreRepository extends MongoRepository<Score, String> {

}
