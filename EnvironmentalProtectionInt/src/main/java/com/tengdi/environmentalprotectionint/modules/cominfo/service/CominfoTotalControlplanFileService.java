package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoTotalControlplanFileEntity;

import java.util.List;
import java.util.Map;

/**
 * 控制计划附件
 *
 * @author tengdi
 * @email 
 * @date 2018-12-04 18:08:41
 */
public interface CominfoTotalControlplanFileService extends IService<CominfoTotalControlplanFileEntity> {

    PageUtils queryPage(Map<String, Object> params);
    /**
     * 根据控制计划id查附件
     * @param aid
     * @return
     */
    List<CominfoTotalControlplanFileEntity> dataByFile(String aid);
}

