package com.tengdi.environmentalprotectionint.modules.mobile.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementAskrecordEntity;
import java.util.List;
import java.util.Map;

/**
 * 案件调查询问笔录
 * 
 * @author tengdi
 * @email 
 * @date 2003-07-25 23:56:39
 */
public interface MobileEnforcementAskrecordDao extends BaseMapper<MobileEnforcementAskrecordEntity> {
    /**
     * 列表信息
     */
    List<MobileEnforcementAskrecordEntity> queryPage(Map<String, Object> params) ;
    /**
     *列表信息总数
     */
    Integer  queryPageSum (Map<String, Object> params);

    List<MobileEnforcementAskrecordEntity> dataById(String cid) ;

    MobileEnforcementAskrecordEntity entityById(String pid);

    List<MobileEnforcementAskrecordEntity> queryList(Map<String, Object> params) ;
	
}
