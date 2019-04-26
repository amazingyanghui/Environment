package com.tengdi.environmentalprotectionint.modules.emergency.dao;

import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemSuppliesEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 应急物资
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:05:22
 */
public interface EmergencySystemSuppliesDao extends BaseMapper<EmergencySystemSuppliesEntity> {
    /**
     * 分页查询记录（多表联合）
     * @param map
     * @return
     */
    List<EmergencySystemSuppliesEntity> queryPage(Map<String,Object> map);
    List<EmergencySystemSuppliesEntity> queryName(Map<String,Object> map);

    List<EmergencySystemSuppliesEntity> dataById(String cid);

    EmergencySystemSuppliesEntity entityById(String pid);

    /**
     * 查询总记录数
     * @param map
     * @return
     */
    int queryCount(Map<String,Object> map);
}
