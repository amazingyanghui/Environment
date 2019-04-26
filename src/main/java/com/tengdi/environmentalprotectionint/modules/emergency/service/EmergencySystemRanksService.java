package com.tengdi.environmentalprotectionint.modules.emergency.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemRanksEntity;

import java.util.List;
import java.util.Map;

/**
 * 应急队伍
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:10:45
 */
public interface EmergencySystemRanksService extends IService<EmergencySystemRanksEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<EmergencySystemRanksEntity> queryList(Map<String, Object> params);

    List<EmergencySystemRanksEntity> dataById(String cid);
}

