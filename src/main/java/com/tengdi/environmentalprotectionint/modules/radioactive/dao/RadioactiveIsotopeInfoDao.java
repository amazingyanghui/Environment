package com.tengdi.environmentalprotectionint.modules.radioactive.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.radioactive.entity.RadioactiveIsotopeInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 放射性同位素
 * 
 * @author tengdi
 * @email 
 * @date 2018-09-17 15:37:10
 */
public interface RadioactiveIsotopeInfoDao extends BaseMapper<RadioactiveIsotopeInfoEntity> {
    /**
     * 列表查询
     */
    List<RadioactiveIsotopeInfoEntity> queryPage(Map<String, Object> params);

    List<RadioactiveIsotopeInfoEntity> dataById(String cid);
    /**
     * 单位名查询
     */
    List<RadioactiveIsotopeInfoEntity> queryName(Map<String, Object> params);
    /**
     * 列表查询总数
     */
    Integer queryPagesum(Map<String, Object> params);
	
}
