package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
//import com.tengdi.core.utils.QueryCriterias;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoCentralizedSewageEntity ;

import java.util.Map;

/**
 * 集中式污水处理厂运行情况
 *
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:38:07
 */
public interface CominfoCentralizedSewageService extends IService<CominfoCentralizedSewageEntity> {

    PageUtils queryPage(Map<String, Object> params);

    //PageUtils queryTableData(QueryCriterias criterias);
}

