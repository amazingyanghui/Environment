package com.tengdi.environmentalprotectionint.modules.greentax.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteMeasuresEntity;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPortinfoEntity;

import java.util.List;
import java.util.Map;
/**
 * 固体废物基础信息采集-污染防治措施表
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 10:20:29
 */
public interface EpSolidWasteMeasuresService extends IService<EpSolidWasteMeasuresEntity> {

    PageUtils queryPage(Map<String, Object> params);

//    PageUtils queryTableData(QueryCriterias criterias);
    //获取固废下拉选项
    List<EpSolidWasteMeasuresEntity> getSolidWaste(String cid);
}

