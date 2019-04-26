package com.tengdi.environmentalprotectionint.modules.online.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPortinfoEntity;
import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 监控点信息表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:11
 */
public interface OnlineMonitorPortinfoService extends IService<OnlineMonitorPortinfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<OnlineMonitorPortinfoEntity> dataById(String cid);

    /**
     * 按条件查询排口（监控口）信息（主要取得坐标数据）
     * @param params
     * @return
     */
    List<OnlineMonitorPortinfoEntity> queryList(Map<String, Object> params);

    List<SelectEntity> list(String cid,Integer type);

    List<SelectEntity> list(String cid);

    /**
     * 创建日数据表
     * @param tableName
     * @return
     */
    int createDateTable(String tableName);

    /**
     * 创建小时数据表
     * @param tableName
     * @return
     */
    int createHourTable(String tableName);

    /**
     * 插入时返回uuid
     * @param entity
     * @return
     */
    String idByInsert(OnlineMonitorPortinfoEntity entity);

    /**
     * 删除日数据表
     * @param tableName
     * @return
     */
    int dropDateTable(String tableName);

    /**
     *删除小时数据表
     * @param tableName
     * @return
     */
    int dropHourTable(String tableName);

    int updateForEnvironment(OnlineMonitorPortinfoEntity entity);

    List<OnlineMonitorPortinfoEntity> noiseBaseInfoById(String cid);
}

