package com.tengdi.environmentalprotectionint.modules.emergency.dao;

import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemPlanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 应急预案
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:12:16
 */
public interface EmergencySystemPlanDao extends BaseMapper<EmergencySystemPlanEntity> {

    /**
     * 分页查询记录（多表联合）
     * @param map
     * @return
     */
    List<EmergencySystemPlanEntity> queryList(Map<String,Object> map);
    List<EmergencySystemPlanEntity> queryName(Map<String,Object> map);

    List<EmergencySystemPlanEntity> dataById(String cid);

    /**
     * 插入环境预案
     * @param entity
     * @return
     */
    int insertData(EmergencySystemPlanEntity entity);

    EmergencySystemPlanEntity entityById(String pid);

    /**
     * 查询总记录数
     * @param map
     * @return
     */
    int count(Map<String,Object> map);
}
