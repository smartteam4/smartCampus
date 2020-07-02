package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.Bulletin;

/**
 * 
 * @ClassName: BulletinRepository
 * @Description: 公告数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:08:44
 */
@Repository
public interface BulletinRepository extends MongoRepository<Bulletin, String> {

}
