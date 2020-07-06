package com.campus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 班级关系
 * @author DH
 *
 */
@Document
public class ClassRelation {
	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 学院对象
	 */
	@DBRef
	private College college;
	/**
	 * 专业对象
	 */
	@DBRef
	private Profession profession;
	/**
	 * 班级对象
	 */
	@DBRef
	private Classes classes;
	
	public ClassRelation() {
		super();
	}
	public ClassRelation(String id) {
		super();
		this.id = id;
	}
	public ClassRelation(String id, College college, Profession profession, Classes classes) {
		super();
		this.id = id;
		this.college = college;
		this.profession = profession;
		this.classes = classes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	@Override
	public String toString() {
		return "ClassRelation [id=" + id + ", college=" + college + ", profession=" + profession + ", classes="
				+ classes + "]";
	}
}
