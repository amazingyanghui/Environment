package com.tengdi.environmentalprotectionint.modules.online.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.common.entity.OnlineCommonEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorDaydataEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorFactorEntity;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import net.sf.json.JSONArray;

import java.util.List;
import java.util.Map;

/**
 * 日数据存放表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:51:57
 */
public interface OnlineMonitorDaydataService extends IService<OnlineMonitorDaydataEntity> {

    List<SysDictEntity> dictList(String type);

    PageUtils queryPage(Map<String, Object> params);

    List<OnlineMonitorDaydataEntity> queryList(Map map);

    OnlineCommonEntity onlineDayData(OnlineCommonEntity onlineCommonEntity);

    List<OnlineMonitorDaydataEntity> getDataFromRedis(Map<String, Object> params);
    /**
     * 在线监控统计-监控企业、重点监控、水监控、气监控、voc监控
     */
    List<Map<String,Object>> onlineMonitoring();
    /**
     *  在线监控统计-根据统计类型联动获取该类型的污染因子
     */
    List<OnlineMonitorFactorEntity> selFactorByStatisticalType(String type);
    /**
     * 在线监控统计-月排放量统计
     */
    Object [] monthlyEmissionStatistics(String year,String type,String fid);
    /**
     * 在线监控统计-月排放量统计数据类型转换
     */
    JSONArray monthlyEmissionStatisticsConversion(int[] monthContainer);
    /**
     * 在线监控统计-本年排放量与去年对比
     */
    Double [] yearAndLastyearContrastByEmissions(String year,String type,String fid);
    /**
     * 在线监控统计-排放量排行榜
     */
    Map<String, Object>  emissionRanking (String year,String type,String  fid);
    /**
     * 在线监控统计-废水实时排放情况
     */
    Map<String, Object> RealtimeEmissions(String year,String currentmonth,String currentlastmonth);
    /**
     * 在线监控企业列表查询
     */
    PageUtils onlineMonitoringEnterpriseList(Map<String,Object> params);
    /**
     * 获取行业列表跟字典表映射获得对应名称
     */
    String getIndustry(String code);
}

