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
	//通过指定学号/日期等查看学生考勤信息 
	@Query(value = "{'student.id':?0,'date':?1}")
	List<StuAttendance>listStuAttendanceByidAndDate(String id,String date);
	
	@Query(value = "{ 'student.id' : ?0 }")
	List<StuAttendance> listStuAttendance(String id);
	
	List<StuAttendance> findByDate(Date date);
	
	@Query(value = "{ 'ClassRelation.id' : ?0 }")
	List<StuAttendance> findByClaName(String id);
}
