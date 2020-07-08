package com.campus.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 学生考勤
 * @author DH
 *
 */
@Document
public class StuAttendance {
	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 学生对象
	 */
	@DBRef
	private Student student;
	/**
	 * 课表对象
	 */
	@DBRef
	private Curriculum curriculum;
	/**
	 * 班级关系对象
	 */
	@DBRef
	private ClassRelation classRelation;
	/**
	 * 缺勤原因
	 */
	private String reason;
	/**
	 * 缺勤时间
	 */
	private Date date;

	public StuAttendance() {
		super();
	}

	public StuAttendance(String id, Student student, Curriculum curriculum, ClassRelation classRelation, String reason,
			Date date) {
		super();
		this.id = id;
		this.student = student;
		this.curriculum = curriculum;
		this.classRelation = classRelation;
		this.reason = reason;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	public ClassRelation getClassRelation() {
		return classRelation;
	}

	public void setClassRelation(ClassRelation classRelation) {
		this.classRelation = classRelation;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "StuAttendance [id=" + id + ", student=" + student + ", curriculum=" + curriculum + ", classRelation="
				+ classRelation + ", reason=" + reason + ", date=" + date + "]";
	}

}
