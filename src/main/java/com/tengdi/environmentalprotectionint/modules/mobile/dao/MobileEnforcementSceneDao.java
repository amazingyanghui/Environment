package com.tengdi.environmentalprotectionint.modules.mobile.dao;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementSceneEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 移动执法现场执法
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 11:57:35
 */
public interface MobileEnforcementSceneDao extends BaseMapper<MobileEnforcementSceneEntity> {
    /**
     * 移动执法记录列表信息
     */
    List<MobileEnforcementSceneEntity> mobilelist(Map<String, Object> params) ;

    List<MobileEnforcementSceneEntity> queryName(Map<String, Object> params) ;

    List<MobileEnforcementSceneEntity> dataById(String cid) ;

    int insertData(MobileEnforcementSceneEntity entity);

    MobileEnforcementSceneEntity entityById(String pid);
    /**
     *移动执法记录列表信息总数
     */
    Integer  mobilelistsum (Map<String, Object> params);
    /**
     * 移动执法统计：该年累计值法人次、执法人员总数、发现问题总数、相比去年执法总数增加百分比
     */
    List<Map<String,Object>>  comprehensiveStatistical(Map<String, Object> params);
    /**
     * 移动执法图表统计:月执法统计
     */
    List<Map<String,Object>>  statistical(Map<String, Object> params);
    /**
     * 移动执法统计：去年执法次数与今年对比
     */
    List<Map<String, Object>>   statisticalLastyearAndThisyear(Map<String, Object> params);
    /**
     * 移动执法统计：检查结果
     */
    List<Map<String, Object>>  checkTheResultStatistical(Map<String, Object> params);
    /**
     * 移动执法统计：问题类型
     */
    List<Map<String, Object>>  statisticalProblemType(Map<String, Object> params);
    /**
     * 移动执法统计：本年度执法类型统计
     */
    List<Map<String, Object>>  lawEnforcementTypeStatistical(Map<String, Object> params);
    /**
     * 企业统计-企业所属行业类型统计
     */
    List<CominfoBaseinfoEntity> selAllCominfoBaseinfo();
    /**
     * 环保执法监察
     */
    Map<String,Object> environmentalLawEnforcementMonitoring(Map<String, Object> params);

    /**
     * 移动执法页头弹框列表查询接口
     */
    List<MobileEnforcementSceneEntity> playListBox(Map<String, Object> params);
    /**
     *移动执法页头弹框列表查询接口信息总数
     */
    Integer  playListBoxsum (Map<String, Object> params);
}
