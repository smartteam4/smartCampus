package com.campus.teacher.service;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;

import com.campus.entity.Curriculum;
import com.campus.entity.StuQuality;
import com.campus.entity.Teach;

public interface TeacherService {
	/**
	 * 添加学生素质评价
	 * @param sq 学生素质对象
	 * @return 1或0
	 */
	int saveStuquality(StuQuality sq);  
	/**
	 * 教师查询自己的授课信息
	 * @param id	教师id
	 * @param st	学期
	 * @return 课表集合
	 */
	List<Curriculum> listCurriculum(String id, String st);
	/**
	 * 教师修改自己的密码
	 * @param id		教师id
	 * @param pwd	密码
	 * @return 返回1或0
	 */
	int updetePassword(String id, String pwd);
	
	
}
