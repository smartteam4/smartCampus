package com.campus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.entity.Student;

/**
 * 
 * @ClassName: StudentRepository
 * @Description: 学生数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:20:27
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	//根据班级关系对象id取得学生信息
	@Query(value = "{'classRelation.id':?0}")
	List<Student> listStudents(String id);
	
	//根据班级关系id取得学生信息
	@Query(value = "{'classRelation.id':?0}")
	List<Student> getClassRelation(String id);
	
	//根据学生id获得学生信息
	@Query(value = "{'_id':?0}")
	Student getStudent(String id);
	
	//根据id取得班级关系对象
	@Query(value = "{'_id':?0}")
	Student loadRelation(String id);
}
