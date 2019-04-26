package com.tengdi.environmentalprotectionint.modules.greentax.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteMainEntity;
import java.util.Map;

/**
 * 固体废物基础信息采集主表
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 10:20:18
 */
public interface EpSolidWasteMainService extends IService<EpSolidWasteMainEntity> {

    PageUtils queryPage(Map<String, Object> params);

//    PageUtils queryTableData(QueryCriterias criterias);
}

