package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalManageEntity;

import java.util.List;

/**
 * 环境管理属性
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:29
 */
public interface CominfoEnvironmentalManageDao extends BaseMapper<CominfoEnvironmentalManageEntity> {
    CominfoEnvironmentalManageEntity dataById(String cid);
    /**
     * 全区污染源
     */
    int sourceCount();
    /**
     * 重点污染源个数
     */
    int keySourceCount();
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
    List<CominfoEnvironmentalManageEntity>  riskLevelStaticList ();

    /**
     * 企业规模及数量统计
     */
    List<CominfoEnvironmentalManageEntity> enterpriSecaleStaticList();

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
}
