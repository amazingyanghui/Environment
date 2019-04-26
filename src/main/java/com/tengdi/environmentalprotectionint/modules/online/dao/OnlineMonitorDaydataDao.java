package com.tengdi.environmentalprotectionint.modules.online.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorDaydataEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorFactorEntity;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;

import java.util.List;
import java.util.Map;

/**
 * 日数据存放表
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:51:57
 */
public interface OnlineMonitorDaydataDao extends BaseMapper<OnlineMonitorDaydataEntity> {
    List<SysDictEntity> dictList(String type);
    List<OnlineMonitorDaydataEntity> queryList(Map map);
    /**
     * 在线监控统计-监控企业、重点监控、水监控、气监控、voc监控
     */
    List<Map<String,Object>> onlineMonitoring();
    /**
     *在线监控统计-根据统计类型联动获取该类型的污染因子
     */
    List<OnlineMonitorFactorEntity> selFactorByStatisticalType(String type);
    /**
     * 获取所有日数据表
     */
    List<OnlineMonitorDaydataEntity> selDailyData(Map<String, Object> map);
    List<OnlineMonitorDaydataEntity> selDailyDatalastYear(Map<String, Object> map);
    /**
     * 查询某年每个月某因子的日数据表信息
     */
    List<OnlineMonitorDaydataEntity> selDailyDataByfactorGroupMonth(Map<String, Object> map);
    /**
     * 判断表是否存在
     */
    Integer selTbaleName(Map<String, Object> map);
    /**
     * 查询今年和去年某因子的日数据表信息
     */
    List<Map<String, Number>> selDailyDataByfactorGroupYear(Map<String, Object> map);

    /**
     *获取所有企业某因子排行数据
     */
    List<Map<String,Object>> enterprise(Map<String, Object> map);
    List<Map<String,Object>> dailyDataTable(String cid);
    List<Map<String,Object>> rankingSum(String mid);
    /**
     * 在线监控统计-废水实时排放情况
     */
    List< Map<String, Object> >  wasteWaterDischargeForYear(Map<String, Object> map);
    List<OnlineMonitorDaydataEntity> wasteWaterDischarge(Map<String, Object> map);
    /**
     * 查询在线监控企业列表
     */
    List<CominfoBaseinfoEntity> onlineMonitoringEnterpriseList(Map<String, Object> query);
    /**
     * 查询在线监控企业列表总数
     */
    int onlineMonitoringEnterpriseListCount(Map<String, Object> params);
}
