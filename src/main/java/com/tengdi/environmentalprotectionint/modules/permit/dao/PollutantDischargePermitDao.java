package com.tengdi.environmentalprotectionint.modules.permit.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.permit.entity.PollutantDischargePermitAndBaseInfoEntity;
import com.tengdi.environmentalprotectionint.modules.permit.entity.PollutantDischargePermitEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 排污许可证
 * 
 * @author tengdi
 * @email 
 * @date 2018-09-10 15:38:35
 */
@Mapper
public interface PollutantDischargePermitDao extends BaseMapper<PollutantDischargePermitEntity> {

    /**
     * 分页查询记录（多表联合）
     * @param map
     * @return
     */
    List<PollutantDischargePermitEntity> queryList3(Map<String,Object> map);
    List<PollutantDischargePermitEntity> queryName(Map<String,Object> map);

    List<PollutantDischargePermitEntity> dataById(String cid);
    /**
     * 查询总记录数
     * @param map
     * @return
     */
    int count(Map<String,Object> map);

    /**
     * 查询年度证书发放个数
     */
    int curyeartotalpermits(String year);

    /**
     * 查询本年度正式证书发放个数
     */
    int formal (String year);
    /**
     * 查询本年度临时证书发放个数
     */
    int provisional  (String year);
    /**
     * 查询上一年度证书个数
     */
    int lastyeartotalpermit(String year);
    /**
     * 查询累计证书发放个数
     */
    int totalpermit(String year);

    /**
     * 每月证书统计
     */
    List<PollutantDischargePermitEntity>  monthpermitList(String year) ;

    /**
     *各行业证书统计
     */
    List<PollutantDischargePermitEntity> industrypermitList(String year);

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

    int updateForEnvironment(PollutantDischargePermitEntity entity);
}
