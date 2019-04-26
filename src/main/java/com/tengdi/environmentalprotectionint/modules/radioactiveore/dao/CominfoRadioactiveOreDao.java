package com.tengdi.environmentalprotectionint.modules.radioactiveore.dao;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.radioactiveore.entity.CominfoRadioactiveOreEntity;
import java.util.List;
import java.util.Map;
/**
 * 伴生放射性矿产企业含放射性固体物料及废物情况
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-12 14:52:38
 */
public interface CominfoRadioactiveOreDao extends BaseMapper<CominfoRadioactiveOreEntity> {
    List<Map<String,Object>> queryList(Map<String, Object> params);

    int queryListCount(Map<String, Object> params);
}
