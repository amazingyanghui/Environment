package com.tengdi.environmentalprotectionint.modules.cominfo.service.impl;

import com.tengdi.environmentalprotectionint.modules.cominfo.dao.CominfoBaseinfoDao;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.SysHangyedaimaEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoBaseinfoService;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.SysHangyedaimaService;
import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementAskrecordEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorPortinfoService;
import com.tengdi.core.utils.MapUtils;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDeptService;
import com.tengdi.userauthenuuid.modules.sys.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.Query;



@Service("cominfoBaseinfoService")
public class CominfoBaseinfoServiceImpl extends ServiceImpl<CominfoBaseinfoDao, CominfoBaseinfoEntity> implements CominfoBaseinfoService {
    @Autowired
    private OnlineMonitorPortinfoService onlineMonitorPortinfoService;

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysDeptService sysDeptService;
    @Autowired
    private SysHangyedaimaService sysHangyedaimaService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Integer limit = Integer.parseInt((String)params.get("limit"));
        Integer page = Integer.parseInt((String)params.get("page"));
        String pollutionSourceCategory = (String)params.get("pollutionSourceCategory");
        if(pollutionSourceCategory != null && !pollutionSourceCategory.equals("")){
            params.put("pollutionSourceCategory",pollutionSourceCategory.split("-"));
        }
        Query query = new Query(params);
        List<CominfoBaseinfoEntity> list = baseMapper.queryPage(query);
        for(CominfoBaseinfoEntity cominfoBaseinfo:list){
            if(cominfoBaseinfo.getIndustryids() != null && !cominfoBaseinfo.getIndustryids().equals("")){
                String industryidstemp=getIndustry(cominfoBaseinfo.getIndustryids());
                if(StringUtils.isNotBlank(industryidstemp)){
                    cominfoBaseinfo.setIndustry(industryidstemp);
                }
            }
        }
        List<CominfoBaseinfoEntity> queryList=new ArrayList<>();
        String monitorType=(String) query.get("monitorType");
        if(StringUtils.isNotBlank(monitorType)){
            Integer type= Integer.valueOf(monitorType);
            for (CominfoBaseinfoEntity entity:list){
                List<SelectEntity> entityList =onlineMonitorPortinfoService.list(entity.getPid());
                if(entityList!=null){
                    boolean flag=false;
                    for(SelectEntity selectEntity:entityList){
                        if(type.equals(selectEntity.getType())){
                            flag=true;
                        }
                    }
                    if(flag){
                        queryList.add(entity);
                    }
                }

            }
            list=queryList;
        }
        int count = baseMapper.count(params);
        return new PageUtils(list,count,limit,page);

    }

    @Override
    public String register(CominfoBaseinfoEntity cominfoBaseinfo){
        String username = cominfoBaseinfo.getUnifiedSocialCreditCode().substring(cominfoBaseinfo.getUnifiedSocialCreditCode().length()-12);
        cominfoBaseinfo.setPid(username);
        int i = baseMapper.register(cominfoBaseinfo);
//        String pid = cominfoBaseinfo.getPid();
//        SysDeptEntity sysDept = new SysDeptEntity();
//        sysDept.setDeptId(username);
//        sysDept.setParentId("0");
//        sysDept.setName(cominfoBaseinfo.getCompanyName());
//        sysDeptService.insert(sysDept);
//        SysUserEntity sysUser = new SysUserEntity();
//        List<String> roleIdList = new ArrayList<String>();
//        roleIdList.add("60d73880895149289bc2f634b6ba39cc");
//        sysUser.setRoleIdList(roleIdList);
//        sysUser.setUsername(username);
//        sysUser.setNickName(cominfoBaseinfo.getCompanyName());
//        String password = cominfoBaseinfo.getUnifiedSocialCreditCode().substring(cominfoBaseinfo.getUnifiedSocialCreditCode().length()-6);
//        sysUser.setPassword(Base64.encodeToString(password.getBytes()));
//        sysUser.setMobile(cominfoBaseinfo.getEnvironmentalProtectionPhone());
//        sysUser.setDeptId(username);
//        sysUserService.basesave(sysUser);
        return username;
    }

    @Override
    public List<CominfoBaseinfoEntity> verifyCode(String code) {
        return baseMapper.verifyCode(code);
    }

    /**
     * 注册验证企业名称判重
     */
    @Override
    public List<CominfoBaseinfoEntity> VerifyCompanyName(Map<String, Object> map) {
        return baseMapper.VerifyCompanyName(map);
    }
    /**
     *
     */
    @Override
    public List<CominfoBaseinfoEntity> VerifyUserName(String usernamecode) {
        return baseMapper.VerifyUserName(usernamecode);
    }

    @Override
    public List<SysUserEntity> verifyPhone(Map<String, Object> map) {
        return baseMapper.verifyPhone(map);
    }

    @Override
    public List<SysUserEntity> verifyPhoneByUser(Map<String, Object> map) {
        return baseMapper.verifyPhoneByUser(map);
    }

    @Override
    public List<SysUserEntity> verifyNameByUser(Map<String, Object> map) {
        return baseMapper.verifyNameByUser(map);
    }

    /**
     * 按条件查询企业坐标
     * @param params
     * @return
     */
    @Override
    public List<CominfoBaseinfoEntity> queryList(Map<String, Object> params){
        return baseMapper.queryList(params);
    }

    @Override
    public List<CominfoBaseinfoEntity> getDangerSourceList(Map<String, Object> params) {
        return baseMapper.getDangerSourceList(params);
    }

    @Override
    public List<CominfoBaseinfoEntity> getIsotopeSourceList(Map<String, Object> params) {
        return baseMapper.getIsotopeSourceList(params);
    }

    /**
     * 查询风险源坐标
     * @param params
     * @return
     */
    @Override
    public List<CominfoBaseinfoEntity> getRiskSourceList(Map<String, Object> params){
        return baseMapper.getRiskSourceList(params);
    }

    /**
     * 查询风险源坐标
     * @param params
     * @return
     */
    @Override
    public List<Map<String,Object>> totalCompanyLevel(Map<String, Object> params){
        return baseMapper.totalCompanyLevel(params);
    }
    /**
     * 风险源
     */
    @Override
    public PageUtils riskSourceSel(Map<String, Object> params) {
        int page =Integer.parseInt((String)params.get("page"));
        int limit =Integer.parseInt((String)params.get("limit"));
        List<String> arrayList=sysHangyedaimaService.getIndustryList(params);
        params.put("industryids",arrayList);
        Query query=new Query(params);
        List<CominfoBaseinfoEntity> list =baseMapper.riskSourceSel(query);
        for(CominfoBaseinfoEntity cominfoBaseinfo:list){
            if(cominfoBaseinfo.getIndustryids() != null && !cominfoBaseinfo.getIndustryids().equals("")){
                String industryidstemp=getIndustry(cominfoBaseinfo.getIndustryids());
                cominfoBaseinfo.setIndustry(industryidstemp);
            }
        }
        int totalCount =baseMapper.riskSourceSelsum(params);
        return new PageUtils(list,totalCount,limit,page);
    }

    /**
     *
     */
    @Override
    public List<CominfoBaseinfoEntity> likeCompanyName(Map<String, Object> params) {
        Query query=new Query(params);
        List<CominfoBaseinfoEntity> list =baseMapper.queryPage(query);
        return list;
    }

    @Override
    public List<CominfoBaseinfoEntity> queryName(Map<String, Object> params) {
        return baseMapper.riskSourceSel(params);
    }

    @Override
    public String getIndustry(String code) {
        String[] industryids = code.split(",");
        String industryidstemp = "";
        for(String industryid : industryids){
            List<SysHangyedaimaEntity> sysList=sysHangyedaimaService.selectByMap(new MapUtils().put("DaiMaZhi",industryid));
            if(sysList.size()>0){
                SysHangyedaimaEntity sysHangyedaima = sysList.get(0);
                if(sysHangyedaima != null){
                    industryidstemp += sysHangyedaima.getMingcheng() + ",";
                }
            }
        }
        if (industryidstemp.length() > 0 ){
            industryidstemp = industryidstemp.substring(0, industryidstemp.length() - 1);
        }
        return industryidstemp;
    }
    /**
     *列表(根据用户是企业还是管理员展示不同页面)
     */
    @Override
    public PageUtils listByUser(Map<String, Object> params) {
        int page =Integer.parseInt((String)params.get("page"));
        int limit =Integer.parseInt((String)params.get("limit"));
        Query query = new Query(params);
        List<CominfoBaseinfoEntity> list =baseMapper.listByUser(query);
        for(CominfoBaseinfoEntity cominfoBaseinfo:list){
            if(cominfoBaseinfo.getIndustryids() != null && !cominfoBaseinfo.getIndustryids().equals("")){
                String industryidstemp=getIndustry(cominfoBaseinfo.getIndustryids());
                if(StringUtils.isNotBlank(industryidstemp)){
                    cominfoBaseinfo.setIndustry(industryidstemp);
                }
            }
        }
        int totalCount =baseMapper.listByUserSum(params);
        return new PageUtils(list,totalCount,limit,page);
    }
}
