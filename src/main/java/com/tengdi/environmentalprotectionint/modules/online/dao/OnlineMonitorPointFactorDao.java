package com.tengdi.environmentalprotectionint.modules.online.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPointFactorEntity;

import java.util.List;
import java.util.Map;

/**
 * 监控点监控因子信息表
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:16
 */
public interface OnlineMonitorPointFactorDao extends BaseMapper<OnlineMonitorPointFactorEntity> {
    /**
     * 根据因子id和排口id获取数据(去重)
     * @param map
     * @return
     */
    OnlineMonitorPointFactorEntity dataByFid(Map map);

    /**
     * 根据排口id获取因子数
     * @param mid
     * @return
     */
    List<OnlineMonitorPointFactorEntity> dataByMid(String mid);

    /**
     * 分页查询记录（多表联合）
     * @param map
     * @return
     */
    List<OnlineMonitorPointFactorEntity> queryData(Map<String,Object> map);
    /**
     * 查询总记录数
     * @param map
     * @return
     */
    int queryCount(Map<String,Object> map);

    /**
     * 查询某类型排口
     */
    List<OnlineMonitorPointFactorEntity> queryDrains(Map map);
    /**
     * 统计不同类型的排口数量
     */
    List<OnlineMonitorPointFactorEntity>  drainsBaseInfo(String  pid);

    /**
     * 某个因子每月排放统计
     */
    List<OnlineMonitorPointFactorEntity> monthDrainsFactor(Map map);

    /**
     * 某因子年度统计
     */
    List<OnlineMonitorPointFactorEntity> yearDrainsFactor(Map map);

    /**
     * 某因子排放浓度统计
     */
    List<OnlineMonitorPointFactorEntity> monthDrainsFactorPotency(Map map);

    /**
     *排口因子排放排名查询。
     */
    List<Map<String, Object>> drainsFactorRanking(Map map);

}
