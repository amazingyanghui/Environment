package com.tengdi.environmentalprotectionint.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysShuiwuranwuEntity;
import net.sf.json.JSONArray;

import java.util.Map;

/**
 * 水污染代码表
 *
 * @author tengdi
 * @email 
 * @date 2018-10-23 11:23:18
 */
public interface SysShuiwuranwuService extends IService<SysShuiwuranwuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    JSONArray getShuiWuRan(String code);
}

