package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.Teach;

/**
 * 
 * @ClassName: TeachRepository
 * @Description: 授课数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:23:09
 */
@Repository
public interface TeachRepository extends MongoRepository<Teach, String> {

}
