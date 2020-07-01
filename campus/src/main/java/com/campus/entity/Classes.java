package com.campus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @ClassName: Classes
 * @Description: 班级对象 
 * @Author 12878
 * @DateTime 2020年6月30日 下午9:17:08
 */
@Document
public class Classes {

	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 班级名称
	 */
	private String name;
	
	public Classes() {
		super();
	}
	public Classes(String id, String name) {
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
		return "Classes [id=" + id + ", name=" + name + "]";
	}
}
