package com.tengdi.environmentalprotectionint.modules.sys.dao;

import com.tengdi.environmentalprotectionint.modules.sys.entity.SysFeedbackRecordEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 反馈记录
 * 
 * @author tengdi
 * @email 
 * @date 2018-11-13 10:15:09
 */
public interface SysFeedbackRecordDao extends BaseMapper<SysFeedbackRecordEntity> {
    List<SysFeedbackRecordEntity> queryList(Map map);

    int queryCount(Map map);
}
