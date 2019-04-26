package com.tengdi.environmentalprotectionint.modules.online.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineWasteProduceEntity;
import com.tengdi.core.utils.PageUtils;
import java.util.Map;

/**
 * 固废产生与利用（危废产生与利用）
 *
 * @author tengdi
 * @email 
 * @date 2003-07-16 01:03:26
 */
public interface OnlineWasteProduceService extends IService<OnlineWasteProduceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

