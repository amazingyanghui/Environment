package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionEnergyEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 能源消耗
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:00
 */
public interface CominfoProductionEnergyService extends IService<CominfoProductionEnergyEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CominfoProductionEnergyEntity> queryList(Map<String, Object> params);
}

