package com.tengdi.environmentalprotectionint.modules.cominfo.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 基本信息
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:40
 */
public interface CominfoBaseinfoDao extends BaseMapper<CominfoBaseinfoEntity> {

    /**
     * 注册新企业
     * @param cominfoBaseinfoEntity
     * @return
     */
    int register(CominfoBaseinfoEntity cominfoBaseinfoEntity);

    /**
     * 验证统一社会信用代码是否重复
     * @param code
     * @return
     */
    List<CominfoBaseinfoEntity> verifyCode(String code);
    /**
     * 注册验证企业名称判重
     */
    List<CominfoBaseinfoEntity> VerifyCompanyName(Map<String, Object> map);

    /**
     * 电话号码去重
     */
    List<SysUserEntity> verifyPhone(Map<String, Object> map);
    /**
     * 电话号码去重(从用户表)
     */
    List<SysUserEntity> verifyPhoneByUser(Map<String, Object> map);
    /**
     * 账号去重(从用户表)
     */
    List<SysUserEntity> verifyNameByUser(Map<String, Object> map);
    /**
     * 按条件查询企业坐标
     * @param params
     * @return
     */
    List<CominfoBaseinfoEntity> queryList(Map<String, Object> params);
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
     * 查询风险源坐标
     * @param params
     * @return
     */
    List<CominfoBaseinfoEntity> getRiskSourceList(Map<String, Object> params);

    /**
     * 查询涉危企业坐标
     * @param params
     * @return
     */
    List<CominfoBaseinfoEntity> getDangerSourceList(Map<String, Object> params);

    /**
     * 查询涉放射性企业坐标
     * @param params
     * @return
     */
    List<CominfoBaseinfoEntity> getIsotopeSourceList(Map<String, Object> params);

    /**
     * 企业监管级别统计
     * @param params
     * @return
     */
    List<Map<String,Object>> totalCompanyLevel(Map<String, Object> params);
    /**
     * 风险源
     */
    List<CominfoBaseinfoEntity>  riskSourceSel(Map<String, Object> params);
    /**
     * 风险源数目
     */
    Integer riskSourceSelsum(Map<String, Object> params);
    /**
     * 用户注册用户名校验查询
     */
    List<CominfoBaseinfoEntity> VerifyUserName(String code);
    /**
     * 列表(根据用户是企业还是管理员展示不同页面)
     */
    List<CominfoBaseinfoEntity> listByUser(Map<String,Object> map);
    /**
     * 列表(根据用户是企业还是管理员展示不同页面)
     * 查询总记录数
     * @param map
     * @return
     */
    int listByUserSum(Map<String,Object> map);
}
