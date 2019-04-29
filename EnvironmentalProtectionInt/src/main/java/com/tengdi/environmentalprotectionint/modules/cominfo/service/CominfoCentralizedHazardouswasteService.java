package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias ;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoCentralizedHazardouswasteEntity ;

import java.util.Map;

/**
 * 危险废物集中处置厂运行情况
 *
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:37:58
 */
public interface CominfoCentralizedHazardouswasteService extends IService<CominfoCentralizedHazardouswasteEntity> {

    PageUtils queryPage(Map<String, Object> params);

    //PageUtils queryTableData(QueryCriterias criterias);
}

