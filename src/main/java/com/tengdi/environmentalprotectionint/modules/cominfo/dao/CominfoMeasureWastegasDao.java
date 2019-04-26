package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureWastegasEntity;

import java.util.List;
import java.util.Map;

/**
 * 废气治理设施
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:10
 */
public interface CominfoMeasureWastegasDao extends BaseMapper<CominfoMeasureWastegasEntity> {
    List<CominfoMeasureWastegasEntity> queryData(Map map);

    int countData(Map map);

    List<CominfoMeasureWastegasEntity> dataById(String cid);
}
