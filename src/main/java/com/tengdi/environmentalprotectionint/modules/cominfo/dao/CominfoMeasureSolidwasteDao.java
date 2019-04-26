package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureSolidwasteEntity;

import java.util.List;
import java.util.Map;

/**
 * 固废治理设施
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:15
 */
public interface CominfoMeasureSolidwasteDao extends BaseMapper<CominfoMeasureSolidwasteEntity> {
    List<CominfoMeasureSolidwasteEntity> queryData(Map map);

    int countData(Map map);

    List<CominfoMeasureSolidwasteEntity> dataById(String cid);
}
