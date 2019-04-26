package com.tengdi.environmentalprotectionint.modules.greentax.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpTaxFormulaEntity;

import java.util.Map;

/**
 * 环保税公式，根据行业类别和污染物来适配所用公式
 *
 * @author tengdi
 * @email 
 * @date 2019-03-05 11:19:08
 */
public interface EpTaxFormulaService extends IService<EpTaxFormulaEntity> {

    PageUtils queryPage(Map<String, Object> params);

    EpTaxFormulaEntity queryFormula(Map<String, Object> params);

}

