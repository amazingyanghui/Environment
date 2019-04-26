package com.tengdi.environmentalprotectionint.modules.online.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorHourdataEntity;

import java.util.List;
import java.util.Map;

/**
 * 小时数据表
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:51:50
 */
public interface OnlineMonitorHourdataDao extends BaseMapper<OnlineMonitorHourdataEntity> {
    List<OnlineMonitorHourdataEntity> queryList(Map map);
}
