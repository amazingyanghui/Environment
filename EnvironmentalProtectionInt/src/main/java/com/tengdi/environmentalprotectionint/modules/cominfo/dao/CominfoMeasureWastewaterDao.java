package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureWastewaterEntity;

import java.util.List;
import java.util.Map;

/**
 * 废水治理设施
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:05
 */
public interface CominfoMeasureWastewaterDao extends BaseMapper<CominfoMeasureWastewaterEntity> {
    List<CominfoMeasureWastewaterEntity> queryData(Map map);

    int countData(Map map);

    List<CominfoMeasureWastewaterEntity> dataById(String cid);
}
