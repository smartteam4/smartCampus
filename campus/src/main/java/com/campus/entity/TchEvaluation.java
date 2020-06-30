package com.campus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 教师评价
 * @author DH
 *
 */
@Document
public class TchEvaluation {
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
	 * 教师对象
	 */
	@DBRef
	private Teacher teacher;
	/**
	 * 评分
	 */
	private Double score;
	/**
	 * 评价
	 */
	private String remark;
	
	public TchEvaluation() {
		super();
	}
	public TchEvaluation(String id, String schoolTerm, Teacher teacher, Double score, String remark) {
		super();
		this.id = id;
		this.schoolTerm = schoolTerm;
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
		return "TchEvaluation [id=" + id + ", schoolTerm=" + schoolTerm + ", teacher=" + teacher + ", score=" + score
				+ ", remark=" + remark + "]";
	}

	
}
