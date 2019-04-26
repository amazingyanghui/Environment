package com.tengdi.environmentalprotectionint.modules.radioactiveore.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.radioactiveore.entity.CominfoRadioactiveOreMonitorEntity;
import java.util.Map;

/**
 * 放射性检测表（包含【废水】放射性检测、和【固体物料及废物】放射性检测）
 *
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:25:58
 */
public interface CominfoRadioactiveOreMonitorService extends IService<CominfoRadioactiveOreMonitorEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryTableData(Map<String, Object> params);
}

