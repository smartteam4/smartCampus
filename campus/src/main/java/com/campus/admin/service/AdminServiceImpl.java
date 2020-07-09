package com.campus.admin.service;

import java.util.HashMap;
import java.util.LinkedList;
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
import com.campus.entity.Teacher;
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
	CurriculumRepository CurriculumRepository;
	@Autowired
	ElectiveRepository ElectiveRepository;
	@Autowired
	LessonPlanRepository LessonPlanRepository;
	@Autowired
	TeacherRepository teacherRepository;
	
	//取得所有学生信息
		@Override
		public List<Student> listAllStudents() {
			// TODO Auto-generated method stub
			List<Student>list=studentRespository.findAll();
			return list;
		}

		//取得指定学生信息，学院、专业、班级的学生信息
		@Override
		public List<Student> listStudentsBys(String college,String profession,String classes) {
			// TODO Auto-generated method stub
			ClassRelation classRelation=classRelationRepository.getClassRelationls(college, profession, classes);
			return studentRespository.getClassRelation(classRelation.getId());
		}

		//通过id获得学生信息
		@Override
		public Student loadStudent(String id) {
			// TODO Auto-generated method stub
			return studentRespository.getStudent(id);
		}

		//修改学生信息
		@Override
		public int updateStudent(Student student) {
			// TODO Auto-generated method stub
			studentRespository.save(student);
			return 1;
		}
		//添加学生信息
		@Override
		public int addStudent(Student student) {
			// TODO Auto-generated method stub
			studentRespository.save(student);
			return 1;
		}
		//获得指定学期的全部教师评价
		@Override
		public List<TchEvaluation> listTchEvaluationByschoolTerm(String schoolterm) {
			// TODO Auto-generated method stub
			return tchEvaluationRepository.listEvaluations(schoolterm);
		}

		//获得指定职工号的全部教师评价
		@Override
		public List<TchEvaluation> listTchEvaluationBytchId(String id) {
			// TODO Auto-generated method stub
			return tchEvaluationRepository.listEvaluationsByTeacher(id);
		}

		//获得指定学期的全部学生素质
		@Override
		public List<StuQuality> listStuQualityByschoolTerm(String schoolTerm) {
			// TODO Auto-generated method stub
			return stuQualityRepository.listStuQuality(schoolTerm);
		}

		//获得指定学院、专业、班级的学生素质
		@Override
		public Map<String, List<StuQuality>> listStuQualitiesByStudent(String college,String profession,String classes) {
			// TODO Auto-generated method stub
			ClassRelation classRelation=classRelationRepository.getRelation(college, profession, classes);
			List<Student>listStudents=studentRespository.getClassRelation(classRelation.getId());
			Map<String, List<StuQuality>>map=new HashMap<String, List<StuQuality>>();
			for(Student s:listStudents) {
				map.put(s.getName(), stuQualityRepository.listStuQualitiesByStudent(s.getId()));
			}
			
			return map;
		}

		//通过指定学号、日期等查看学生考勤信息
		@Override
		public List<StuAttendance> listStuAttendanceByStudentAndDate(String id,String date) {
			// TODO Auto-generated method stub
			List<StuAttendance> list= stuAttendanceRepository.listStuAttendanceByidAndDate(id, date);
			return list;
		}

		//学生考勤信息修改
		@Override
		public int updateStuAttendanceByStuAttendeance(StuAttendance stuAttendance) {
			// TODO Auto-generated method stub
			stuAttendanceRepository.save(stuAttendance);
			return 1;
//			return new ResponseEntity<String>("修改成功",HttpStatus.OK);
		}

		//保存课表信息
		@Override
		public int saveCurriculumByCurriculum(Curriculum curriculum) {
			// TODO Auto-generated method stub
			CurriculumRepository.save(curriculum);
			return 1;
			 
		}

		//修改课表信息
		@Override
		public int updateCurriculumByCurriculum(Curriculum curriculum) {
			// TODO Auto-generated method stub
			CurriculumRepository.findById(curriculum.getId()).get();
			CurriculumRepository.save(curriculum);
			return 1;
		}

		//通过指定学期和班级关系对象(指定学院专业和班级)查找课表
		@Override
		public Map<String, Object> loadCurriculumByschoolTermAndClassRelation(String schoolTerm,
					String college,
					String profession,
					String classes
					) {
			// TODO Auto-generated method stub
			Map<String, Object>map=new HashMap<String, Object>();
			//根据学期
			if(schoolTerm!=null) {
				map.put("学期", CurriculumRepository.getCurriculum(schoolTerm));
			}
			return map;
		}

		//修改选课信息
		@Override
		public int updateElectiveByElective(Elective elective) {
			// TODO Auto-generated method stub
			ElectiveRepository.findById(elective.getId()).get();
			ElectiveRepository.save(elective);
			return 1;
		}
		//通过指定学期、学院、专业和班级查找选课表
