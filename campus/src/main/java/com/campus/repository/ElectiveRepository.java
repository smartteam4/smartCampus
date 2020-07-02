package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.Elective;

/**
 * 
 * @ClassName: ElectiveRepository
 * @Description: 选课数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:15:40
 */
@Repository
public interface ElectiveRepository extends MongoRepository<Elective, String> {

}
