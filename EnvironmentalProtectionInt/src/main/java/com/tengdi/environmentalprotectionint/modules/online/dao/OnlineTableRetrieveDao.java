package com.tengdi.environmentalprotectionint.modules.online.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineTableRetrieveEntity;

import java.util.List;
import java.util.Map;

/**
 * 表名检索表
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-24 10:54:40
 */
public interface OnlineTableRetrieveDao extends BaseMapper<OnlineTableRetrieveEntity> {
    OnlineTableRetrieveEntity dataById(String mid);

    OnlineTableRetrieveEntity dataByCid(Map map);

    /**
     * 获取某类型排口表名
     * @param map
     * @return
     */
    List<Map<String, Object>> queryPortTable(Map map);

}
