package com.campus.admin.service;

import java.util.List;
import java.util.Map;

import com.campus.entity.ClassRelation;

/**
 * 
 * @ClassName: ClassesService
 * @Description: 班级业务操作接口
 * @Author 12878
 * @DateTime 2020年7月7日 下午9:54:37
 */
public interface ClassesService {

	/**
	 * 
	 * @Title: list
	 * @Description: 查找所有班级信息
	 * @Author 12878
	 * @DateTime 2020年7月7日 下午9:56:50
	 * @return 全部班级信息
	 */
	List<ClassRelation> list();
	
	/**
	 * 
	 * @Title: listByClassRelation
	 * @Description: 获得指定班级信息
	 * @Author 12878
	 * @DateTime 2020年7月7日 下午9:57:47
	 * @param classRelation 班级关系对象
	 * @return 指定班级信息
	 */
	List<ClassRelation> listByClassRelation(ClassRelation classRelation);
	
	/**
	 * 
	 * @Title: save
	 * @Description: 保存或修改班级信息和班级关系对象
	 * @Author 12878
	 * @DateTime 2020年7月7日 下午10:02:34
	 * @param classRelation 班级关系对象
	 * @return 1成功，0失败
	 */
	Map<String, Object> save(ClassRelation classRelation);
}
