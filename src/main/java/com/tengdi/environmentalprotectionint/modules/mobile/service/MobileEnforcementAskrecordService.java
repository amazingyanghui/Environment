package com.tengdi.environmentalprotectionint.modules.mobile.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementAskrecordEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 案件调查询问笔录
 *
 * @author tengdi
 * @email 
 * @date 2003-07-25 23:56:39
 */
public interface MobileEnforcementAskrecordService extends IService<MobileEnforcementAskrecordEntity> {
    /**
     * 列表
     */
    PageUtils queryPage(Map<String, Object> params);
    /**
     * 输入域发生变化动态查询数据展示下拉
     */
    List<MobileEnforcementAskrecordEntity> queryName(Map<String, Object> params);

    List<MobileEnforcementAskrecordEntity> dataById(String cid) ;

    MobileEnforcementAskrecordEntity entityById(String cid);

    List<MobileEnforcementAskrecordEntity> queryList(Map<String, Object> params);
}

