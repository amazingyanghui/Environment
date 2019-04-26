package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalAttributesEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.Map;

/**
 * 环境属性
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:34
 */
public interface CominfoEnvironmentalAttributesService extends IService<CominfoEnvironmentalAttributesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    CominfoEnvironmentalAttributesEntity dataById(String cid);
}

