package com.tengdi.environmentalprotectionint.modules.penalty.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.environmentalprotectionint.modules.penalty.entity.AdministrativePenaltyInfoEntity;
import net.sf.json.JSONArray;

import java.util.List;
import java.util.Map;

/**
 * 处罚情况
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 09:24:41
 */
public interface AdministrativePenaltyInfoService extends IService<AdministrativePenaltyInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 插入行政处罚
     * @param entity
     * @return
     */
    String insertData(AdministrativePenaltyInfoEntity entity);

    List<AdministrativePenaltyInfoEntity> queryName(Map<String, Object> params);

    List<AdministrativePenaltyInfoEntity> dataById(String cid);

    AdministrativePenaltyInfoEntity entityById(String pid);

    PageUtils queryPageSql(Map<String, Object> params);

    List<AdministrativePenaltyInfoEntity> queryList(Map<String, Object> params);

    /**
     * 统计查询
     * @param year 年度
     * @return
     */

    JSONArray staticcount (String year ) ;

    /**
     * 月份金额与案件数量统计
     */

    JSONArray monthStatic(String year,String type);

    /**
     * 年度金额与案件查询
     */
    JSONArray yearStatic(String year,String type);

    /**
     * 类型总数统计
     */
    JSONArray typeStatic(String year,String type);

    /**
     * 公司排行榜
     */
    JSONArray companyRankStatic(String year,String type);
}

