package com.tengdi.environmentalprotectionint.modules.greentax.dao;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteMainEntity;
import java.util.List;
import java.util.Map;
/**
 * 固体废物基础信息采集主表
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 10:20:18
 */
public interface EpSolidWasteMainDao extends BaseMapper<EpSolidWasteMainEntity> {
    List<Map<String,Object>> queryList(QueryCriterias criterias);

    int queryListCount(QueryCriterias criterias);
}
