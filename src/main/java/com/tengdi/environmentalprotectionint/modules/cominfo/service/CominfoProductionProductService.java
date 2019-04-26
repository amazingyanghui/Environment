package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionProductEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 主要产品
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:42:18
 */
public interface CominfoProductionProductService extends IService<CominfoProductionProductEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CominfoProductionProductEntity> queryList(Map<String, Object> params);
}

