package com.tengdi.environmentalprotectionint.modules.emergency.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemEventEntity;

import java.util.List;
import java.util.Map;

/**
 * 环境应急事件
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:15:20
 */
public interface EmergencySystemEventService extends IService<EmergencySystemEventEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageSql(Map<String, Object> params);

    List<EmergencySystemEventEntity> queryList(Map<String, Object> params);

    List<EmergencySystemEventEntity> dataById(String cid);

    EmergencySystemEventEntity entityById(String pid);

    List<EmergencySystemEventEntity> queryName(Map<String, Object> params);
}

