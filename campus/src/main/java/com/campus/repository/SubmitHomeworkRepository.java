package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.SubmitHomework;

/**
 * 
 * @ClassName: SubmitHomeworkRepository
 * @Description: 发布作业数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:22:00
 */
@Repository
public interface SubmitHomeworkRepository extends MongoRepository<SubmitHomework, String> {

}
