package com.tengdi.environmentalprotectionint.modules.greentax.dao;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteMeasuresEntity;
import java.util.List;
import java.util.Map;
/**
 * 固体废物基础信息采集-污染防治措施表
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 10:20:29
 */
public interface EpSolidWasteMeasuresDao extends BaseMapper<EpSolidWasteMeasuresEntity> {
    List<Map<String,Object>> queryList(QueryCriterias criterias);

    int queryListCount(QueryCriterias criterias);

    List<EpSolidWasteMeasuresEntity> getSolidWaste(String cid);
}
