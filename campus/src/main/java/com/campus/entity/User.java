package com.campus.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 
 * @ClassName: User
 * @Description: 用户实体类，使用JPA进行数据操作
 * @Author 12878
 * @DateTime 2020年6月29日 下午4:16:22
 */
@Entity
public class User {

	/**
	 * 逻辑主键
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 用户名
	 */
    @Column(length = 30)
	private String username;
	/**
	 * 密码
	 */
	@Column(length = 150)
	private String password;
	/**
	 * 角色
	 */
	private String role;
	/**
	 * 状态
	 */
	private Boolean status;
	public User() {
		super();
	}
	public User(Integer id, String username, String password, String role, Boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", status="
				+ status + "]";
	}
	
}
