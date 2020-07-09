package com.campus.admin.service;

import java.util.List;
import java.util.Map;

import com.campus.entity.College;

/**
 * 
 * @ClassName: CollegeService
 * @Description: 学院业务操作接口
 * @Author 12878
 * @DateTime 2020年7月7日 上午10:34:41
 */
public interface CollegeService {

	/**
	 * 
	 * @Title: findAll
	 * @Description: 查找所有学院信息
	 * @Author 12878
	 * @DateTime 2020年7月7日 上午10:35:15
	 * @return
	 */
	List<College> findAll();
	
	/**
	 * 
	 * @Title: saveCollege
	 * @Description: 保存学院信息
	 * @Author 12878
	 * @DateTime 2020年7月7日 上午10:36:23
	 * @param college
	 * @return 1成功，0失败
	 */
	Map<String, Object> saveCollege(College college);
}
