package com.tengdi.environmentalprotectionint.modules.emergency.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemDrillFileEntity;

import java.util.List;
import java.util.Map;

/**
 * 应急演练文档
 *
 * @author tengdi
 * @email 
 * @date 2018-11-19 19:30:23
 */
public interface EmergencySystemDrillFileService extends IService<EmergencySystemDrillFileEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 根据应急演练id查附件
     * @param aid
     * @return
     */
    List<EmergencySystemDrillFileEntity> dataByFile(String aid);
}

