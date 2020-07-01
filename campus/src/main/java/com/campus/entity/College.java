package com.campus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @ClassName: College
 * @Description: 学院实体类
 * @Author 12878
 * @DateTime 2020年6月30日 下午9:14:12
 */
@Document
public class College {

	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 学院名称
	 */
	private String name;
	
	public College() {
		super();
	}
	public College(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + "]";
	}
}
