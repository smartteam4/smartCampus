package com.campus.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 教师
 * @author DH
 *
 */
@Document
public class Teacher {
	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 职工号
	 */
	private String tchId;
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
	 * 职称
	 */
	private String jobTtitle;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 入职时间
	 */
	private Date entryTime;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 电子邮箱
	 */
	private String email;

	public Teacher() {
		super();
	}

	public Teacher(String id, String tchId, String name, String sex, String idCard, String nation,
			String politicalStatus, String jobTtitle, Date birthday, Date entryTime, String phone, String email) {
		super();
		this.id = id;
		this.tchId = tchId;
		this.name = name;
		this.sex = sex;
		this.idCard = idCard;
		this.nation = nation;
		this.politicalStatus = politicalStatus;
		this.jobTtitle = jobTtitle;
		this.birthday = birthday;
		this.entryTime = entryTime;
		this.phone = phone;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTchId() {
		return tchId;
	}

	public void setTchId(String tchId) {
		this.tchId = tchId;
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

	public String getJobTtitle() {
		return jobTtitle;
	}

	public void setJobTtitle(String jobTtitle) {
		this.jobTtitle = jobTtitle;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
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

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", tchId=" + tchId + ", name=" + name + ", sex=" + sex + ", idCard=" + idCard
				+ ", nation=" + nation + ", politicalStatus=" + politicalStatus + ", jobTtitle=" + jobTtitle
				+ ", birthday=" + birthday + ", entryTime=" + entryTime + ", phone=" + phone + ", email=" + email + "]";
	}
}
