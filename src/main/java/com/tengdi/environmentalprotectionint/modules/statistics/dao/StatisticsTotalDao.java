package com.tengdi.environmentalprotectionint.modules.statistics.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.statistics.entity.StatisticsTotalEntity;

import java.util.List;
import java.util.Map;

/**
 * 大屏图
 * 
 * @author tengdi
 * @email 
 * @date 2018-10-26 10:10:19
 */
public interface StatisticsTotalDao extends BaseMapper<StatisticsTotalEntity> {
	List<StatisticsTotalEntity> queryList(Map map);

	List<StatisticsTotalEntity> getCompanyType(Map<String,Object> map);
}
