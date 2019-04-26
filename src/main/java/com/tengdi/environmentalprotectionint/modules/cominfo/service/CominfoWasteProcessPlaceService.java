package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.QueryCriterias;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoWasteProcessPlaceEntity;
import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;

import java.util.List;
import java.util.Map;

/**
 * (固废,危险)废物处理场所
 *
 * @author tengdi
 * @email 
 * @date 2019-03-07 16:51:37
 */
public interface CominfoWasteProcessPlaceService extends IService<CominfoWasteProcessPlaceEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CominfoWasteProcessPlaceEntity> queryList(Map<String, Object> params);

    PageUtils queryTableData(QueryCriterias criterias);

    /**
     * 废物处理场所列表
     * @param cid
     * @return
     */
    List<SelectEntity> list(String wasteCategoryType,String cid);

}

