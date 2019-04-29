package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalAttributesEntity;

/**
 * 环境属性
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:34
 */
public interface CominfoEnvironmentalAttributesDao extends BaseMapper<CominfoEnvironmentalAttributesEntity> {
    CominfoEnvironmentalAttributesEntity dataById(String cid);
}
