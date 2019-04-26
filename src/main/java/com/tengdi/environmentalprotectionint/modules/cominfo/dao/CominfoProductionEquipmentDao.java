package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionEquipmentEntity;

import java.util.List;
import java.util.Map;

/**
 * 生产设备
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:42:48
 */
public interface CominfoProductionEquipmentDao extends BaseMapper<CominfoProductionEquipmentEntity> {

	List<CominfoProductionEquipmentEntity> queryData(Map<String,Object> params);

	int queryCount(Map<String,Object> params);

    List<CominfoProductionEquipmentEntity> dataById(Map<String,Object> params);

    CominfoProductionEquipmentEntity entityById(String pid);
}
