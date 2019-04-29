package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalManageEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Map;

/**
 * 环境管理属性
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:29
 */
public interface CominfoStatisticsService extends IService<CominfoEnvironmentalManageEntity> {

    CominfoEnvironmentalManageEntity dataById(String cid);


    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询统计基础信息
     * @param
     * @return
     */
    JSONArray baseInfoStatic();

    /**
     * 企业规模数量统计
     */
    JSONArray enterpriScaleStatic();

    /**
     * 企业区域数量统计
     */
    JSONArray enterpriAreaStatic();


    /**
     * 执法统计,首页统计图
     * @param params 年和月
     * @return
     */
    JSONObject lawEnforceStatic(Map<String,Object> params);


    /**
     * 行业类别统计
     */
    JSONArray industryidStatic();

    String getIndustry(String code);








    int updateForEnvironment(CominfoEnvironmentalManageEntity environmentalManageEntity);
}

