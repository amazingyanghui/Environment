package com.tengdi.environmentalprotectionint.modules.greentax.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpTaxFormulaItemEntity;

import java.util.Map;

/**
 * 环保税公式的公式项
 *
 * @author tengdi
 * @email 
 * @date 2019-03-05 11:19:12
 */
public interface EpTaxFormulaItemService extends IService<EpTaxFormulaItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

