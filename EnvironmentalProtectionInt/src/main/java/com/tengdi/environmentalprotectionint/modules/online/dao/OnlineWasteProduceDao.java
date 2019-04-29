package com.tengdi.environmentalprotectionint.modules.online.dao;

import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineWasteProduceEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 固废产生与利用（危废产生与利用）
 * 
 * @author tengdi
 * @email 
 * @date 2003-07-16 01:03:26
 */
public interface OnlineWasteProduceDao extends BaseMapper<OnlineWasteProduceEntity> {
    /**
     * 列表信息
     */
    List<OnlineWasteProduceEntity> queryPage(Map<String, Object> query);
    /**
     * 列表信息总数
     */
    int queryPageCom(Map<String, Object> query);
	
}
