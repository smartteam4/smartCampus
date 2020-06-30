package com.campus.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 作业提交
 * @author DH
 *
 */
@Document
public class SubmitHomework {

	@Id
	private String id;
	/**
	 * 提交时间
	 */
	private Date submitDate;
	/**
	 * 作业文件对象
	 */
	private String document;
	/**
	 * 学生对象
	 */
	@DBRef
	private Student student;
	/**
	 * 发布作业对象
	 */
	@DBRef
	private ReleaseHomework releaseHomework;
	
	public SubmitHomework() {
		super();
	}
	public SubmitHomework(String id, Date submitDate, String document, Student student,
			ReleaseHomework releaseHomework) {
		super();
		this.id = id;
		this.submitDate = submitDate;
		this.document = document;
		this.student = student;
		this.releaseHomework = releaseHomework;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public ReleaseHomework getReleaseHomework() {
		return releaseHomework;
	}
	public void setReleaseHomework(ReleaseHomework releaseHomework) {
		this.releaseHomework = releaseHomework;
	}
	@Override
	public String toString() {
		return "SubmitHomework [id=" + id + ", submitDate=" + submitDate + ", document=" + document + ", student="
				+ student + ", releaseHomework=" + releaseHomework + "]";
	}
	
}
