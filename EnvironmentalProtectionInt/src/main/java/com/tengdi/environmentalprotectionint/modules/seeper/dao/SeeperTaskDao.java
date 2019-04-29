package com.tengdi.environmentalprotectionint.modules.seeper.dao;

import com.tengdi.environmentalprotectionint.modules.seeper.entity.SeeperTaskEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 江北新区积淹水点整治任务表
 * 
 * @author tengdi
 * @email 
 * @date 2018-10-26 10:10:19
 */
public interface SeeperTaskDao extends BaseMapper<SeeperTaskEntity> {
	List<SeeperTaskEntity> queryList(Map map);

	int queryCount(Map map);
}
