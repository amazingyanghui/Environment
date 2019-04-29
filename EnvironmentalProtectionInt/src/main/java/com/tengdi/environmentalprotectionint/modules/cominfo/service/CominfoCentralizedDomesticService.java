package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias ;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoCentralizedDomesticEntity ;

import java.util.Map;

/**
 * 生活垃圾集中处置厂运行情况
 *
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:38:04
 */
public interface CominfoCentralizedDomesticService extends IService<CominfoCentralizedDomesticEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryTableData(Map<String, Object> params);

   // PageUtils queryTableData(QueryCriterias criterias);
}

