package com.campus.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 公告
 * @author DH
 *
 */
@Document
public class Bulletin {
	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 公告标题
	 */
	private String title;
	/**
	 * 发布时间
	 */
	private Date date;
	/**
	 * 公告内容
	 */
	private String content;
	
	public Bulletin() {
		super();
	}
	public Bulletin(String id, String title, Date date, String content) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.content = content;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Bulletin [id=" + id + ", title=" + title + ", date=" + date + ", content=" + content + "]";
	}
	
}
