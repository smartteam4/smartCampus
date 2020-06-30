package com.campus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 教室
 * @author DH
 *
 */
@Document
public class Classroom {
	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 教室所在地
	 */
	private String building;
	/**
	 * 教室编号
	 */
	private String local;
	
	
	public Classroom() {
		super();
	}
	public Classroom(String id, String building, String local) {
		super();
		this.id = id;
		this.building = building;
		this.local = local;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	@Override
	public String toString() {
		return "Classroom [id=" + id + ", building=" + building + ", local=" + local + "]";
	}
	
	
}
