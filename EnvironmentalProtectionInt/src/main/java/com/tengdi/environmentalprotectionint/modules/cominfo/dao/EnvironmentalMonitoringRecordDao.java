package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.EnvironmentalMonitoringRecordEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 环境监察记录表
 * 
 * @author tengdi
 * @email 
 * @date 2018-12-04 10:50:12
 */
public interface EnvironmentalMonitoringRecordDao extends BaseMapper<EnvironmentalMonitoringRecordEntity> {
	List<EnvironmentalMonitoringRecordEntity> queryList(Map<String,Object> map);

	int queryCount(Map<String,Object> map);

    EnvironmentalMonitoringRecordEntity entityById(String pid);
}
