package com.tengdi.environmentalprotectionint.modules.online.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorFactorEntity;
import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 因子信息表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:07
 */
public interface OnlineMonitorFactorService extends IService<OnlineMonitorFactorEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SelectEntity> list(int type);

    /**
     *  在线监控统计-根据统计类型联动获取该类型的污染因子
     */
    List<OnlineMonitorFactorEntity> selFactorByStatisticalType(String type);
    /**
     *  在线监控统计-根据排口获取该排口下的的污染因子
     */
    List<OnlineMonitorFactorEntity> queryFactorByPort(Map map);
}

