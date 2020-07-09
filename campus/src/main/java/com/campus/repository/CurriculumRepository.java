package com.campus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.entity.Curriculum;

/**
 * 
 * @ClassName: CurriculumRepository
 * @Description: 课表数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:14:59
 */
@Repository
public interface CurriculumRepository extends MongoRepository<Curriculum, String> {
	
	@Query(value = "{'schoolTerm':?0, 'teach.id':?1}")
    List<Curriculum> listCurriculum(String schoolTerm, String id);
	//根据学期查课表
	@Query(value = "{'classRelation.id':?0,'schoolTerm':?1}")
	List<Curriculum> getCurriculum(String classid,String schoolTerm);
	
	//根据学期查课表
	@Query(value = "{'schoolTerm':?0}")
	List<Curriculum> getCurriculum(String schoolTerm);
	//根据（学院、专业）班级
	@Query(value = "{'classRelation.id':?0}")
	List<Curriculum> getCurriculumByCollege(String id);
	

}
