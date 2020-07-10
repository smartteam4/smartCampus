package com.campus.student.service;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.campus.config.FileMongo;
import com.campus.entity.Auth;
import com.campus.entity.ClassRelation;
import com.campus.entity.Course;
import com.campus.entity.Curriculum;
import com.campus.entity.Elective;
import com.campus.entity.ReleaseHomework;
import com.campus.entity.Score;
import com.campus.entity.StuElective;
import com.campus.entity.Student;
import com.campus.entity.SubmitHomework;
import com.campus.entity.TchEvaluation;
import com.campus.entity.Teacher;
import com.campus.entity.User;
import com.campus.repository.AuthRepository;
import com.campus.repository.ClassRelationRepository;
import com.campus.repository.CurriculumRepository;
import com.campus.repository.ElectiveRepository;
import com.campus.repository.LessonPlanRepository;
import com.campus.repository.ReleaseHomeworkRepository;
import com.campus.repository.ScoreRepository;
import com.campus.repository.StuElectiveRepostory;
import com.campus.repository.StudentRepository;
import com.campus.repository.SubmitHomeworkRepository;
import com.campus.repository.TchEvaluationRepository;
import com.campus.repository.TeachRepository;
import com.campus.repository.UserRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRespository;
	@Autowired
	ScoreRepository scoreRepository;
	@Autowired
	CurriculumRepository curriculumRepository;
	@Autowired
	LessonPlanRepository lessonPlanRepository;
	@Autowired
	TeachRepository teachRepository;
	@Autowired
	AuthRepository authRepository;
	@Autowired
	TchEvaluationRepository tchEvaluationRepository;
	@Autowired
	ElectiveRepository electiveRepository;
	@Autowired
	StuElectiveRepostory stuElectiveRepostory;
	@Autowired
	UserRepository userRepository;
	@Autowired
	SubmitHomeworkRepository submitHomeWorkRepository;
	@Autowired
	FileMongo filemongo;
	@Autowired
	ClassRelationRepository classRelationRepository;
	@Autowired
	ReleaseHomeworkRepository releaseHomeworkRepository;
	
	//取得所有学生信息
	@Override
	public List<Student> listAllStudents() {
		// TODO Auto-generated method stub
		List<Student>list=studentRespository.findAll();
		return list;
	}
	//通过id获得学生信息
	@Override
	public Student loadStudent(String id) {
		// TODO Auto-generated method stub
		return studentRespository.getStudent(id);
	}
	
	//根据学期查看成绩
	@Override
	public List<Score> loadScore(String id,String schoolTrem) {
		// TODO Auto-generated method stub
		return scoreRepository.getScore(id, schoolTrem);
	}
	
	//学生更改自身密码
	@Override
	public int updatePassword(String username, String oldpwd, String newpwd) {
		// TODO Auto-generated method stub
		User user=userRepository.getUsers(username, oldpwd);
		if(user!=null) {
			user.setPassword(newpwd);
			userRepository.save(user);
			return 1;
		}else {
			return 0;
		}
	}
	
	//根据学期查看课表
	@Override
	public List<Curriculum> loadCurriculum(String id, String schoolTerm) {
		// TODO Auto-generated method stub
		return curriculumRepository.getCurriculum(studentRespository.loadRelation(id).getClassRelation().getId(), schoolTerm);
	}
	//获得该学生需要进行的教师评价信息
	@Override
	public List<Teacher> listTchEvaluations(String id) {
		// TODO Auto-generated method stub
		//取得班级关系对象
		ClassRelation classRelation=studentRespository.loadRelation(id).getClassRelation();
		List<Course>listCourses=lessonPlanRepository.listCourses(classRelation.getId());
		List<Teacher>listTeachers=new LinkedList<>();
		for(Course c:listCourses) {
			listTeachers.add(teachRepository.findByCourse(c.getId()).getTeacher());
		}
		return listTeachers;
	}
	//根据教师id来对教师进行评分和评价
	@Override
	public int evaluate(TchEvaluation tchEvaluation) {
		// TODO Auto-generated method stub
		Auth auth=authRepository.findAll().get(0);
		if(auth.getTchEvaluation()) {
			tchEvaluationRepository.save(tchEvaluation);
			return 1;
		}else {
			return 0;
		}
	}
	//学生选课
	@Override
	public int stuEle(Student student, String id) {
		// TODO Auto-generated method stub
		//判断选课开关
		Auth auth=authRepository.findAll().get(0);
		//得到选课
		Elective ele=electiveRepository.getElective(id);
		if(auth.getElective()&&ele.getStatus()) {
			ele.setSelectedNumber(ele.getSelectedNumber()+1);
			if(ele.getSelectedNumber()+1==20) {
				ele.setStatus(false);
			}
			electiveRepository.save(ele);
			StuElective stuElective=new StuElective();
			stuElective.setStudent(student);
			stuElective.setElective(ele);
			stuElectiveRepostory.save(stuElective);
			return 1;
		}else {
			return 0;
		}
	}
	//学生提交作业
	@Override
	public Map<String, Object> upHomeWork(MultipartFile multipartFile,String id, String filename) {
		// TODO Auto-generated method stub
		SubmitHomework submitHomework=new SubmitHomework();
		Student student=studentRespository.getStudent(id);
		submitHomework.setDocument(filename);
		submitHomework.setStudent(student);
		submitHomework.setSubmitDate(new Date());
		int i=submitHomeWorkRepository.save(submitHomework)==null?0:1;
		if(i==1) {
			filemongo.upFiles(multipartFile, filename);
		}else {
			i=0;
		}
		HashMap<String, Object>map=new HashMap<>();
		map.put("code", i);
		return map;
	}
	//显示所有作业
	@Override
	public List<ReleaseHomework> listReleaseHomeworks(String id) {
		// TODO Auto-generated method stub
		ClassRelation classRelation=studentRespository.getStudent(id).getClassRelation();
		List<ReleaseHomework>list=releaseHomeworkRepository.listReleaseHomeworks(classRelation.getId());
		return list;
	}
	//下载教师的作业
	@Override
	public void downHomeWork(String pathname, String filename) {
		// TODO Auto-generated method stub
		filemongo.getFiles(filename, pathname);
	}

	

}
