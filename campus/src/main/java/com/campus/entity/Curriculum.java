package com.campus.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 课表
 * @author DH
 *
 */
@Document
public class Curriculum {
	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 学期
	 */
	private String schoolTerm;
	/**
	 * 第几周
	 */
	private String weekend;
	/**
	 * 班级关系对象
	 */
	@DBRef
	private ClassRelation classRelation;
	/**
	 * 第几节课
	 */
	private String time;
	/**
	 * 星期几
	 */
	private String day;
	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 结束时间
	 */
	private String endTime;
	/**
	 * 授课对象
	 */
	@DBRef
	private Teach teach;
	/**
	 * 教室对象
	 */
	@DBRef
	private Classroom classroom;
	
	public Curriculum() {
		super();
	}

	public Curriculum(String id, String schoolTerm, String weekend, ClassRelation classRelation, String time,
			String day, String startTime, String endTime, Teach teach, Classroom classroom) {
		super();
		this.id = id;
		this.schoolTerm = schoolTerm;
		this.weekend = weekend;
		this.classRelation = classRelation;
		this.time = time;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.teach = teach;
		this.classroom = classroom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSchoolTerm() {
		return schoolTerm;
	}

	public void setSchoolTerm(String schoolTerm) {
		this.schoolTerm = schoolTerm;
	}

	public String getWeekend() {
		return weekend;
	}

	public void setWeekend(String weekend) {
		this.weekend = weekend;
	}

	public ClassRelation getClassRelation() {
		return classRelation;
	}

	public void setClassRelation(ClassRelation classRelation) {
		this.classRelation = classRelation;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Teach getTeach() {
		return teach;
	}

	public void setTeach(Teach teach) {
		this.teach = teach;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	@Override
	public String toString() {
		return "Curriculum [id=" + id + ", schoolTerm=" + schoolTerm + ", weekend=" + weekend + ", classRelation="
				+ classRelation + ", time=" + time + ", day=" + day + ", startTime=" + startTime + ", endTime="
				+ endTime + ", teach=" + teach + ", classroom=" + classroom + "]";
	}
}
