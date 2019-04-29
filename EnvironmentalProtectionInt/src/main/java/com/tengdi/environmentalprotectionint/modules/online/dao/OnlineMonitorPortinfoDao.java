package com.tengdi.environmentalprotectionint.modules.online.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPortinfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 监控点信息表
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:11
 */
public interface OnlineMonitorPortinfoDao extends BaseMapper<OnlineMonitorPortinfoEntity> {

    /**
     * 按条件查询排口（监控口）信息（主要取得坐标数据）
     * @param params
     * @return
     */
    List<OnlineMonitorPortinfoEntity> queryList(Map<String, Object> params);

    List<OnlineMonitorPortinfoEntity> dataById(String cid);

    /**
     * 创建日数据表
     * @param tableName
     * @return
     */
    int createDateTable(@Param("tableName")String tableName);

    /**
     * 创建小时数据表
     * @param tableName
     * @return
     */
	int createHourTable(@Param("tableName")String tableName);

    /**
     * 插入时返回uuid
     * @param entity
     * @return
     */
	int idByInsert(OnlineMonitorPortinfoEntity entity);

    /**
     * 删除日数据表
     * @param tableName
     * @return
     */
	int dropDateTable(@Param("tableName")String tableName);

    /**
     *删除小时数据表
     * @param tableName
     * @return
     */
	int dropHourTable(@Param("tableName")String tableName);

    /**
     * 分页查询记录（多表联合）
     * @param map
     * @return
     */
    List<OnlineMonitorPortinfoEntity> queryData(Map<String,Object> map);
    /**
     * 查询总记录数
     * @param map
     * @return
     */
    int queryCount(Map<String,Object> map);

    int updateForEnvironment(OnlineMonitorPortinfoEntity entity);

    /**
     * 通过企业ID查询 噪声税情况
     * @param cid
     * @return
     */
    List<OnlineMonitorPortinfoEntity> noiseBaseInfoById(String cid);
}
