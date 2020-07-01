package com.campus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @ClassName: Profession
 * @Description: 专业实体类 
 * @Author 12878
 * @DateTime 2020年6月30日 下午9:15:37
 */
@Document
public class Profession {

	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	
	/**
	 * 专业名称
	 */
	private String name;

	public Profession() {
		super();
	}

	public Profession(String id, String name) {
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
		return "Profession [id=" + id + ", name=" + name + "]";
	}
}
