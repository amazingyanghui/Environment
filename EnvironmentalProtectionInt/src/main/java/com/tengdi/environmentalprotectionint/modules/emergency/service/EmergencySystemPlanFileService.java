package com.tengdi.environmentalprotectionint.modules.emergency.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemPlanFileEntity;

import java.util.List;
import java.util.Map;

/**
 * 应急预案文档
 *
 * @author tengdi
 * @email 
 * @date 2018-11-19 19:30:17
 */
public interface EmergencySystemPlanFileService extends IService<EmergencySystemPlanFileEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 根据应急预案id查附件
     * @param aid
     * @return
     */
    List<EmergencySystemPlanFileEntity> dataByFile(String aid);
}

