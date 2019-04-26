package com.tengdi.environmentalprotectionint.modules.emergency.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemSuppliesEntity;

import java.util.List;
import java.util.Map;

/**
 * 应急物资
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:05:22
 */
public interface EmergencySystemSuppliesService extends IService<EmergencySystemSuppliesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<EmergencySystemSuppliesEntity> queryList(Map<String, Object> params);

    List<EmergencySystemSuppliesEntity> queryName(Map<String,Object> map);

    List<EmergencySystemSuppliesEntity> dataById(String cid);

    EmergencySystemSuppliesEntity entityById(String pid);
}

