package com.campus.admin.service;

import java.util.List;
import java.util.Map;

import com.campus.entity.Teacher;

public interface AdminTeacherService {
	/**
	 * 查询所有教师的信息
	 * @return 返回教师集合
	 */
	List<Teacher> listTeachers();
	/**
	 * 根据指定id查询教师信息
	 * @param id 教师id
	 * @return
	 */
	Teacher loadTeacher(String id);
	/**
	 * 添加教师
	 * @param teacher	教师对象
	 * @return 返回1或0
	 */
	Map<String, Object> saveTeacher(Teacher teacher);
	/**
	 * 查询职工号值
	 */
	void cha();
	/**
	 * 修改教师的基本信息
	 * @param teacher	教师对象
	 * @return
	 */
	Map<String, Object> update(Teacher teacher);
	
}
