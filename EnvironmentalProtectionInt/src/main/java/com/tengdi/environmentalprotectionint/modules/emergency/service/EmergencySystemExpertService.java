package com.tengdi.environmentalprotectionint.modules.emergency.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemExpertEntity;

import java.util.List;
import java.util.Map;

/**
 * 专家信息
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:13:57
 */
public interface EmergencySystemExpertService extends IService<EmergencySystemExpertEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<EmergencySystemExpertEntity> queryList(Map<String, Object> params);

    EmergencySystemExpertEntity entityById(String pid);

    List<EmergencySystemExpertEntity> dataById(String cid);
}

