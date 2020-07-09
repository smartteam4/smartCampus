package com.campus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
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
	
	//根据课程id取得教师对象
	@Query(value = "{'course.id':?0}")
	Teach findByCourse(String id);

	@Query(value = "{'teacher.id': ?0}")
	List<Teach> listId(String id);
	
}
