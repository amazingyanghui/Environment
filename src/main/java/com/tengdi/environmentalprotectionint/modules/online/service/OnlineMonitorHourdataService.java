package com.tengdi.environmentalprotectionint.modules.online.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorHourdataEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 小时数据表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:51:50
 */
public interface OnlineMonitorHourdataService extends IService<OnlineMonitorHourdataEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<OnlineMonitorHourdataEntity> queryList(Map map);

}

