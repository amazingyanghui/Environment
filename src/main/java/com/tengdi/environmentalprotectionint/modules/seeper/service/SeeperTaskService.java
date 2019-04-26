package com.tengdi.environmentalprotectionint.modules.seeper.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.seeper.entity.SeeperTaskEntity;

import java.util.Map;

/**
 * 江北新区积淹水点整治任务表
 *
 * @author tengdi
 * @email 
 * @date 2018-10-26 10:10:19
 */
public interface SeeperTaskService extends IService<SeeperTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

