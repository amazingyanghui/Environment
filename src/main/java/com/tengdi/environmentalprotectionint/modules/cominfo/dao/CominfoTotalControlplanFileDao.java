package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoTotalControlplanFileEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 控制计划附件
 * 
 * @author tengdi
 * @email 
 * @date 2018-12-04 18:08:41
 */
public interface CominfoTotalControlplanFileDao extends BaseMapper<CominfoTotalControlplanFileEntity> {
    /**
     * 根据控制计划id查附件
     * @param aid
     * @return
     */
    List<CominfoTotalControlplanFileEntity> dataByFile(String aid);
}
