package com.tengdi.environmentalprotectionint.modules.emergency.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemDrillEntity;

import java.util.List;
import java.util.Map;

/**
 * 应急演练
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:16:54
 */
public interface EmergencySystemDrillService extends IService<EmergencySystemDrillEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageSql(Map<String, Object> params);

    List<EmergencySystemDrillEntity> queryList(Map<String, Object> params);

    List<EmergencySystemDrillEntity> dataById(String cid);

    EmergencySystemDrillEntity entityById(String pid);

    List<EmergencySystemDrillEntity> queryName(Map<String, Object> params);

    /**
     * 插入环境演练
     * @param entity
     * @return
     */
    String insertData(EmergencySystemDrillEntity entity);
}

