package com.campus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @ClassName: StuQuality
 * @Description: 学生素质实体类
 * @Author 12878
 * @DateTime 2020年6月30日 下午3:04:11
 */
@Document
public class StuQuality {

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
	private Student student;
	/**
	 * 教师对象
	 */
	private Teacher teacher;
	/**
	 * 评分
	 */
	private Double score;
	/**
	 * 评价
	 */
	private String remark;
	public StuQuality() {
		super();
	}
	public StuQuality(String id) {
		super();
		this.id = id;
	}
	public StuQuality(String id, String schoolTerm, Student student, Teacher teacher, Double score, String remark) {
		super();
		this.id = id;
		this.schoolTerm = schoolTerm;
		this.student = student;
		this.teacher = teacher;
		this.score = score;
		this.remark = remark;
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "StuQuality [id=" + id + ", schoolTerm=" + schoolTerm + ", student=" + student + ", teacher=" + teacher
				+ ", score=" + score + ", remark=" + remark + "]";
	}
}
