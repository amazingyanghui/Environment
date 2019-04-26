package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionWaterEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 用水情况
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 14:30:09
 */
public interface CominfoProductionWaterService extends IService<CominfoProductionWaterEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CominfoProductionWaterEntity> queryList(Map<String, Object> params);
}

