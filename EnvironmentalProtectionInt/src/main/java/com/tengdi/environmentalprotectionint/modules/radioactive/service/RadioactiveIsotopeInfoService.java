package com.tengdi.environmentalprotectionint.modules.radioactive.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.radioactive.entity.RadioactiveIsotopeInfoEntity;
import com.tengdi.core.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 放射性同位素
 *
 * @author tengdi
 * @email 
 * @date 2018-09-17 15:37:10
 */
public interface RadioactiveIsotopeInfoService extends IService<RadioactiveIsotopeInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<RadioactiveIsotopeInfoEntity> queryList(Map<String, Object> params);

    List<RadioactiveIsotopeInfoEntity> dataById(String cid);
    /**
     * 单位名查询
     */
    List<RadioactiveIsotopeInfoEntity> queryName(Map<String, Object> params);
}

