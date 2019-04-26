package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoAttachmentEntity;

import java.util.Map;

/**
 * 污染源（企业）附件
 *
 * @author tengdi
 * @email 
 * @date 2018-08-24 15:29:14
 */
public interface CominfoBaseinfoAttachmentService extends IService<CominfoBaseinfoAttachmentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

