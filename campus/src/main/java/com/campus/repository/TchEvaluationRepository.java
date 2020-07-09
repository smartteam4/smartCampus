package com.campus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.entity.TchEvaluation;

/**
 * 
 * @ClassName: TchEvaluationRepository
 * @Description: 教师评价数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:22:27
 */
@Repository
public interface TchEvaluationRepository extends MongoRepository<TchEvaluation, String> {

	
	//根据学期得到教师评价
	@Query(value = "{'schoolTerm':?0}")
	List<TchEvaluation>listEvaluations(String schoolTerm);
	
	//指定职工号的全部教师评价
	@Query(value = "{'teacher.id':?0}")
	List<TchEvaluation>listEvaluationsByTeacher(String id);
}
