package com.tengdi.environmentalprotectionint.modules.greentaxesinformation.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.core.utils.Query;
import com.tengdi.environmentalprotectionint.modules.greentaxesinformation.entity.SolidwasteInformationEntity;
import com.tengdi.environmentalprotectionint.modules.greentaxesinformation.entity.SysWasteEntity;

import java.util.List;
import java.util.Map;

/**
 * 固体废物基础信息采集
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-04 11:14:18
 */
public interface SolidwasteInformationDao extends BaseMapper<SolidwasteInformationEntity> {

    List<SysWasteEntity> queryList(Query query);

    int count(Map<String,Object> params);
}
