package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureWastewaterEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 废水治理设施
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:05
 */
public interface CominfoMeasureWastewaterService extends IService<CominfoMeasureWastewaterEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CominfoMeasureWastewaterEntity> queryList(Map<String, Object> params);

    List<CominfoMeasureWastewaterEntity> getList(List<CominfoMeasureWastewaterEntity> list);

    String getIndustry(String code);

    List<CominfoMeasureWastewaterEntity> dataById(String cid);
}

