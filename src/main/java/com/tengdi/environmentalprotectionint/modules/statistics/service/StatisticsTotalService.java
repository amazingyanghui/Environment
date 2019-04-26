package com.tengdi.environmentalprotectionint.modules.statistics.service;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.statistics.entity.StatisticsTotalEntity;

import java.util.List;
import java.util.Map;

/**
 * 大屏图
 *
 * @author tengdi
 * @email 
 * @date 2018-10-26 10:10:19
 */
public interface StatisticsTotalService extends IService<StatisticsTotalEntity> {

    List<StatisticsTotalEntity> queryList(Map<String, Object> params);

    List<StatisticsTotalEntity> getCompanyType(Map<String,Object> map);

    JSONArray getMonitorPoint(String url);//接.net的接口

    JSONArray getJavaMonitorPoint(String url);//接java的接口
}