//		@Override
//		public Map<String, List<Elective>> loadElectiveRepositoryByschoolTermAndClassRelation(String schoolTerm,
//				ClassRelation classRelation) {
			// TODO Auto-generated method stub
//			HashMap<String, List<Elective>>map=new HashMap<>();
//			if(schoolTerm!=null) {
//			//学期
//				List<Elective> Elective1=ElectiveRepository.getElective(schoolTerm);
//				map.put("学期", Elective1);
//			}
//			if(classRelation.getCollege()!=null) {
//				//学院
//				List<Elective> Elective2=new LinkedList<>();
//				List<ClassRelation>list1=classRelationRepository.getClassRelationByCollege(classRelation.getCollege().getId());
//				for(ClassRelation c:list1) {
//					Elective2.add(ElectiveRepository.getElectiveByCollege(c.getId()));
//				}
//				map.put("学院", Elective2);
//			}
//			if(classRelation.getProfession()!=null) {
//				//专业
//				List<Elective> Elective3=new LinkedList<>();
//				List<ClassRelation>list2=classRelationRepository.getClassRelationByPro(classRelation.getProfession().getId());
//				for(ClassRelation c2:list2) {
//					Elective3.add(ElectiveRepository.getElectiveByCollege(c2.getId()));
//				}
//				map.put("专业学期", Elective3);
//			}
//			return null;
//		}


		//通过指定学期、学院、专业和班级查找课程计划
		@Override
		public Map<String, List<LessonPlan>> listLessonPlanByLessonPlans(String SchoolTerm, ClassRelation classRelation) {
			// TODO Auto-generated method stub
//			HashMap<String, List<LessonPlan>>map=new HashMap<>();
//			if(SchoolTerm!=null) {
//			//学期
//		//		List<LessonPlan> LessonPlan1=LessonPlanRepository.getLessonPlan(SchoolTerm);
//		//		map.put("学期", LessonPlan1);
//			}
//			if(classRelation.getCollege()!=null) {
//				//学院
//				List<LessonPlan> LessonPlan2=new LinkedList<>();
//				List<ClassRelation>list1=classRelationRepository.getClassRelationByCollege(classRelation.getCollege().getId());
//				for(ClassRelation c:list1) {
//					LessonPlan2.add(LessonPlanRepository.getLessonPlanByCollege(c.getId()));
//				}
//				map.put("学院", LessonPlan2);
//			}
//			if(classRelation.getProfession()!=null) {
//				//专业
//				List<LessonPlan> LessonPlan3=new LinkedList<>();
//				List<ClassRelation>list2=classRelationRepository.getClassRelationByPro(classRelation.getProfession().getId());
//				for(ClassRelation c2:list2) {
//					LessonPlan3.add(LessonPlanRepository.getLessonPlanByCollege(c2.getId()));
//				}
//				map.put("专业学期", LessonPlan3);
//			}
			return null;
		}

		//保存课程计划
		@Override
		public int saveLessonPlanByLessonPlan(LessonPlan lessonPlan) {
			// TODO Auto-generated method stub
			LessonPlanRepository.save(lessonPlan);
			return 1;
		}

		//修改课程计划
		@Override
		public int updateLessonPlanByLessonPlan(LessonPlan lessonPlan) {
			// TODO Auto-generated method stub
			LessonPlanRepository.findById(lessonPlan.getId()).get();
			LessonPlanRepository.save(lessonPlan);
			return 1;
		}

		
	
	
	
		

		

		

		


}
