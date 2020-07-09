package com.campus.teacher.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.campus.entity.Curriculum;
import com.campus.entity.Score;
import com.campus.entity.StuAttendance;
import com.campus.entity.StuQuality;
import com.campus.entity.Teacher;

public interface TeacherService {
	/**
	 * 添加学生素质评价
	 * @param sq 学生素质对象
	 * @return 1或0
	 */
	Map<String, Object> saveStuquality(StuQuality sq);  
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
	Map<String, Object> updetePassword(String id, String pwd);
	

	//查询当前教师基本信息
	Teacher loadTeacher (String id);
	//通过指定班级/学号/日期等查看学生考勤信息 ?
	//学号
	List<StuAttendance> listStuAttendance(String id);
	//日期
	List<StuAttendance> listStuAttendancea(Date date);
	//班级
	List<StuAttendance> findByClaName(String id);
	//学生考勤信息添加（仅添加缺勤信息）
	int saveStuAttendance(StuAttendance stua);
	//学生考勤信息修改
	int updateStuAttendance(StuAttendance stua);
	//学生成绩的录入
	int saveScore(Score score);
	//学生成绩的修改
	int updateScore(Score score);
}
