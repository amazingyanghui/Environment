package com.tengdi.environmentalprotectionint.modules.online.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPointFactorEntity;
import com.tengdi.core.utils.PageUtils;
import net.sf.json.JSONArray;

import java.util.List;
import java.util.Map;

/**
 * 监控点监控因子信息表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:16
 */
public interface OnlineMonitorPointFactorService extends IService<OnlineMonitorPointFactorEntity> {

    PageUtils queryPage(Map<String, Object> params);

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
     * 查询某类型排口
     * @param map
     * @return
     */
    List<OnlineMonitorPointFactorEntity> queryDrains(Map map);

    /**
     * 统计不同类型排口
     * drainsBaseInfo
     */

    JSONArray  drainsBaseInfo(String pid) ;

    /**
     * 每月因子排放统计
     */
    JSONArray monthDrainsFactor(Map map);



    /**
     * 年度因子排放统计
     */
    JSONArray yearDrainsFactor(Map map);

    /**
     * 排放浓度统计
     * @param map
     * @return
     */
    JSONArray monthDrainsFactorPotency(Map map);

    JSONArray selFactorByRanking(Map map);
}

