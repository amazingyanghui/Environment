package com.tengdi.environmentalprotectionint.modules.sys.dao;

import com.tengdi.environmentalprotectionint.modules.sys.entity.SysFeedbackInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 反馈主表
 * 
 * @author tengdi
 * @email 
 * @date 2018-11-13 10:15:02
 */
public interface SysFeedbackInfoDao extends BaseMapper<SysFeedbackInfoEntity> {
	List<SysFeedbackInfoEntity> queryList(Map map);

	int queryCount(Map map);

	int insertData(SysFeedbackInfoEntity sysFeedbackInfoEntity);
}
