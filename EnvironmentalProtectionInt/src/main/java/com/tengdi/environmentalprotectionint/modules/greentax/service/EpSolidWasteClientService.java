package com.tengdi.environmentalprotectionint.modules.greentax.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteClientEntity;
import java.util.Map;

/**
 * 固体废物基础信息采集-
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 10:20:06
 */
public interface EpSolidWasteClientService extends IService<EpSolidWasteClientEntity> {

    PageUtils queryPage(Map<String, Object> params);

//    PageUtils queryTableData(QueryCriterias criterias);
}

