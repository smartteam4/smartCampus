package com.campus.entity;
/**
 * 选课
 * @author DH
 *
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Elective {
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
	 * 专业对象
	 */
	@DBRef
	private Profession profession;
	/**
	 * 课程对象
	 */
	@DBRef
	private Course course;
	/**
	 * 限选人数
	 */
	private Integer limitNumber;
	/**
	 * 已选人数
	 */
	private Integer selectedNumber;
	/**
	 * 选课状态
	 */
	private Boolean status;
	
	public Elective() {
		super();
	}

	public Elective(String id) {
		super();
		this.id = id;
	}

	public Elective(String id, String schoolTerm, Profession profession, Course course, Integer limitNumber,
			Integer selectedNumber, Boolean status) {
		super();
		this.id = id;
		this.schoolTerm = schoolTerm;
		this.profession = profession;
		this.course = course;
		this.limitNumber = limitNumber;
		this.selectedNumber = selectedNumber;
		this.status = status;
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

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getLimitNumber() {
		return limitNumber;
	}

	public void setLimitNumber(Integer limitNumber) {
		this.limitNumber = limitNumber;
	}

	public Integer getSelectedNumber() {
		return selectedNumber;
	}

	public void setSelectedNumber(Integer selectedNumber) {
		this.selectedNumber = selectedNumber;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Elective [id=" + id + ", schoolTerm=" + schoolTerm + ", profession=" + profession + ", course=" + course
				+ ", limitNumber=" + limitNumber + ", selectedNumber=" + selectedNumber + ", status=" + status + "]";
	}

}
