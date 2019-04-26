package com.tengdi.environmentalprotectionint.modules.emergency.dao;

import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemDrillEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 应急演练
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:16:54
 */
public interface EmergencySystemDrillDao extends BaseMapper<EmergencySystemDrillEntity> {


    /**
     * 分页查询记录（多表联合）
     * @param map
     * @return
     */
    List<EmergencySystemDrillEntity> queryList(Map<String,Object> map);
    List<EmergencySystemDrillEntity> queryName(Map<String,Object> map);

    List<EmergencySystemDrillEntity> dataById(String cid);

    /**
     * 插入环境演练
     * @param entity
     * @return
     */
    int insertData(EmergencySystemDrillEntity entity);

    EmergencySystemDrillEntity entityById(String pid);

    /**
     * 查询总记录数
     * @param map
     * @return
     */
    int count(Map<String,Object> map);
}
