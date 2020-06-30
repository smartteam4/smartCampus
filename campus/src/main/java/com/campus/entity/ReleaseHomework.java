package com.campus.entity;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * 作业发布
 * @author DH
 *
 */
@Document
public class ReleaseHomework {
	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 作业标题
	 */
	private String title;
	/**
	 * 发布日期
	 */
	private Date releaseDate;
	/**
	 * 提交日期
	 */
	private Date submitDate;
	/**
	 * 教师对象
	 */
	@DBRef
	private Teacher teacher;
	/**
	 * 班级关系对象
	 */
	@DBRef
	private ClassRelation classRelation;
	
	public ReleaseHomework() {
		super();
	}
	public ReleaseHomework(String id, String title, Date releaseDate, Date submitDate, Teacher teacher,
			ClassRelation classRelation) {
		super();
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.submitDate = submitDate;
		this.teacher = teacher;
		this.classRelation = classRelation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public ClassRelation getClassRelation() {
		return classRelation;
	}
	public void setClassRelation(ClassRelation classRelation) {
		this.classRelation = classRelation;
	}
	@Override
	public String toString() {
		return "ReleaseHomework [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", submitDate="
				+ submitDate + ", teacher=" + teacher + ", classRelation=" + classRelation + "]";
	}
	
}
