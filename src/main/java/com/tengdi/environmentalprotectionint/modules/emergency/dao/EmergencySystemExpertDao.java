package com.tengdi.environmentalprotectionint.modules.emergency.dao;

import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemExpertEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 专家信息
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:13:57
 */
public interface EmergencySystemExpertDao extends BaseMapper<EmergencySystemExpertEntity> {
	List<EmergencySystemExpertEntity> queryList(Map map);

	List<EmergencySystemExpertEntity> dataById(String cid);

	EmergencySystemExpertEntity entityById(String pid);

	int queryCount(Map map);
}
