package com.campus.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * 学生
 * @author DH
 *
 */
@Document
public class Student {
	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 学号
	 */
	private String stuId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 民族
	 */
	private String nation;
	/**
	 * 政治面貌
	 */
	private String politicalStatus;
	/**
	 * 出生日期
	 */
	private Date birthday;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 电子邮件
	 */
	private String email;
	/**
	 * 学制
	 */
	private Integer stuYear;
	/**
	 * 培养层次
	 */
	private String trainingLevel;
	/**
	 * 是否在校
	 */
	private String inSchool;
	/**
	 * 入学日期
	 */
	private Date admissionDate;
	/**
	 * 学籍状态
	 */
	private String schoolStatus;
	/**
	 * 班级关系对象
	 */
	@DBRef
	private ClassRelation classRelation;


	public Student() {
		super();
	}
	public Student(String id, String stuId, String name, String sex, String idCard, String nation,
			String politicalStatus, Date birthday, String phone, String email, Integer stuYear, String trainingLevel,
			String inSchool, Date admissionDate, String schoolStatus, ClassRelation classRelation) {
		super();
		this.id = id;
		this.stuId = stuId;
		this.name = name;
		this.sex = sex;
		this.idCard = idCard;
		this.nation = nation;
		this.politicalStatus = politicalStatus;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.stuYear = stuYear;
		this.trainingLevel = trainingLevel;
		this.inSchool = inSchool;
		this.admissionDate = admissionDate;
		this.schoolStatus = schoolStatus;
		this.classRelation = classRelation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPoliticalStatus() {
		return politicalStatus;
	}
	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStuYear() {
		return stuYear;
	}
	public void setStuYear(Integer stuYear) {
		this.stuYear = stuYear;
	}
	public String getTrainingLevel() {
		return trainingLevel;
	}
	public void setTrainingLevel(String trainingLevel) {
		this.trainingLevel = trainingLevel;
	}
	public String getInSchool() {
		return inSchool;
	}
	public void setInSchool(String inSchool) {
		this.inSchool = inSchool;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getSchoolStatus() {
		return schoolStatus;
	}
	public void setSchoolStatus(String schoolStatus) {
		this.schoolStatus = schoolStatus;
	}
	public ClassRelation getClassRelation() {
		return classRelation;
	}
	public void setClassRelation(ClassRelation classRelation) {
		this.classRelation = classRelation;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuId=" + stuId + ", name=" + name + ", sex=" + sex + ", idCard=" + idCard
				+ ", nation=" + nation + ", politicalStatus=" + politicalStatus + ", birthday=" + birthday + ", phone="
				+ phone + ", email=" + email + ", stuYear=" + stuYear + ", trainingLevel=" + trainingLevel
				+ ", inSchool=" + inSchool + ", admissionDate=" + admissionDate + ", schoolStatus=" + schoolStatus
				+ ", classRelation=" + classRelation + "]";
	}
	
	
}
