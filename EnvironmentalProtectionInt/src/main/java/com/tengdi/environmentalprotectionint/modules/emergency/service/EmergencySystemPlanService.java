package com.tengdi.environmentalprotectionint.modules.emergency.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemPlanEntity;

import java.util.List;
import java.util.Map;

/**
 * 应急预案
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:12:16
 */
public interface EmergencySystemPlanService extends IService<EmergencySystemPlanEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageSql(Map<String, Object> params);
    List<EmergencySystemPlanEntity> queryList(Map<String, Object> params);

    List<EmergencySystemPlanEntity> queryName(Map<String, Object> params);

    List<EmergencySystemPlanEntity> dataById(String cid);

    EmergencySystemPlanEntity entityById(String pid);

    /**
     * 插入环境预案
     * @param entity
     * @return
     */
    String insertData(EmergencySystemPlanEntity entity);
}

