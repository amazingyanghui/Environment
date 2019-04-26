package com.tengdi.environmentalprotectionint.modules.greentax.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpTaxAmountEntity;

import java.util.Map;

/**
 * 环境保护税税目税额表
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:19:00
 */
public interface EpTaxAmountService extends IService<EpTaxAmountEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

