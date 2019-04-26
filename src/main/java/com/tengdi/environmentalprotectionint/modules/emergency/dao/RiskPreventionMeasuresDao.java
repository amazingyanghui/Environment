package com.tengdi.environmentalprotectionint.modules.emergency.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.RiskPreventionMeasuresEntity;

import java.util.List;
import java.util.Map;

/**
 * 风险防范措施
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-13 10:36:05
 */
public interface RiskPreventionMeasuresDao extends BaseMapper<RiskPreventionMeasuresEntity> {

    RiskPreventionMeasuresEntity entityById(String pid);

    List<RiskPreventionMeasuresEntity> queryList(Map<String,Object> params);

    int count(Map<String,Object> params);
}
