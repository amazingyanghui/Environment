package com.tengdi.environmentalprotectionint.modules.zoneinfo.dao;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.zoneinfo.entity.ZoneinfoBaseinfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.zoneinfo.entity.ZoneinfoBaseinfoEntity;

import java.util.List;
import java.util.Map;
/**
 * 园区环境管理信息
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-11 09:56:11
 */
public interface ZoneinfoBaseinfoDao extends BaseMapper<ZoneinfoBaseinfoEntity> {
    List<Map<String,Object>> queryList(Map<String, Object> params);

    int queryCount(Map<String, Object> params);
}
