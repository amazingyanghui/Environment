package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionEquipmentEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 生产设备
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:42:48
 */
public interface CominfoProductionEquipmentService extends IService<CominfoProductionEquipmentEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CominfoProductionEquipmentEntity> queryList(Map<String, Object> params);

    CominfoProductionEquipmentEntity entityById(String pid);
}

