package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoTotalControlplanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 企业总量控制计划
 * 
 * @author tengdi
 * @email 
 * @date 2018-12-03 17:54:50
 */
public interface CominfoTotalControlplanDao extends BaseMapper<CominfoTotalControlplanEntity> {
	List<CominfoTotalControlplanEntity> queryList(Map<String,Object> map);

	int queryCount(Map<String,Object> map);

    CominfoTotalControlplanEntity entityById(String pid);

    int insertData(CominfoTotalControlplanEntity entity);
}
