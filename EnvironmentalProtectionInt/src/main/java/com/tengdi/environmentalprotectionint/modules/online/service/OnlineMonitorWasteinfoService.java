package com.tengdi.environmentalprotectionint.modules.online.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorWasteEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorStoreinfoEntity;

import java.util.Map;

/**
 * 排放污染物信息表
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 16:46:24
 */
public interface OnlineMonitorWasteinfoService extends IService<OnlineMonitorWasteEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

