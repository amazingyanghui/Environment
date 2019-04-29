package com.tengdi.environmentalprotectionint.modules.emergency.dao;

import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemPlanFileEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 应急预案文档
 * 
 * @author tengdi
 * @email 
 * @date 2018-11-19 19:30:17
 */
public interface EmergencySystemPlanFileDao extends BaseMapper<EmergencySystemPlanFileEntity> {
    /**
     * 根据应急预案id查附件
     * @param aid
     * @return
     */
    List<EmergencySystemPlanFileEntity> dataByFile(String aid);
}
