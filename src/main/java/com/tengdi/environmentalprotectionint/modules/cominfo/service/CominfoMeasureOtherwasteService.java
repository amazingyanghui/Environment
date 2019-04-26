package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureOtherwasteEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 其他治理设施
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:20
 */
public interface CominfoMeasureOtherwasteService extends IService<CominfoMeasureOtherwasteEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CominfoMeasureOtherwasteEntity> queryList(Map<String, Object> params);

    List<CominfoMeasureOtherwasteEntity> dataById(String cid);
}

