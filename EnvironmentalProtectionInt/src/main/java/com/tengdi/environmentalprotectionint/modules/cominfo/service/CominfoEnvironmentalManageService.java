package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalManageEntity;
import com.tengdi.core.utils.PageUtils;
import net.sf.json.JSONArray;

import java.util.Map;

/**
 * 环境管理属性
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:29
 */
public interface CominfoEnvironmentalManageService extends IService<CominfoEnvironmentalManageEntity> {

    PageUtils queryPage(Map<String, Object> params);

    CominfoEnvironmentalManageEntity dataById(String cid);

    /**
     * 查询统计基础信息
     * @param
     * @return
     */
    JSONArray baseInfoStatic();

    /**
     * 污染源类别统计
     */
    JSONArray sourceCategoryStatic();

    /**
     * 风险等级企业统计
     */
    JSONArray riskLevelStatic();

    /**
     * 企业规模数量统计
     */
    JSONArray enterpriSecaleStatic();

    /**
     * 行业类别统计
     */
    JSONArray industryidStatic();

    int updateForEnvironment(CominfoEnvironmentalManageEntity environmentalManageEntity);
}

