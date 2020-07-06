package com.campus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StuElective {

	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 学生对象
	 */
	@DBRef
	private Student student;
	/**
	 * 选课对象
	 */
	@DBRef
	private Elective elective;
	public StuElective() {
		super();
	}
	public StuElective(String id, Student student, Elective elective) {
		super();
		this.id = id;
		this.student = student;
		this.elective = elective;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Elective getElective() {
		return elective;
	}
	public void setElective(Elective elective) {
		this.elective = elective;
	}
	@Override
	public String toString() {
		return "StuElective [id=" + id + ", student=" + student + ", elective=" + elective + "]";
	}
}
