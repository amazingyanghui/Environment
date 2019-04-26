package com.tengdi.environmentalprotectionint.modules.penalty.dao;

import com.tengdi.environmentalprotectionint.modules.penalty.entity.AdministrativePenaltyInfoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 处罚情况
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-23 09:24:41
 */
public interface AdministrativePenaltyInfoDao extends BaseMapper<AdministrativePenaltyInfoEntity> {


    /**
     * 插入行政处罚
     * @param entity
     * @return
     */
    int insertData(AdministrativePenaltyInfoEntity entity);
    /**
     * 分页查询记录（多表联合）
     * @param map
     * @return
     */
    List<AdministrativePenaltyInfoEntity> queryList2(Map<String,Object> map);
    List<AdministrativePenaltyInfoEntity> queryName(Map<String,Object> map);

    List<AdministrativePenaltyInfoEntity> dataById(String cid);

    AdministrativePenaltyInfoEntity entityById(String pid);

    /**
     * 查询总记录数
     * @param map
     * @return
     */
    int count(Map<String,Object> map);

    /**
     * 查询年度处处罚总案件数
     */
    int totalcases(String year);

    /**
     * 查询年度处罚金额总数
     */
    List<AdministrativePenaltyInfoEntity> totalmoney(String year);

    /**
     * 查询每月处罚金额
     */
    List<AdministrativePenaltyInfoEntity> monthmoneryList(Map<String, Object> map );
    /**
     * 查询每月处罚案件总数
     */
    List<AdministrativePenaltyInfoEntity> monthcacesList(String year );
    /**
     * 查询公司处罚金额排行
     */
    List<AdministrativePenaltyInfoEntity> caseranking(String year );
    /**
     * 查询处罚案件总数排行
     */
    List<AdministrativePenaltyInfoEntity> moneryranking(Map<String, Object> map);
    /**
     * 类型总数统计查询
     */
    List<AdministrativePenaltyInfoEntity> typemonerycountstatic( Map<String, Object> map);

    /**
     * 其他类型总数统计
     */
    List<AdministrativePenaltyInfoEntity> othertypemonerycountstatic (String year);
    /**
     * 类型总数统计查询
     */
    List<AdministrativePenaltyInfoEntity> typecasecountstatic(String year );



}
