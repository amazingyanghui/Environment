package com.tengdi.environmentalprotectionint.modules.permit.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.environmentalprotectionint.modules.permit.entity.PollutantDischargePermitAndBaseInfoEntity;
import com.tengdi.environmentalprotectionint.modules.permit.entity.PollutantDischargePermitEntity;
import com.tengdi.core.utils.PageUtils;
import net.sf.json.JSONArray;


import java.util.List;
import java.util.Map;

/**
 * 排污许可证
 *
 * @author tengdi
 * @email 
 * @date 2018-09-10 15:38:35
 */
public interface PollutantDischargePermitService extends IService<PollutantDischargePermitEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<PollutantDischargePermitEntity> queryList(Map<String, Object> params);

    /**
     * 分页多条件查询
     * @param params
     * @return
     */
    PageUtils queryPageSql(Map<String, Object> params);
    List<PollutantDischargePermitEntity> queryName(Map<String, Object> params);

    List<PollutantDischargePermitEntity> dataById(String cid);

    List<PollutantDischargePermitEntity> getList(List<PollutantDischargePermitEntity> list);

    /**
     * 查询统计基础信息
     * @param year
     * @return
     */
    JSONArray basestaticcount(String year);

    /**
     *查询年度每月的证书统计
     */

    JSONArray monthstaticcount(String year);

    /**
     *查询年度各行业的证书统计
     */
    JSONArray industrystaticcount(String year);

    /**
     * 排污许可证列表
     * @param cid
     * @return
     */
    List<SelectEntity> list(String cid);

    /**
     * 环保税信息采集表
     * @param pid
     * @return
     */
    PollutantDischargePermitAndBaseInfoEntity getBaseInfoForEnvironment(String pid);

    /**
     * 环保税信息采集表
     * @param pid
     * @return
     */
    List<PollutantDischargePermitAndBaseInfoEntity> getPaiKouInfoForEnvironment(String pid);

    /**
     * 修改环保税信息采集表
     * @param entity
     * @return
     */
    void updateEnvironmentInfo(PollutantDischargePermitAndBaseInfoEntity entity);

    int updateForEnvironment(PollutantDischargePermitEntity entity);
}

