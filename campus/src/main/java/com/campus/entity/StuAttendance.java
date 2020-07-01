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
	 * 缺勤原因
	 */
	private String reason;
	/**
	 * 缺勤时间
	 */
	private Date date;
	/**
	 * 第几节课
	 */
	private String time;

	public StuAttendance() {
		super();
	}

	public StuAttendance(String id, Student student, Curriculum curriculum, String reason, Date date, String time) {
		super();
		this.id = id;
		this.student = student;
		this.curriculum = curriculum;
		this.reason = reason;
		this.date = date;
		this.time = time;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "StuAttendance [id=" + id + ", student=" + student + ", curriculum=" + curriculum + ", reason=" + reason
				+ ", date=" + date + ", time=" + time + "]";
	}
}
