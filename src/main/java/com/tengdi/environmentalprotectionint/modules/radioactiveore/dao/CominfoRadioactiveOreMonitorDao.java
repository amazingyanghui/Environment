package com.tengdi.environmentalprotectionint.modules.radioactiveore.dao;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.radioactiveore.entity.CominfoRadioactiveOreMonitorEntity;

import java.util.List;
import java.util.Map;
/**
 * 放射性检测表（包含【废水】放射性检测、和【固体物料及废物】放射性检测）
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:25:58
 */
public interface CominfoRadioactiveOreMonitorDao extends BaseMapper<CominfoRadioactiveOreMonitorEntity> {
    List<Map<String,Object>> queryList(Map<String, Object> params);

    int queryListCount(Map<String, Object> params);
}
