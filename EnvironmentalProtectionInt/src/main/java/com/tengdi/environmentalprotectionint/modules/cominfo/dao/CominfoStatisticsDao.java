package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalManageEntity;

import java.util.List;
import java.util.Map;

/**
 * 环境管理属性
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:29
 */
public interface CominfoStatisticsDao extends BaseMapper<CominfoEnvironmentalManageEntity> {
    CominfoEnvironmentalManageEntity dataById(String cid);

    /**
     * 分页查询记录（多表联合）
     * @param map
     * @return
     */
    List<CominfoBaseinfoEntity> queryPage(Map<String,Object> map);

    /**
     * 查询总记录数
     * @param map
     * @return
     */
    int count(Map<String,Object> map);
    /**
     * 企业总数
     */
    int sourceCount();
    /**
     * 重点污染源个数
     *  where cominfo_environmental_manage.key_source ='1'
     */
    int keySourceCount();

    /**
     * 企业规模及数量统计
     */
    List<CominfoEnvironmentalManageEntity> enterpriScaleStaticList();
    /**
     * 企业区域及数量统计
     */
    List<Map<String,Object>> enterpriAreaStaticList();

    /**
     * 执法统计 按年月及区域
     * @param params
     * @return
     */
    List<Map<String,Object>> lawEnforceStatic(Map<String,Object> params);














    /**
     * 行业类型企业数量统计
     */
    List<CominfoEnvironmentalManageEntity> industryidStaticList();
    /**
     * 查询第一级企业类型分布
     */
    List<CominfoEnvironmentalManageEntity> firstOrder();
    /**
     * 查询第二级企业类型分布
     */
    List<CominfoEnvironmentalManageEntity> secondOrder();
    /**
     * 查询第三级企业类型分布
     */
    List<CominfoEnvironmentalManageEntity> thirdOrder();
    /**
     * 查询第四级企业类型分布
     */
    List<CominfoEnvironmentalManageEntity> fouthOrder();

    int updateForEnvironment(CominfoEnvironmentalManageEntity environmentalManageEntity);

    /**
     * 统计废水源
     */
    int waterSourceCount();
    /**
     * 统计废气源
     */
    int airSourceCount();
    /**
     * 统计VOCs产生源
     */
    int VocSourceCount();
    /**
     * 统计风险源
     */
    int riskSourceCount();

    /**
     *污染源类别统计
     */
    List<CominfoEnvironmentalManageEntity> sourceCategoryStaticList();

    /**
     * 风险等级统计
     */
    List<CominfoEnvironmentalManageEntity>  riskLevelStaticList();
}
