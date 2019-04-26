package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoBaseinfoService;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.SysHangyedaimaService;
import com.tengdi.core.utils.*;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;

import java.util.*;

import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.auth.shiro.jwt.UserUtils;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.CityEntity;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysConfigService;
import com.tengdi.userauthenuuid.modules.sys.service.SysDeptService;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import com.tengdi.userauthenuuid.modules.sys.service.SysUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

/**
 * 基本信息
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:40
 */
@RestController
@RequestMapping("market/cominfobaseinfo")
@Api(tags="基本信息")
public class CominfoBaseinfoController extends BaseController{
    @Autowired
    private CominfoBaseinfoService cominfoBaseinfoService;
    @Autowired
    private SysConfigService sysConfigService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysDeptService sysDeptService;
    @Autowired
    private SysDictService sysDictService;
    @Autowired
    private SysHangyedaimaService sysHangyedaimaService;
    //管理员用户
    public static final int  GUANLIYUAN_ROLE = 1;
    // 企业用户
    public static final int QIYE_ROLE = 2;
    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoBaseinfoService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 根据公司id获取公司基本信息(特殊)
     */
    @GetMapping("/{pid}")
    @ApiOperation("根据公司id获取公司基本信息(特殊)")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "pid", value = "公司id", required = false), })
    public R info(@PathVariable("pid") String pid){
        CominfoBaseinfoEntity cominfoBaseinfo = cominfoBaseinfoService.selectById(pid);
        if(cominfoBaseinfo!=null){
            if(cominfoBaseinfo.getPollutionSourceCategory() != null && !cominfoBaseinfo.getPollutionSourceCategory().equals("")){
                String value = sysDictService.getDictValueByType("pollution_source_category_type",Integer.parseInt(cominfoBaseinfo.getPollutionSourceCategory()));
                if(value != null ){
                    cominfoBaseinfo.setPollutionSourceCategoryText(value);
                }
            }
            if(cominfoBaseinfo.getIndustryids() != null && !cominfoBaseinfo.getIndustryids().equals("")){
                String industryidstemp=cominfoBaseinfoService.getIndustry(cominfoBaseinfo.getIndustryids());
                if(StringUtils.isNotBlank(industryidstemp)){
                    cominfoBaseinfo.setIndustry(industryidstemp);
                }
            }
            if(cominfoBaseinfo.getPollutionSourceCategory()!=null){
                List<SysDictEntity> pollutionSourceCategoryList=sysDictService.selectByMap(new MapUtils().put("`key`", cominfoBaseinfo.getPollutionSourceCategory()).put("type","pollution_source_category_type"));
                if(pollutionSourceCategoryList.size()>0){
                    cominfoBaseinfo.setPollutionSourceCategoryText(pollutionSourceCategoryList.get(0).getValue());
                }
            }
            if(cominfoBaseinfo.getSupervise()!=null){
                List<SysDictEntity> superviseList=sysDictService.selectByMap(new MapUtils().put("`key`", cominfoBaseinfo.getSupervise()).put("type","boolean_type"));
                if(superviseList.size()>0){
                    cominfoBaseinfo.setSuperviseName(superviseList.get(0).getValue());
                }
            }
            if(cominfoBaseinfo.getEcologicArea()!=null){
                List<SysDictEntity> ecologicAreaList=sysDictService.selectByMap(new MapUtils().put("`key`", cominfoBaseinfo.getEcologicArea()).put("type","boolean_type"));
                if(ecologicAreaList.size()>0){
                    cominfoBaseinfo.setEcologicAreaName(ecologicAreaList.get(0).getValue());
                }
            }
            if(cominfoBaseinfo.getTalk()!=null){
                List<SysDictEntity> talkList=sysDictService.selectByMap(new MapUtils().put("`key`", cominfoBaseinfo.getTalk()).put("type","boolean_type"));
                if(talkList.size()>0){
                    cominfoBaseinfo.setTalkName(talkList.get(0).getValue());
                }
            }
            if(cominfoBaseinfo.getAffiliation()!=null){
                List<SysDictEntity> affiliationList=sysDictService.selectByMap(new MapUtils().put("`key`", cominfoBaseinfo.getAffiliation()).put("type","affiliation_type"));
                if(affiliationList.size()>0){
                    cominfoBaseinfo.setAffiliationName(affiliationList.get(0).getValue());
                }
            }
            if(cominfoBaseinfo.getRegistrationType()!=null){
                List<SysDictEntity> registrationTypeList=sysDictService.selectByMap(new MapUtils().put("`key`", cominfoBaseinfo.getRegistrationType()).put("type","registration_type_type"));
                if(registrationTypeList.size()>0){
                    cominfoBaseinfo.setRegistrationTypeName(registrationTypeList.get(0).getValue());
                }
            }
            if(cominfoBaseinfo.getEnterpriseScale()!=null){
                List<SysDictEntity> enterpriseScaleList=sysDictService.selectByMap(new MapUtils().put("`key`", cominfoBaseinfo.getEnterpriseScale()).put("type","enterprise_scale_type"));
                if(enterpriseScaleList.size()>0){
                    cominfoBaseinfo.setEnterpriseScaleName(enterpriseScaleList.get(0).getValue());
                }
            }
            if(cominfoBaseinfo.getProductionState()!=null){
                List<SysDictEntity> productionStateList=sysDictService.selectByMap(new MapUtils().put("`key`", cominfoBaseinfo.getProductionState()).put("type","production_state_type"));
                if(productionStateList.size()>0){
                    cominfoBaseinfo.setProductionStateName(productionStateList.get(0).getValue());
                }
            }
            //
            if(cominfoBaseinfo.getQuotedCompany()!=null){
                List<SysDictEntity> quotedCompanyList=sysDictService.selectByMap(new MapUtils().put("`key`", cominfoBaseinfo.getQuotedCompany()).put("type","boolean_type"));
                if(quotedCompanyList.size()>0){
                    cominfoBaseinfo.setQuotedCompany(quotedCompanyList.get(0).getValue());
                }
            }
            if(cominfoBaseinfo.getIsSubsidiaryCompany()!=null){
                List<SysDictEntity> issubsidiarycompanyList = sysDictService.selectByMap(new MapUtils().put("`key`", cominfoBaseinfo.getIsSubsidiaryCompany()).put("type","boolean_type"));
                if(issubsidiarycompanyList.size()>0){
                    cominfoBaseinfo.setIsSubsidiaryCompany(issubsidiarycompanyList.get(0).getValue());
                }
            }
        }
        return R.ok().put("cominfoBaseinfo", cominfoBaseinfo);
    }

    /**
     * 保存企业基本信息
     */
    @PostMapping
    @ApiOperation("保存企业基本信息")
    @Transactional(rollbackFor = Exception.class)
    @SysLog(value = "保存企业基本信息")
    public R save(@RequestBody CominfoBaseinfoEntity cominfoBaseinfo){
        ValidatorUtils.validateEntity(cominfoBaseinfo, AddGroup.class);
        cominfoBaseinfo.setCreatedate(DateUtils.getStringDate());
        cominfoBaseinfo.setUpdatedate(DateUtils.getStringDate());
        String pid = cominfoBaseinfoService.register(cominfoBaseinfo);
        cominfoBaseinfo.setPid(pid);
        cominfoBaseinfoService.updateById(cominfoBaseinfo);
        return R.ok();
    }

    /**
     * 验证统一社会信用代码是否重复
     */
    @GetMapping("/verifySocialCreditCode/{code}")
    @ApiOperation("验证统一社会信用代码是否重复")
    public String verifyCode(@PathVariable("code") String code){
        List<CominfoBaseinfoEntity> list = cominfoBaseinfoService.verifyCode(code);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }
    /**
     * 注册验证企业名称判重
     */
    @PostMapping("/VerifyCompanyName")
    @ApiOperation("注册验证企业名称判重")
    public String VerifyCompanyName(@RequestBody CominfoBaseinfoEntity cominfoBaseinfoEntity){

        Map<String, Object> map = new HashMap<String, Object>();
        String companyName ="" ,unifiedSocialCreditCode="", environmentalProtectionPhone="";

        if(cominfoBaseinfoEntity.getCompanyName()!=null){
            companyName = cominfoBaseinfoEntity.getCompanyName();
        }
        if(cominfoBaseinfoEntity.getUnifiedSocialCreditCode()!=null){
            unifiedSocialCreditCode = cominfoBaseinfoEntity.getUnifiedSocialCreditCode();
        }
        if(cominfoBaseinfoEntity.getEnvironmentalProtectionPhone()!=null){
            environmentalProtectionPhone = cominfoBaseinfoEntity.getEnvironmentalProtectionPhone();
        }

        if(companyName!=""){
            map.put("companyName",companyName);
        }
        if(unifiedSocialCreditCode!=""){
            map.put("unifiedSocialCreditCode",unifiedSocialCreditCode);
        }
        if(environmentalProtectionPhone!=""){
            map.put("environmentalProtectionPhone",environmentalProtectionPhone);
        }

       List<CominfoBaseinfoEntity> list = cominfoBaseinfoService.VerifyCompanyName(map);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }
    /**

     * 验证企业注册用户名重复问题
     */
    @GetMapping("/VerifyUserName/{usernamecode}")
    @ApiOperation("验证企业注册用户名重复问题")
    public String VerifyUserName(@PathVariable("usernamecode") String usernamecode){
        List<CominfoBaseinfoEntity> list = cominfoBaseinfoService.VerifyUserName(usernamecode);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 用户管理:电话号码去重；账号去重
     */
    @GetMapping("/verifyUser")
    @ApiOperation("用户管理:电话号码去重；账号去重")
    public R verifyUser(@RequestParam Map<String, Object> params){
        String type=(String)params.get("type");
        String differType= (String) params.get("differType");
        String phone=(String)params.get("phone");
        String pid=(String)params.get("pid");
        String username=(String)params.get("username");
        boolean flag=false;
        boolean status=false;
        if(differType.equals("1")){//现在用户管理只有管委员和水环局修改账号，所以新增和修改验证账号是否重复时pid就是user_id
            if(StringUtils.isNotEmpty(username)){
                Map<String,Object> map=new HashMap<>();
                map.put("username",username);
                map.put("pid",pid);
                List<SysUserEntity> entityList=cominfoBaseinfoService.verifyNameByUser(map);
                if(entityList.size()>0){
                    status=true;
                }
            }
        }
        if(type.equals("POST")){
            List<SysUserEntity> userEntityList=cominfoBaseinfoService.verifyPhoneByUser(params);
            if(userEntityList.size()>0){
                flag=true;
            }
        }else {
            if(differType.equals("0")){
                List<SysUserEntity> list = cominfoBaseinfoService.verifyPhone(params);
                if(list.size()>0){
                    flag=true;
                }
            }else {
                List<SysUserEntity> userEntityList=cominfoBaseinfoService.verifyPhoneByUser(params);
                if(userEntityList.size()>0){
                    flag=true;
                }
            }
        }
        return R.ok().put("flag",flag).put("status",status);
    }

    /**
     * 新增企业时验证手机号和账号是否重复
     */
    @GetMapping("/verifyPhoneByUser")
    @ApiOperation("新增企业时验证手机号和账号是否重复")
    public R verifyPhoneByUser(@RequestParam Map<String, Object> params){
        String username=(String)params.get("username");
        username=username.substring(username.length()-12);
        boolean status=false;
        params.put("username",username);
        List<SysUserEntity> entityList = cominfoBaseinfoService.verifyNameByUser(params);
        if(entityList.size()>0){
            status=true;
        }
        boolean flag=false;
        List<SysUserEntity> list = cominfoBaseinfoService.verifyPhoneByUser(params);
        if(list.size()>0){
            flag=true;
        }
        return R.ok().put("flag",flag).put("status",status);
    }

    /**
     * 修改企业基本信息
     */
    @PutMapping
    @ApiOperation("修改企业基本信息")
    @Transactional(rollbackFor = Exception.class)
    @SysLog(value = "修改企业基本信息")
    public R update(@RequestBody CominfoBaseinfoEntity cominfoBaseinfo){
        String pid=cominfoBaseinfo.getPid();
        String creditCode=cominfoBaseinfo.getUnifiedSocialCreditCode();
        if(StringUtils.isNotBlank(pid)&StringUtils.isNotBlank(creditCode)){
            CominfoBaseinfoEntity infoEntity=cominfoBaseinfoService.selectById(pid);
            String code=infoEntity.getUnifiedSocialCreditCode();
//            if(StringUtils.isNotBlank(code)){
//                SysUserEntity entity=sysUserService.selectByMap(new MapUtils().put("username",code)).get(0);
//                SysDeptEntity deptEntity=sysDeptService.selectById(entity.getDeptId());
//                deptEntity.setName(cominfoBaseinfo.getCompanyName());
//                entity.setUsername(cominfoBaseinfo.getUnifiedSocialCreditCode());
//                sysUserService.updateById(entity);
//                sysDeptService.updateById(deptEntity);
//            }
        }
        ValidatorUtils.validateEntity(cominfoBaseinfo, UpdateGroup.class);
        cominfoBaseinfo.setUpdatedate(DateUtils.getStringDate());
        cominfoBaseinfoService.updateById(cominfoBaseinfo);

        return R.ok();
    }

    /**
     * 删除企业基本信息
     */
    @DeleteMapping
    @ApiOperation("删除企业基本信息")
    @Transactional(rollbackFor = Exception.class)
    @SysLog(value = "删除企业基本信息")
    public R delete(@RequestBody String[] pids){
        cominfoBaseinfoService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }


    /**
     * 获取所属市区县
     */
    @GetMapping("/getCity")
    public R getRegionInfo(@RequestParam(value = "parent_short_code") String parent_short_code){
        List<CityEntity>  citys = sysConfigService.getCity(parent_short_code);
        return R.ok().put("citys",citys);
    }

    /**
     * 注册新企业
     */
    @PostMapping("/register")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "注册新企业")
    @ApiOperation("注册新企业")
    public R register(@RequestBody CominfoBaseinfoEntity cominfoBaseinfo){
        ValidatorUtils.validateEntity(cominfoBaseinfo, AddGroup.class);
        cominfoBaseinfo.setCreatedate(DateUtils.getStringDate());
        cominfoBaseinfo.setUpdatedate(DateUtils.getStringDate());
        String pid = cominfoBaseinfoService.register(cominfoBaseinfo);
        return R.ok();
    }

    /**
     * 风险源
     */
    @GetMapping("/riskSourceSel")
    @ApiOperation("风险源")
    public String riskSourceSel(@RequestParam Map<String, Object> params){
//        long startTime=System.currentTimeMillis();
        PageUtils page = cominfoBaseinfoService.riskSourceSel(params);
//        long endTime=System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 风险源公司名模糊查
     */
    @GetMapping("/riskSourceName")
    @ApiOperation("风险源公司名模糊查")
    public String queryName(@RequestParam Map<String, Object> params){
        List<CominfoBaseinfoEntity> list= cominfoBaseinfoService.queryName(params);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }


    /**
     * 模糊查询搜索
     */
    @GetMapping("/queryName")
    @ApiOperation("企业名称")
    public R likeCompanyName(@RequestParam Map<String, Object> params){
        String pollutionSourceCategory = (String)params.get("pollutionSourceCategory");
        if(pollutionSourceCategory != null && !pollutionSourceCategory.equals("")){
            params.put("pollutionSourceCategory",pollutionSourceCategory.split("-"));
        }
        List<CominfoBaseinfoEntity> list= cominfoBaseinfoService.likeCompanyName(params);
        return R.ok().put("data",list);
    }

    /**
     * 获得字典表key值
     */
    @GetMapping("/getDict")
    @ApiOperation("获得字典表key值")
    public R getDict(@RequestParam Map<String, Object> params){
        String value=(String) params.get("value");
        String type=(String) params.get("type");
        List<SysDictEntity> list=sysDictService.selectByMap(new MapUtils().put("value",value).put("type",type));
        return R.ok().put("data",list);
    }
    /**
     * 列表(根据用户是企业还是管理员展示不同页面)
     */
    @GetMapping("listByUser")
    @ApiOperation("列表")
    public String listByUser(@RequestParam Map<String, Object> params,HttpServletRequest request){
        int userfalg=Integer.parseInt((String) params.get("userflag"));
        if(userfalg ==2){
            String token = UserUtils.getToken(request);
            Map<String, String> map = UserUtils.getPoyload(token);
            params.put("companyId",map.get("userDeptId"));
        }
            PageUtils page = cominfoBaseinfoService.listByUser(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }
    /**
     * 用户角色判断（企业或管理）
     */
    @GetMapping("/userEstimate")
    @ApiOperation("列表")
    public R userEstimate(HttpServletRequest request){
        String token = UserUtils.getToken(request);
        SysUserEntity sysUserEntity = new SysUserEntity();
        Map<String, String> map = UserUtils.getPoyload(token);
        sysUserEntity.setUserId(map.get("userId"));
        sysUserEntity.setDeptName(map.get("userDeptName"));
//        String str = map.get("userDeptName");
        String str = "管理员1";
        if(str.indexOf("管理员") != -1){
            return R.ok().put("userType",GUANLIYUAN_ROLE);
        } else{
            return R.ok().put("userType",QIYE_ROLE);
        }
    }
}
