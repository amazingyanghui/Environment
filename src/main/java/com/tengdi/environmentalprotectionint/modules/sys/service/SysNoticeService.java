package com.tengdi.environmentalprotectionint.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysNoticeEntity;

import java.util.Map;

/**
 * 系统公告
 *
 * @author tengdi
 * @email 
 * @date 2019-03-07 11:01:21
 */
public interface SysNoticeService extends IService<SysNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

