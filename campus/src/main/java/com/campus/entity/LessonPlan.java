package com.campus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @ClassName: LessonPlan
 * @Description: 课程计划实体类
 * @Author 12878
 * @DateTime 2020年6月30日 下午3:02:03
 */
@Document
public class LessonPlan {
	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 学期
	 */
	private String schoolTerm;
	/**
	 * 班级关系对象
	 */
	@DBRef
	private ClassRelation classRelation;
	/**
	 * 课程对象
	 */
	@DBRef
	private Course course;
	
	public LessonPlan() {
		super();
	}
	public LessonPlan(String id, String schoolTerm, ClassRelation classRelation, Course course) {
		super();
		this.id = id;
		this.schoolTerm = schoolTerm;
		this.classRelation = classRelation;
		this.course = course;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSchoolTerm() {
		return schoolTerm;
	}
	public void setSchoolTerm(String schoolTerm) {
		this.schoolTerm = schoolTerm;
	}
	public ClassRelation getClassRelation() {
		return classRelation;
	}
	public void setClassRelation(ClassRelation classRelation) {
		this.classRelation = classRelation;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "LessonPlan [id=" + id + ", schoolTerm=" + schoolTerm + ", classRelation=" + classRelation + ", course="
				+ course + "]";
	}
	
}
