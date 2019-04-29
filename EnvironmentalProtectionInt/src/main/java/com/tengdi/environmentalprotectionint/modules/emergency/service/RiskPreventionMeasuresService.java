package com.tengdi.environmentalprotectionint.modules.emergency.service;


import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
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
public interface RiskPreventionMeasuresService extends IService<RiskPreventionMeasuresEntity> {

    PageUtils queryPage(Map<String, Object> params);

    RiskPreventionMeasuresEntity entityById(String pid);

    List<RiskPreventionMeasuresEntity> queryList(Map<String,Object> params);

    PageUtils queryPageSql(Map<String,Object> params);
}

