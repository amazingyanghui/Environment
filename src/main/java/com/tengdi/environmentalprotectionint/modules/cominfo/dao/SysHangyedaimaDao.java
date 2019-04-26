package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.SysHangyedaimaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author tengdi
 * @email 
 * @date 2018-09-11 14:56:09
 */
public interface SysHangyedaimaDao extends BaseMapper<SysHangyedaimaEntity> {
    List<SysHangyedaimaEntity> queryList(Map map);

    List<SysHangyedaimaEntity> dataByCode(String code);
}
