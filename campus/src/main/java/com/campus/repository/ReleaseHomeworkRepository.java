package com.campus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.entity.ReleaseHomework;

/**
 * 
 * @ClassName: ReleaseHomeworkRepository
 * @Description: 发布作业数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:18:25
 */
@Repository
public interface ReleaseHomeworkRepository extends MongoRepository<ReleaseHomework, String> {

	@Query(value = "{'classRelation.id':?0}")
	List<ReleaseHomework> listReleaseHomeworks(String id);
}
