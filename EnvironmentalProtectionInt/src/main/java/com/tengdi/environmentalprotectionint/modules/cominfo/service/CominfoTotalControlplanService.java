package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoTotalControlplanEntity;

import java.util.List;
import java.util.Map;

/**
 * 企业总量控制计划
 *
 * @author tengdi
 * @email 
 * @date 2018-12-03 17:54:50
 */
public interface CominfoTotalControlplanService extends IService<CominfoTotalControlplanEntity> {

    PageUtils queryPage(Map<String, Object> params);

    CominfoTotalControlplanEntity entityById(String pid);

    String insertData(CominfoTotalControlplanEntity entity);

    List<CominfoTotalControlplanEntity> queryList(Map<String, Object> params);
}

