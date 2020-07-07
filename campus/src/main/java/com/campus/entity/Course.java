package com.campus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 课程
 * @author DH
 *
 */
@Document
public class Course {
	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 课程名称
	 */
	private String name;
	/**
	 * 课程性质
	 */
	private String nature;
	/**
	 * 课程属性
	 */
	private String attribute;
	/**
	 * 课程类型
	 */
	private String type;
	/**
	 * 课程类别
	 */
	private String category;
	/**
	 * 课程学分
	 */
	private Double score;
	/**
	 * 课程学分
	 */
	private Double hours;
	
	public Course() {
		super();
	}
	public Course(String id) {
		super();
		this.id = id;
	}

	public Course(String id, String name, String nature, String attribute, String type, String category, Double score,
			Double hours) {
		super();
		this.id = id;
		this.name = name;
		this.nature = nature;
		this.attribute = attribute;
		this.type = type;
		this.category = category;
		this.score = score;
		this.hours = hours;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", nature=" + nature + ", attribute=" + attribute + ", type="
				+ type + ", category=" + category + ", score=" + score + ", hours=" + hours + "]";
	}
}
