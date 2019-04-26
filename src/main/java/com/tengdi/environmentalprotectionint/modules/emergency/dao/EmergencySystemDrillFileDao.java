package com.tengdi.environmentalprotectionint.modules.emergency.dao;

import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemDrillFileEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 应急演练文档
 * 
 * @author tengdi
 * @email 
 * @date 2018-11-19 19:30:23
 */
public interface EmergencySystemDrillFileDao extends BaseMapper<EmergencySystemDrillFileEntity> {
    /**
     * 根据应急演练id查附件
     * @param aid
     * @return
     */
    List<EmergencySystemDrillFileEntity> dataByFile(String aid);
}
