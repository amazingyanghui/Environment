package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureSolidwasteEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 固废治理设施
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:15
 */
public interface CominfoMeasureSolidwasteService extends IService<CominfoMeasureSolidwasteEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CominfoMeasureSolidwasteEntity> queryList(Map<String, Object> params);

    List<CominfoMeasureSolidwasteEntity> dataById(String cid);
}

