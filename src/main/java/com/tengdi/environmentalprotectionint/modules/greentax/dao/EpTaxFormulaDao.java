package com.tengdi.environmentalprotectionint.modules.greentax.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpTaxFormulaEntity;

import java.util.Map;
/**
 * 环保税公式，根据行业类别和污染物来适配所用公式
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-05 11:19:08
 */
public interface EpTaxFormulaDao extends BaseMapper<EpTaxFormulaEntity> {

    EpTaxFormulaEntity selectByParam(Map<String, Object> params);

}
