package com.tengdi.environmentalprotectionint.modules.greentaxesinformation.service;


import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.greentaxesinformation.entity.SolidwasteInformationEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 固体废物基础信息采集
 *
 * @author tengdi
 * @email
 * @date 2019-03-04 11:14:18
 */
public interface SolidwasteInformationService extends IService<SolidwasteInformationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils getWasteAll(Map<String, Object> params);
}

