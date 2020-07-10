package com.campus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
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
	
	//根据id得到对象
	@Query(value = "{'_id':?0}")
	Elective getElective(String id);
	
	@Query(value = "{'schoolTerm': ?0, 'profession.id': ?1}")
	List<Elective> findBySchoolTermAndProfessionId(String schoolTerm, String pId);
}
