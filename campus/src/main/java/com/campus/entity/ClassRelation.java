package com.campus.entity;

import org.springframework.data.annotation.Id;
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
	 * 学院名称
	 */
	private String college;
	/**
	 * 专业名称
	 */
	private String profession;
	/**
	 * 班级名称
	 */
	private String classes;
	
	
	public ClassRelation() {
		super();
	}

	public ClassRelation(String id, String college, String profession, String classes) {
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

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "ClassRelation [id=" + id + ", college=" + college + ", profession=" + profession + ", classes="
				+ classes + "]";
	}

}
