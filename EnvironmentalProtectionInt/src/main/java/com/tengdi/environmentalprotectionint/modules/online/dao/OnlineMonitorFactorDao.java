package com.tengdi.environmentalprotectionint.modules.online.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorFactorEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 因子信息表
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:07
 */
public interface OnlineMonitorFactorDao extends BaseMapper<OnlineMonitorFactorEntity> {
    /**
     * 分页查询记录（多表联合）
     * @param map
     * @return
     */
    List<OnlineMonitorFactorEntity> queryData(Map<String,Object> map);
    /**
     * 查询总记录数
     * @param map
     * @return
     */
    int queryCount(Map<String,Object> map);

    /**
     * 因子下拉框
     * @param type
     * @return
     */
    List<OnlineMonitorFactorEntity> selectList(@Param("type")int type);

    /**
     *在线监控统计-根据统计类型联动获取该类型的污染因子
     */
    List<OnlineMonitorFactorEntity> selFactorByStatisticalType(String type);

    /**
     *在线监控统计-根据排口获取该类型的污染因子
     */
    List<OnlineMonitorFactorEntity> queryFactorByPort(Map map);

}
