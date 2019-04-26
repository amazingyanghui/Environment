package com.tengdi.environmentalprotectionint.modules.emergency.dao;

import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemRanksEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 应急队伍
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:10:45
 */
public interface EmergencySystemRanksDao extends BaseMapper<EmergencySystemRanksEntity> {
    List<EmergencySystemRanksEntity> queryList(Map map);

    List<EmergencySystemRanksEntity> dataById(String cid);

    int queryCount(Map map);
}
