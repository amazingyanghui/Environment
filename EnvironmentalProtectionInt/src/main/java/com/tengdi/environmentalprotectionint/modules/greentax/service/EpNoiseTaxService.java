package com.tengdi.environmentalprotectionint.modules.greentax.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpNoiseTaxEntity;
import java.util.Map;

/**
 * 噪音环保税上报
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:51:49
 */
public interface EpNoiseTaxService extends IService<EpNoiseTaxEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryTableData(Map<String, Object> params);
}

