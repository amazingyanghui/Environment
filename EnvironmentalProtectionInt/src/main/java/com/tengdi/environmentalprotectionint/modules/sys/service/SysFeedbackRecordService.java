package com.tengdi.environmentalprotectionint.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysFeedbackRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 反馈记录
 *
 * @author tengdi
 * @email 
 * @date 2018-11-13 10:15:09
 */
public interface SysFeedbackRecordService extends IService<SysFeedbackRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SysFeedbackRecordEntity> queryList(Map<String, Object> params);
}

