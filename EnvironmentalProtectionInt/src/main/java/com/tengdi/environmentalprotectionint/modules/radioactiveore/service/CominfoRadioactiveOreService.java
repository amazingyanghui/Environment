package com.tengdi.environmentalprotectionint.modules.radioactiveore.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.radioactiveore.entity.CominfoRadioactiveOreEntity;
import java.util.Map;

/**
 * 伴生放射性矿产企业含放射性固体物料及废物情况
 *
 * @author tengdi
 * @email 
 * @date 2019-03-12 14:52:38
 */
public interface CominfoRadioactiveOreService extends IService<CominfoRadioactiveOreEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryTableData(Map<String, Object> params);
}

