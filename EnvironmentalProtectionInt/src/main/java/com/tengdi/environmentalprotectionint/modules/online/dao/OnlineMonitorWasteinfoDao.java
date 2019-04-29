package com.tengdi.environmentalprotectionint.modules.online.dao;

import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPortinfoEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorStoreinfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorWasteEntity;

import java.util.List;
import java.util.Map;

/**
 * 排放污染物信息表
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-06 16:46:24
 */
public interface OnlineMonitorWasteinfoDao extends BaseMapper<OnlineMonitorWasteEntity> {
    /**
     * 分页查询记录（多表联合）
     * @param map
     * @return
     */
    List<OnlineMonitorWasteEntity> queryList(Map<String,Object> map);
    /**
     * 查询总记录数
     * @param map
     * @return
     */
    int queryCount(Map<String,Object> map);
}
