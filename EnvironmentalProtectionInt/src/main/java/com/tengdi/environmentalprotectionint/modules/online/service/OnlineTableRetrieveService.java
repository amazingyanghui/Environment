package com.tengdi.environmentalprotectionint.modules.online.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineTableRetrieveEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 表名检索表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-24 10:54:40
 */
public interface OnlineTableRetrieveService extends IService<OnlineTableRetrieveEntity> {

    PageUtils queryPage(Map<String, Object> params);

    OnlineTableRetrieveEntity dataById(String mid);

    OnlineTableRetrieveEntity dataByCid(Map map);

    /**
     * 获取排口表名称
     * @param map
     * @return
     */
    List<Map<String, Object>> queryPortTable(Map map);
}

