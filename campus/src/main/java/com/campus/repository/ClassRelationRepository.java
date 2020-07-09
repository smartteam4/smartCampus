package com.campus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.entity.ClassRelation;

/**
 * 
 * @ClassName: ClassRelationRepository
 * @Description: 班级关系数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:12:12
 */
@Repository
public interface ClassRelationRepository extends MongoRepository<ClassRelation, String> {
	
	//根据学院id，专业id，班级id得到班级关系对象
	@Query(value = "{'college.id':?0,'profession.id':?1,'classes.id':?2}")
	ClassRelation getClassRelationls(String collegeid,String professionid,String classesid);
	
	@Query(value = "{'_id':?0}")
	List<ClassRelation> findByIds(String id);
	
	
	
	/**
	 * 
	 * @Title: getProfessionByCollegeId
	 * @Description: 根据学院id获得专业信息
	 * @Author 12878
	 * @DateTime 2020年7月7日 下午10:11:50
	 * @param collegeId 学院id
	 * @return 班级关系对象
	 */
	@Query(value = "{'college.id': ?0}",
			fields = "{'classes': 0}")
	List<ClassRelation> getProfessionByCollegeId(String collegeId);
	
	/**
	 * 
	 * @Title: findByCollege
	 * @Description: 根据学院id获得班级信息
	 * @Author 12878
	 * @DateTime 2020年7月7日 下午10:12:20
	 * @param collegeId 学院id
	 * @return 班级关系对象
	 */
	@Query(value = "{'college.id': ?0}")
	List<ClassRelation> findByCollege(String collegeId);
	
	/**
	 * 
	 * @Title: findByProfession
	 * @Description: 根据专业id获得班级信息
	 * @Author 12878
	 * @DateTime 2020年7月7日 下午10:13:30
	 * @param professionId 专业id
	 * @return 班级关系对象
	 */
	@Query(value = "{'profession.id': ?0}")
	List<ClassRelation> findByProfession(String professionId);
	
	/**
	 * 
	 * @Title: findByClasses
	 * @Description: 根据班级id查询班级信息
	 * @Author 12878
	 * @DateTime 2020年7月7日 下午10:18:13
	 * @param classesId 班级id
	 * @return 班级关系对象
	 */
	@Query(value = "{'classes.id': ?0}")
	List<ClassRelation> findByClasses(String classesId);
	
	/**
	 * 通过班级id查询班级关系对象
	 * @param classes
	 * @return
	 */
	@Query(value = "{ 'classes.id' : ?0 }")
	List<ClassRelation> findByName(String id);
	
}
