package com.tengdi.environmentalprotectionint.modules.cominfo.service;

import com.baomidou.mybatisplus.service.IService;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.core.utils.PageUtils;
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
public interface CominfoBaseinfoService extends IService<CominfoBaseinfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 按条件查询企业坐标
     * @param params
     * @return
     */
    List<CominfoBaseinfoEntity> queryList(Map<String, Object> params);

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
     * 查询风险源坐标
     * @param params
     * @return
     */
    List<CominfoBaseinfoEntity> getRiskSourceList(Map<String, Object> params);

    /**
     * 企业监管级别统计
     * @param params
     * @return
     */
    List<Map<String,Object>> totalCompanyLevel(Map<String, Object> params);

    /**
     * 注册新企业
     * @param cominfoBaseinfoEntity
     * @return
     */
    String register(CominfoBaseinfoEntity cominfoBaseinfoEntity);

    /**
     * 验证统一社会信用代码是否重复
     * @param code
     * @return
     */
    List<CominfoBaseinfoEntity> verifyCode(String code);
    /**
     *注册验证企业名称判重
     */
    List<CominfoBaseinfoEntity> VerifyCompanyName(Map<String, Object> map);
    /**
     * 企业注册用户名校验
     * @param usernamecode
     * @return
     */
    List<CominfoBaseinfoEntity> VerifyUserName(String usernamecode);

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
     * 风险源
     */
    PageUtils riskSourceSel(Map<String, Object> params);

    /**
     *模糊查询公司名称
     */
     List <CominfoBaseinfoEntity>  likeCompanyName(Map<String, Object> map);

    List <CominfoBaseinfoEntity>  queryName(Map<String, Object> params);

     String getIndustry(String code);
    /**
     * 列表(根据用户是企业还是管理员展示不同页面)
     */
    PageUtils listByUser(Map<String, Object> params);
}

