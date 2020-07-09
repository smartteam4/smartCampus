package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.campus.entity.Auth;

/**
 * 
 * @ClassName: AuthRepository
 * @Description: 权限数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:07:42
 */
@Repository
public interface AuthRepository extends MongoRepository<Auth, String> {
	
}
