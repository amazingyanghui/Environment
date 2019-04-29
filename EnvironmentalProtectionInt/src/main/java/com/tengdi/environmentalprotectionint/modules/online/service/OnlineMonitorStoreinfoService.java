package com.tengdi.environmentalprotectionint.modules.online.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorStoreinfoEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.Map;

/**
 * 企业数据存放信息表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:02
 */
public interface OnlineMonitorStoreinfoService extends IService<OnlineMonitorStoreinfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

