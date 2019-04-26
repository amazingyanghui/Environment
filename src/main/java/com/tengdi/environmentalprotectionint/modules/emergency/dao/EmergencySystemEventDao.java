package com.tengdi.environmentalprotectionint.modules.emergency.dao;

import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemEventEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 环境应急事件
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:15:20
 */
public interface EmergencySystemEventDao extends BaseMapper<EmergencySystemEventEntity> {
    /**
     * 分页查询记录（多表联合）
     * @param map
     * @return
     */
    List<EmergencySystemEventEntity> queryList(Map<String,Object> map);
    List<EmergencySystemEventEntity> queryName(Map<String,Object> map);

    List<EmergencySystemEventEntity> dataById(String cid);

    EmergencySystemEventEntity entityById(String pid);

    /**
     * 查询总记录数
     * @param map
     * @return
     */
    int count(Map<String,Object> map);
}
