package com.campus.admin.service;

import com.campus.entity.Auth;

/**
 * 
 * @ClassName: AuthService
 * @Description: 权限业务操作接口
 * @Author 12878
 * @DateTime 2020年7月8日 上午9:09:29
 */
public interface AuthService {
	
	/**
	 * 
	 * @Title: load
	 * @Description: 查询权限信息
	 * @Author 12878
	 * @DateTime 2020年7月8日 上午9:17:09
	 * @param id 权限id
	 * @return 权限对象
	 */
	Auth load(String id);

	/**
	 * 
	 * @Title: save
	 * @Description: 修改保存权限
	 * @Author 12878
	 * @DateTime 2020年7月8日 上午9:12:06
	 * @param auth 权限对象
	 * @return 1成功，0失败
	 */
	int save(Auth auth);
	
	/**
	 * 
	 * @Title: selectScore
	 * @Description: 查询修改成绩是否开启
	 * @Author 12878
	 * @DateTime 2020年7月8日 上午9:41:03
	 * @return 开启/ 关闭
	 */
	boolean selectScore();
	
	/**
	 * 
	 * @Title: selectStuQuality
	 * @Description: 查询学生素质评价是否开启
	 * @Author 12878
	 * @DateTime 2020年7月8日 上午9:13:39
	 * @return 开启/ 关闭
	 */
	boolean selectStuQuality();
	
	/**
	 * 
	 * @Title: selectTchEvaluation
	 * @Description: 查询驾驶评价是否开启
	 * @Author 12878
	 * @DateTime 2020年7月8日 上午9:14:27
	 * @return 开启/ 关闭
	 */
	boolean selectTchEvaluation();
	
	/**
	 * 
	 * @Title: selectElective
	 * @Description: 查询选课是否开启
	 * @Author 12878
	 * @DateTime 2020年7月8日 上午9:14:56
	 * @return 开启/ 关闭
	 */
	boolean selectElective();
}
