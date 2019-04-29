package com.tengdi.environmentalprotectionint.modules.emergency.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemDangerousEntity;
import com.tengdi.core.utils.PageUtils;


import java.util.List;
import java.util.Map;

/**
 * 风险物资（危险化学品）
 *
 * @author tengdi
 * @email 
 * @date 2018-09-11 11:50:45
 */
public interface EmergencySystemDangerousService extends IService<EmergencySystemDangerousEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<EmergencySystemDangerousEntity> queryList(Map<String, Object> params);

    List<EmergencySystemDangerousEntity> queryName(Map<String,Object> params);

    List<EmergencySystemDangerousEntity> dataById(String cid);

    EmergencySystemDangerousEntity entityById(String pid);

}

