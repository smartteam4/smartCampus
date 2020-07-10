package com.campus.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.campus.entity.StuAttendance;

/**
 * 
 * @ClassName: StuAttendanceRepository
 * @Description: 学生考勤数据操作
 * @Author 12878
 * @DateTime 2020年7月2日 下午2:20:00
 */
@Repository
public interface StuAttendanceRepository extends MongoRepository<StuAttendance, String> {
	//通过指定班级/学号/日期等查看学生考勤信息 ?
	@Query(value = "{'curriculum.id': ?0, 'student.id' : ?1}")
	List<StuAttendance> listStuAttendance(String culmId, String stuId);
	
	//通过指定学号/日期等查看学生考勤信息 
	@Query(value = "{'student.id':?0,'date':?1}")
	List<StuAttendance>listStuAttendanceByidAndDate(String id,String date);
	
	@Query(value = "{ 'student.id' : ?0}")
	List<StuAttendance> listStuAttendance(String id);
	
	@Query(value = "{'curriculum.id': ?0, 'date' : ?1}")
	List<StuAttendance> findByDate(String culmId, Date date);
	
	@Query(value = "{ 'classRelation.id' : ?0}")
	List<StuAttendance> findByClaName(String id);
	
	List<StuAttendance> findByDate(Date date);
	
	/**
	 * 
	 * @Title: findByStudentId
	 * @Description: 通过学生id查询考勤信息
	 * @Author 12878
	 * @DateTime 2020年7月9日 下午6:10:15
	 * @param stuId 学生id
 	 * @return 考勤信息
	 */
	@Query(value = "{ 'student.id' : ?0}")
	List<StuAttendance> findByStudentId(String stuId);

	/**
	 * 
	 * @Title: findByClassRelation
	 * @Description: 通过班级关系对象id查询考勤信息
	 * @Author 12878
	 * @DateTime 2020年7月9日 下午6:11:14
	 * @param crId 班级关系对象id
	 * @return 考勤信息
	 */
	@Query(value = "{ 'classRelation.id' : ?0}")
	List<StuAttendance> findByClassRelationId(String crId);
	
	@Query(value = "{'curriculum.id': ?0, 'ClassRelation.id' : ?1 }")
	List<StuAttendance> findByClass(String culmId, String classId);
}
