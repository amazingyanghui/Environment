package com.tengdi.environmentalprotectionint.modules.emergency.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemDangerousEntity;

import java.util.List;
import java.util.Map;

/**
 * 风险物资（危险化学品）
 * 
 * @author tengdi
 * @email 
 * @date 2018-09-11 11:50:45
 */
public interface EmergencySystemDangerousDao extends BaseMapper<EmergencySystemDangerousEntity> {

    List<EmergencySystemDangerousEntity> queryPage (Map<String,Object> params);

    List<EmergencySystemDangerousEntity> queryName(Map<String,Object> params);

    List<EmergencySystemDangerousEntity> dataById(String cid);

    EmergencySystemDangerousEntity entityById(String pid);

    Integer queryPageSum(Map<String,Object> params);
	
}
