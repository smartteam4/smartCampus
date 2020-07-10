package com.campus.admin.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campus.entity.ClassRelation;
import com.campus.entity.Curriculum;
import com.campus.entity.Elective;
import com.campus.entity.LessonPlan;
import com.campus.entity.StuAttendance;
import com.campus.entity.StuQuality;
import com.campus.entity.Student;
import com.campus.entity.TchEvaluation;
import com.campus.repository.ClassRelationRepository;
import com.campus.repository.CurriculumRepository;
import com.campus.repository.ElectiveRepository;
import com.campus.repository.LessonPlanRepository;
import com.campus.repository.StuAttendanceRepository;
import com.campus.repository.StuQualityRepository;
import com.campus.repository.StudentRepository;
import com.campus.repository.TchEvaluationRepository;
import com.campus.repository.TeacherRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	StudentRepository studentRespository;
	@Autowired
	ClassRelationRepository classRelationRepository;
	@Autowired
	TchEvaluationRepository tchEvaluationRepository;
	@Autowired
	StuAttendanceRepository stuAttendanceRepository;
	@Autowired
	StuQualityRepository stuQualityRepository;
	@Autowired
	CurriculumRepository curriculumRepository;
	@Autowired
	ElectiveRepository electiveRepository;
	@Autowired
	LessonPlanRepository lessonPlanRepository;
	@Autowired
	TeacherRepository teacherRepository;
	
	//取得所有学生信息
		@Override
		public List<Student> listAllStudents() {
			List<Student>list=studentRespository.findAll();
			return list;
		}

		//取得指定学生信息，学院、专业、班级的学生信息
		@Override
		public List<Student> listStudentsBys(String college,String profession,String classes) {
			ClassRelation classRelation=classRelationRepository.getClassRelationls(college, profession, classes);
			return studentRespository.getClassRelation(classRelation.getId());
		}

		//通过id获得学生信息
		@Override
		public Student loadStudent(String id) {
			return studentRespository.getStudent(id);
		}

		//修改学生信息
		@Override
		public Map<String, Object> updateStudent(Student student) {
			studentRespository.save(student);
			Map<String, Object> map = new HashMap<>();
			map.put("code", 1);
			map.put("msg","修改成功！");
			return map;
		}
		//添加学生信息
		@Override
		public Map<String, Object> addStudent(Student student) {
			studentRespository.save(student);
			Map<String, Object> map = new HashMap<>();
			map.put("code", 1);
			map.put("msg","保存成功！");
			return map;
		}
		//获得指定学期的全部教师评价
		@Override
		public List<TchEvaluation> listTchEvaluationByschoolTerm(String schoolterm) {
			return tchEvaluationRepository.listEvaluations(schoolterm);
		}

		//获得指定职工号的全部教师评价
		@Override
		public List<TchEvaluation> listTchEvaluationBytchId(String id) {
			return tchEvaluationRepository.listEvaluationsByTeacher(id);
		}

		//获得指定学期的全部学生素质
		@Override
		public List<StuQuality> listStuQualityByschoolTerm(String schoolTerm) {
			return stuQualityRepository.listStuQuality(schoolTerm);
		}

		//获得指定学院、专业、班级的学生素质
		@Override
		public Map<String, List<StuQuality>> listStuQualitiesByStudent(String college,String profession,String classes) {
			ClassRelation classRelation=classRelationRepository.getRelation(college, profession, classes);
			List<Student>listStudents=studentRespository.getClassRelation(classRelation.getId());
			Map<String, List<StuQuality>>map=new HashMap<String, List<StuQuality>>();
			for(Student s:listStudents) {
				map.put(s.getName(), stuQualityRepository.listStuQualitiesByStudent(s.getId()));
			}
			return map;
		}

		//通过指定班级、学号、日期等查看学生考勤信息 
		@Override
		public List<StuAttendance> listStuAttendance(Date date, StuAttendance stuAttendance) {
			if (stuAttendance != null) {
				// 首先判断学生对象是否为空，首选学号，次选班级
				if (stuAttendance.getStudent() != null) {
					return stuAttendanceRepository.findByStudentId(stuAttendance.getStudent().getId());
				}
				// 通过班级关系对象id查询
				if (stuAttendance.getClassRelation() != null) {
					return stuAttendanceRepository.findByClassRelationId(stuAttendance.getClassRelation().getId());
				}
			}
			// 通过时间查询
			if (date != null) {
				return stuAttendanceRepository.findByDate(date);
			}
			return null;
		}

		//学生考勤信息修改
		@Override
		public Map<String, Object> updateStuAttendanceByStuAttendeance(StuAttendance stuAttendance) {
			stuAttendanceRepository.save(stuAttendance);
			Map<String, Object> map = new HashMap<>();
			map.put("code", 1);
			map.put("msg","修改成功！");
			return map;
		}

		//保存课表信息
		@Override
		public Map<String, Object> saveCurriculumByCurriculum(Curriculum curriculum) {
			curriculumRepository.save(curriculum);
			Map<String, Object> map = new HashMap<>();
			map.put("code", 1);
			map.put("msg","保存成功！");
			return map;
		}

		//修改课表信息
		@Override
		public Map<String, Object> updateCurriculumByCurriculum(Curriculum curriculum) {
			curriculumRepository.findById(curriculum.getId()).get();
			curriculumRepository.save(curriculum);
			Map<String, Object> map = new HashMap<>();
			map.put("code", 1);
			map.put("msg","修改成功！");
			return map;
		}

		//修改选课信息
		@Override
		public Map<String, Object> updateElectiveByElective(Elective elective) {
			electiveRepository.findById(elective.getId()).get();
			electiveRepository.save(elective);
			Map<String, Object> map = new HashMap<>();
			map.put("code", 1);
			map.put("msg","修改成功！");
			return map;
		}

		//通过指定学期和班级关系对象(指定学院专业和班级)查找课表
		@Override
		public List<Curriculum> listCurriculum(Curriculum curriculum) {
			if (curriculum == null ||
					curriculum.getSchoolTerm() == null ||
					curriculum.getClassRelation() == null) {
				return null;
			}
			return curriculumRepository.findBySchoolTermAndClassRelationId(curriculum.getSchoolTerm(),
					curriculum.getClassRelation().getId());
		}


		//通过指定学期、学院、专业和班级查找课程计划
		@Override
		public List<LessonPlan> listLessonPlan(LessonPlan lessonPlan) {
			if (lessonPlan == null ||
					lessonPlan.getSchoolTerm() == null ||
					lessonPlan.getClassRelation() == null) {
				return null;
			}
			return lessonPlanRepository.findBySchoolTermAndClassRelationId(lessonPlan.getSchoolTerm(),
					lessonPlan.getClassRelation().getId());
		}

		//保存课程计划
		@Override
		public Map<String, Object> saveLessonPlanByLessonPlan(LessonPlan lessonPlan) {
			lessonPlanRepository.save(lessonPlan);
			Map<String, Object> map = new HashMap<>();
			map.put("code", 1);
			map.put("msg","保存成功！");
			return map;
		}

		//修改课程计划
		@Override
		public Map<String, Object> updateLessonPlanByLessonPlan(LessonPlan lessonPlan) {
			lessonPlanRepository.findById(lessonPlan.getId()).get();
			lessonPlanRepository.save(lessonPlan);
			Map<String, Object> map = new HashMap<>();
			map.put("code", 1);
			map.put("msg","修改成功！");
			return map;
		}

		@Override
		public List<Elective> listElective(Elective elective) {
			if (elective == null ||
					elective.getSchoolTerm() == null ||
					elective.getProfession() == null) {
				return null;
			}
			return electiveRepository.findBySchoolTermAndProfessionId(elective.getSchoolTerm(),
					elective.getProfession().getId());
		}

		@Override
		public Map<String, Object> saveElective(Elective elective) {
			electiveRepository.save(elective);
			Map<String, Object> map = new HashMap<>();
			map.put("code", 1);
			map.put("msg","保存成功！");
			return map;
		}

}
