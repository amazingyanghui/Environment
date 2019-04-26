package com.tengdi.environmentalprotectionint.modules.greentax.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteTaxEntity;
import java.util.Map;
/**
 * 固体废物环保税上报
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:52:02
 */
public interface EpSolidWasteTaxService extends IService<EpSolidWasteTaxEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryTableData(Map<String, Object> params);
}

