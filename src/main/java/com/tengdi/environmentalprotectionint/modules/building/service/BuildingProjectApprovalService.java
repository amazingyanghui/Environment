package com.tengdi.environmentalprotectionint.modules.building.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.SysHangyedaimaEntity;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.building.entity.BuildingProjectApprovalEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * 项目建设审批情况
 *
 * @author tengdi
 * @email 
 * @date 2018-08-22 10:03:40
 */
public interface BuildingProjectApprovalService extends IService<BuildingProjectApprovalEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<BuildingProjectApprovalEntity> queryList(Map<String, Object> params);

    List<BuildingProjectApprovalEntity> queryName(Map<String, Object> params);

    List<BuildingProjectApprovalEntity> dataById(String cid);

    BuildingProjectApprovalEntity getBuildingInfo(String pid);

    /**
     * 插入建设项目
     * @param entity
     * @return
     */
    String insertData(BuildingProjectApprovalEntity entity);
    /**
     * 建设项目-各月投资统计
     */
    Map<String,Object>   monthlyInvestmentStatistics(String year);
    /**
     *建设项目-本年投资总额与去年对比
     */
    int []  yearAndLastyearContrastByInvestment(String year);
    /**
     * 建设项目-本年度各行业投资总额统计
     */
    Map<String,Object> totalIndustryInvestment(String year);
    /**
     * 建设项目-本年度行业投资占比
     */
    JSONArray industryInvestmentProportion(String year);
    /**
     * 本年度审批项目、本年度项目建设投资、环保投资、与去年同期相比，项目建设投资总额增加
     */
    Map<String,Object>ProjectConstructionStatistics( String year);
    /**
     * 递归循环下级目录
     */
    int industryInvestmentProportion2(JSONObject entity, List<Map<String, Object>> list);
    /**
     * 递归行业信息
     */
    JSONArray getJsonArray(List<SysHangyedaimaEntity> codeList, int hangBiaoShi);
}

