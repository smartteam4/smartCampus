package com.campus.admin.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.campus.entity.Curriculum;
import com.campus.entity.Elective;
import com.campus.entity.LessonPlan;
import com.campus.entity.StuAttendance;
import com.campus.entity.StuQuality;
import com.campus.entity.Student;
import com.campus.entity.TchEvaluation;

/**
 * 管理员功能接口
 * @author Lo
 *
 */
public interface AdminService {
	
	//取得所有学生信息
	public List<Student> listAllStudents();
	
	//取得指定学生信息，学院、专业、班级的学生信息
	public List<Student> listStudentsBys(String college,String profession,String classes);
	
	//通过id获得学生信息
	public Student loadStudent(String id);
	
	//修改学生信息
	public Map<String, Object> updateStudent(Student student);
	
	//添加学生信息
	public Map<String, Object> addStudent(Student student);

	//获得指定学期的全部教师评价
	public List<TchEvaluation> listTchEvaluationByschoolTerm(String schoolterm);

	//获得指定职工号的全部教师评价
	public List<TchEvaluation> listTchEvaluationBytchId(String tchId);
	
	//获得指定学期的全部学生素质
	public List<StuQuality> listStuQualityByschoolTerm(String schoolTerm);
	
	//获得指定学院、专业、班级的学生素质
	public Map<String, List<StuQuality>> listStuQualitiesByStudent(String college,String profession,String classes);
	
	//通过指定班级、学号、日期等查看学生考勤信息
	public List<StuAttendance> listStuAttendance(Date date, StuAttendance stuAttendance);
	
	//学生考勤信息修改
	public Map<String, Object> updateStuAttendanceByStuAttendeance(StuAttendance stuAttendance);
	
	//通过指定学期、学院、专业和班级查找课表
	public List<Curriculum> listCurriculum(Curriculum curriculum);
	
	//通过指定学期、学院、专业和班级查找课表
	public List<Elective> listElective(Elective elective);

	//保存课表信息
	public Map<String, Object> saveCurriculumByCurriculum(Curriculum curriculum);

	//修改课表信息
	public Map<String, Object> updateCurriculumByCurriculum(Curriculum curriculum);

	//保存选课信息
	public Map<String, Object> saveElective(Elective elective);
	
	//修改选课信息
	public Map<String, Object> updateElectiveByElective(Elective elective);

	//通过指定学期、学院、专业和班级查找课程计划
	public List<LessonPlan> listLessonPlan(LessonPlan lessonPlan);

	//保存课程计划
	public Map<String, Object> saveLessonPlanByLessonPlan(LessonPlan lessonPlan);

	//修改课程计划
	public Map<String, Object> updateLessonPlanByLessonPlan(LessonPlan lessonPlan);
}
