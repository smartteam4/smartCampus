package com.campus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
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

}
