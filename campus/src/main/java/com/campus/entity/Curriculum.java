package com.campus.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 课表
 * @author DH
 *
 */
@Document
public class Curriculum {
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
	 * 第几周
	 */
	private String weekend;
	/**
	 * 班级关系对象
	 */
	@DBRef
	private ClassRelation classRelation;
	/**
	 * 课表信息
	 */
	@DBRef
	private List<CurriculumInfo> courselnfoList;
	
	public Curriculum() {
		super();
	}
	public Curriculum(String id, String schoolTerm, String weekend, ClassRelation classRelation,
			List<CurriculumInfo> courselnfoList) {
		super();
		this.id = id;
		this.schoolTerm = schoolTerm;
		this.weekend = weekend;
		this.classRelation = classRelation;
		this.courselnfoList = courselnfoList;
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
	public String getWeekend() {
		return weekend;
	}
	public void setWeekend(String weekend) {
		this.weekend = weekend;
	}
	public ClassRelation getClassRelation() {
		return classRelation;
	}
	public void setClassRelation(ClassRelation classRelation) {
		this.classRelation = classRelation;
	}
	public List<CurriculumInfo> getCourselnfoList() {
		return courselnfoList;
	}
	public void setCourselnfoList(List<CurriculumInfo> courselnfoList) {
		this.courselnfoList = courselnfoList;
	}
	@Override
	public String toString() {
		return "Curriculum [id=" + id + ", schoolTerm=" + schoolTerm + ", weekend=" + weekend + ", classRelation="
				+ classRelation + ", courselnfoList=" + courselnfoList + "]";
	}
	


	

}
