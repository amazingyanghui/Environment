package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureWastegasEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 废气治理设施
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:10
 */
public interface CominfoMeasureWastegasService extends IService<CominfoMeasureWastegasEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CominfoMeasureWastegasEntity> queryList(Map<String, Object> params);

    List<CominfoMeasureWastegasEntity> dataById(String cid);
}

