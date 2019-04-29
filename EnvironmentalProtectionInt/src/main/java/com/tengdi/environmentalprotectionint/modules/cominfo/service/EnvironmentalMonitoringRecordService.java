package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.EnvironmentalMonitoringRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 环境监察记录表
 *
 * @author tengdi
 * @email 
 * @date 2018-12-04 10:50:12
 */
public interface EnvironmentalMonitoringRecordService extends IService<EnvironmentalMonitoringRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<EnvironmentalMonitoringRecordEntity> queryList(Map<String, Object> params);

    EnvironmentalMonitoringRecordEntity entityById(String pid);
}

