package com.campus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 成绩
 * @author DH
 *
 */
@Document
public class Score {
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
	 * 学生对象
	 */
	@DBRef
	private Student student;
	/**
	 * 课程对象
	 */
	@DBRef
	private Course course;
	/**
	 * 平时成绩
	 */
	private Double usualGrades;
	/**
	 * 期末成绩
	 */
	private Double finalGrades;
	/**
	 * 总成绩
	 */
	private Double overallResult;
	
	public Score() {
		super();
	}

	public Score(String id, String schoolTerm, Student student, Course course, Double usualGrades, Double finalGrades,
			Double overallResult) {
		super();
		this.id = id;
		this.schoolTerm = schoolTerm;
		this.student = student;
		this.course = course;
		this.usualGrades = usualGrades;
		this.finalGrades = finalGrades;
		this.overallResult = overallResult;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Double getUsualGrades() {
		return usualGrades;
	}

	public void setUsualGrades(Double usualGrades) {
		this.usualGrades = usualGrades;
	}

	public Double getFinalGrades() {
		return finalGrades;
	}

	public void setFinalGrades(Double finalGrades) {
		this.finalGrades = finalGrades;
	}

	public Double getOverallResult() {
		return overallResult;
	}

	public void setOverallResult(Double overallResult) {
		this.overallResult = overallResult;
	}

	@Override
	public String toString() {
		return "Score [id=" + id + ", schoolTerm=" + schoolTerm + ", student=" + student + ", course=" + course
				+ ", usualGrades=" + usualGrades + ", finalGrades=" + finalGrades + ", overallResult=" + overallResult
				+ "]";
	}
}
