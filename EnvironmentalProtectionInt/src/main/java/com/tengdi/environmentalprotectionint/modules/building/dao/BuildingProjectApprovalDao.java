package com.tengdi.environmentalprotectionint.modules.building.dao;

import com.tengdi.environmentalprotectionint.modules.building.entity.BuildingProjectApprovalEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.SysHangyedaimaEntity;

import java.util.List;
import java.util.Map;

/**
 * 项目建设审批情况
 *
 * @author tengdi
 * @email
 * @date 2018-08-22 10:03:40
 */
public interface BuildingProjectApprovalDao extends BaseMapper<BuildingProjectApprovalEntity> {

    BuildingProjectApprovalEntity getBuildingInfo(String pid);

    //项目建设列表记录
    List<BuildingProjectApprovalEntity> queryData(Map<String, Object> params);
    List<BuildingProjectApprovalEntity> queryName(Map<String, Object> params);

    List<BuildingProjectApprovalEntity> dataById(String cid);

    //项目建设列表总数
    int queryCount(Map<String, Object> params);

    /**
     * 插入建设项目
     * @param entity
     * @return
     */
    int insertData(BuildingProjectApprovalEntity entity);
    /**
     * 建设项目-各月投资统计
     */
    List<Map<String, Number>> monthlyInvestmentStatistics(Map<String, Object> params);
    /**
     * 建设项目-本年投资总额与去年对比
     */
    List<Map<String, Number>> yearAndLastyearContrastByInvestment(Map<String, Object> params);
    /**
     * 建设项目-本年度各行业投资总额统计
     */
    List<Map<String, Object>> totalIndustryInvestment(String year);
    /**
     * 本年度审批项目、本年度项目建设投资、环保投资、与去年同期相比，项目建设投资总额增加
     */
    Map<String, Object> ProjectConstructionStatistics(Map<String, Object> params);
    /**
     * 获取所以项目建设数据
     */
    List<Map<String, Object>> industry(Map<String, Object> params);
    /**
     * 查出所有父级行业
     */
    List<SysHangyedaimaEntity> selParentIndustry();
    /**
     * 获取当父级目录的二级目录列表
     */
    List<SysHangyedaimaEntity>selSublevelIndustries(int key);
    List<SysHangyedaimaEntity> selAllHangYe();
}
