package com.tengdi.environmentalprotectionint.modules.zoneinfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.zoneinfo.entity.ZoneinfoBaseinfoEntity ;

import java.util.Map;

/**
 * 园区环境管理信息
 *
 * @author tengdi
 * @email 
 * @date 2019-03-11 09:56:11
 */
public interface ZoneinfoBaseinfoService extends IService<ZoneinfoBaseinfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

   PageUtils queryTableData(Map<String, Object> params);
}

