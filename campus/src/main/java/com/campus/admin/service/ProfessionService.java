package com.campus.admin.service;

import java.util.List;
import java.util.Map;

import com.campus.entity.ClassRelation;
import com.campus.entity.Profession;

/**
 * 
 * @ClassName: ProfessionService
 * @Description: 专业业务操作接口
 * @Author 12878
 * @DateTime 2020年7月7日 下午3:16:43
 */
public interface ProfessionService {

	/**
	 * 
	 * @Title: list
	 * @Description: 获得所有专业信息
	 * @Author 12878
	 * @DateTime 2020年7月7日 下午3:17:43
	 * @return 所有专业信息
	 */
	List<Profession> list();
	
	/**
	 * 
	 * @Title: load
	 * @Description: 根据学院id查询专业信息
	 * @Author 12878
	 * @DateTime 2020年7月7日 下午3:45:08
	 * @param id 学院id
	 * @return 班级关系对象
	 */
	List<ClassRelation> listByCollege(String collegeId);
	
	/**
	 * 
	 * @Title: updateProfession
	 * @Description: 根据专业对象更新或保存专业信息
	 * @Author 12878
	 * @DateTime 2020年7月7日 下午4:39:15
	 * @param profession 专业对象
	 * @return 1成功，0失败
	 */
	Map<String, Object> saveProfession(Profession profession);
}
