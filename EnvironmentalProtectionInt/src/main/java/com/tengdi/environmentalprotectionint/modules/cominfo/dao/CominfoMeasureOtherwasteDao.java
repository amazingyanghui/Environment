package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureOtherwasteEntity;

import java.util.List;
import java.util.Map;

/**
 * 其他治理设施
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:20
 */
public interface CominfoMeasureOtherwasteDao extends BaseMapper<CominfoMeasureOtherwasteEntity> {
	List<CominfoMeasureOtherwasteEntity> queryData(Map map);

	int countData(Map map);

	List<CominfoMeasureOtherwasteEntity> dataById(String cid);
}
