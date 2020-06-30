package com.campus.entity;
/**
 * 
 * @ClassName: Auth
 * @Description: 权限实体类
 * @Author 12878
 * @DateTime 2020年6月30日 下午2:56:43
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Auth {

	/**
	 * 逻辑主键
	 */
	@Id
	private String id;
	/**
	 * 开启修改成绩
	 */
	private Boolean score;
	/**
	 * 开启选课
	 */
	private Boolean elective;
	
	public Auth() {
		super();
	}

	public Auth(String id, Boolean score, Boolean elective) {
		super();
		this.id = id;
		this.score = score;
		this.elective = elective;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getScore() {
		return score;
	}

	public void setScore(Boolean score) {
		this.score = score;
	}

	public Boolean getElective() {
		return elective;
	}

	public void setElective(Boolean elective) {
		this.elective = elective;
	}

	@Override
	public String toString() {
		return "Auth [id=" + id + ", score=" + score + ", elective=" + elective + "]";
	}
}
