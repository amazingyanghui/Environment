package com.tengdi.environmentalprotectionint.modules.greentax.dao;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteClientEntity;
import java.util.List;
import java.util.Map;
/**
 * 固体废物基础信息采集-
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 10:20:06
 */
public interface EpSolidWasteClientDao extends BaseMapper<EpSolidWasteClientEntity> {
    List<Map<String,Object>> queryList(QueryCriterias criterias);

    int queryListCount(QueryCriterias criterias);
}
