package com.campus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 授课
 * @author DH
 *
 */
@Document
public class Teach {
	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 授课课程
	 */
	@DBRef
	private Course course;
	/**
	 * 授课教师
	 */
	@DBRef
	private Teacher teacher;
	
	public Teach() {
		super();
	}

	public Teach(String id, Course course, Teacher teacher) {
		super();
		this.id = id;
		this.course = course;
		this.teacher = teacher;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Teach [id=" + id + ", course=" + course + ", teacher=" + teacher + "]";
	}
	
}
