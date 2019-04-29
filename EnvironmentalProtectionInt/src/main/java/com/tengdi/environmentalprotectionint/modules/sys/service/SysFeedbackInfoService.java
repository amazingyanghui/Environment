package com.tengdi.environmentalprotectionint.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysFeedbackInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 反馈主表
 *
 * @author tengdi
 * @email 
 * @date 2018-11-13 10:15:02
 */
public interface SysFeedbackInfoService extends IService<SysFeedbackInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    String insertData(SysFeedbackInfoEntity sysFeedbackInfoEntity);

    List<SysFeedbackInfoEntity> queryList(Map<String, Object> params);
}

