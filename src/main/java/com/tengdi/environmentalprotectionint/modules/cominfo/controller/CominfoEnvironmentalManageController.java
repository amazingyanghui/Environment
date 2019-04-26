package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.environmentalprotectionint.modules.mobile.service.MobileEnforcementSceneService;
import com.tengdi.core.utils.*;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalManageEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoEnvironmentalManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 环境管理属性
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:29
 */
@RestController
@RequestMapping("market/cominfoenvironmentalmanage")
@Api(tags="环境管理属性")
public class CominfoEnvironmentalManageController extends BaseController{
    @Autowired
    private CominfoEnvironmentalManageService cominfoEnvironmentalManageService;
    @Autowired
    private SysDictService sysDictService;
    @Autowired
    private MobileEnforcementSceneService mobileEnforcementSceneService;
    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoEnvironmentalManageService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 根据公司id获取管理属性(特殊)
     */
    @GetMapping("/{cid}")
    @ApiOperation("根据公司id获取管理属性(特殊)")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public R info(@PathVariable("cid") String cid){
        CominfoEnvironmentalManageEntity manageEntity = cominfoEnvironmentalManageService.dataById(cid);
        if(manageEntity!=null){
            if(manageEntity.getRegulatoryLevel()!=null){
                List<SysDictEntity> regulatoryLevelList=sysDictService.selectByMap(new MapUtils().put("`key`", manageEntity.getRegulatoryLevel()).put("type","regulatory_level_type"));
                if(regulatoryLevelList.size()>0){
                    manageEntity.setRegulatoryLevelName(regulatoryLevelList.get(0).getValue());
                }
            }
            if(manageEntity.getRegulatoryYear()!=null){
                List<SysDictEntity> regulatoryYearList=sysDictService.selectByMap(new MapUtils().put("`key`", manageEntity.getRegulatoryYear()).put("type","regulatory_year_type"));
                if (regulatoryYearList.size()>0){
                    manageEntity.setRegulatoryYearName(regulatoryYearList.get(0).getValue());
                }
            }

            if(manageEntity.getRiskRating()!=null){
                List<SysDictEntity> riskRatingList=sysDictService.selectByMap(new MapUtils().put("`key`", manageEntity.getRiskRating()).put("type","risk_rating"));
                if (riskRatingList.size()>0){
                    manageEntity.setRiskRatingName(riskRatingList.get(0).getValue());
                }
            }

            if(manageEntity.getCreditEvaluation()!=null){
                List<SysDictEntity> creditEvaluationList=sysDictService.selectByMap(new MapUtils().put("`key`", manageEntity.getCreditEvaluation()).put("type","credit_evaluation_type"));
                if (creditEvaluationList.size()>0){
                    manageEntity.setCreditEvaluationName(creditEvaluationList.get(0).getValue());
                }
            }
            if(manageEntity.getSourceLabel()!=null){
                List<SysDictEntity> sourceLabelList=sysDictService.selectByMap(new MapUtils().put("`key`", manageEntity.getSourceLabel()).put("type","source_label_type"));
                if (sourceLabelList.size()>0){
                    manageEntity.setSourceLabelName(sourceLabelList.get(0).getValue());
                }
            }
            List<SysDictEntity> valueList=sysDictService.selectByMap(new MapUtils().put("type","boolean_type"));
            for(SysDictEntity dictEntity:valueList){
                if(dictEntity.getKey().equals(manageEntity.getKeySource())){
                    manageEntity.setKeySourceName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getRiskSource())){
                    manageEntity.setRiskSourceName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getSewagePlant())){
                    manageEntity.setSewagePlantName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getWasteWater())){
                    manageEntity.setWasteWaterName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getSourceUnit())){
                    manageEntity.setSourceUnitName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getEmissionEnterprises())){
                    manageEntity.setEmissionEnterprisesName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getVocEnterprises())){
                    manageEntity.setVocEnterprisesName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getHeavyMetal())){
                    manageEntity.setHeavyMetalName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getCleanerProduction())){
                    manageEntity.setCleanerProductionName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getEnvironmentalStatistics())){
                    manageEntity.setEnvironmentalStatisticsName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getOnlineMonitoring())){
                    manageEntity.setOnlineMonitoringName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getDischargeFee())){
                    manageEntity.setDischargeFeeName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getEmissionDeclaration())){
                    manageEntity.setEmissionDeclarationName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getWasteManagement())){
                    manageEntity.setWasteManagementName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getWasteGeneration())){
                    manageEntity.setWasteGenerationName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getThirtykwCompany())){
                    manageEntity.setThirtykwCompanyName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getRandomCheck())){
                    manageEntity.setRandomCheckName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getSpecialSource())){
                    manageEntity.setSpecialSourceName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getCancelManagement())){
                    manageEntity.setCancelManagementName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsiso())){
                    manageEntity.setIsisoName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsSampling())){
                    manageEntity.setIsSamplingName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsOceaneering())){
                    manageEntity.setIsOceaneeringName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsOceaneering())){
                    manageEntity.setIsOceaneeringName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsBoilerOrGasTurbine())){
                    manageEntity.setIsBoilerOrGasTurbineName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsIndustrialFurnace())){
                    manageEntity.setIsIndustrialFurnaceName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsCokingProcess())){
                    manageEntity.setIsCokingProcessName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsSinterOrpelletizProcess())){
                    manageEntity.setIsSinterOrpelletizProcessName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsIronmakingProcess())){
                    manageEntity.setIsIronmakingProcessName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsSteelmakingProcess())){
                    manageEntity.setIsSteelmakingProcessName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsClinkerProduction())){
                    manageEntity.setIsClinkerProductionName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsPetrochemicalEnterprises())){
                    manageEntity.setIsPetrochemicalEnterprisesName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsOrganicLiquidTankOrLoad())){
                    manageEntity.setIsOrganicLiquidTankOrLoadName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsContainOrganicMaterialUse())){
                    manageEntity.setIsContainOrganicMaterialUseName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsSolidMaterialStorage())){
                    manageEntity.setIsSolidMaterialStorageName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsOtherWasteGasProduction())){
                    manageEntity.setIsOtherWasteGasProductionName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsGeneralIndustrialSolidWaste())){
                    manageEntity.setIsGeneralIndustrialSolidWasteName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsInvolvingMinerals())){
                    manageEntity.setIsInvolvingMineralsName(dictEntity.getValue());
                }
                if(dictEntity.getKey().equals(manageEntity.getIsGrantDischargePermit())){
                    manageEntity.setIsGrantDischargePermitName( dictEntity.getValue());
                }
            }
        }
        return R.ok().put("cominfoEnvironmental", manageEntity);
    }

    /**
     * 保存管理属性
     */
    @PostMapping
    @ApiOperation("保存管理属性")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存管理属性")
    public R save(@RequestBody CominfoEnvironmentalManageEntity cominfoEnvironmentalManage){
        ValidatorUtils.validateEntity(cominfoEnvironmentalManage, AddGroup.class);
//        cominfoEnvironmentalManage.setCreatedate(DateUtils.getDate());
//        cominfoEnvironmentalManage.setUpdatedate(DateUtils.getDate());
        cominfoEnvironmentalManageService.insert(cominfoEnvironmentalManage);

        return R.ok();
    }

    /**
     * 修改管理属性
     */
    @PutMapping
    @ApiOperation("修改管理属性")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改管理属性")
    public R update(@RequestBody CominfoEnvironmentalManageEntity cominfoEnvironmentalManage){
        ValidatorUtils.validateEntity(cominfoEnvironmentalManage, UpdateGroup.class);
//        cominfoEnvironmentalManage.setUpdatedate(DateUtils.getDate());
        cominfoEnvironmentalManageService.updateById(cominfoEnvironmentalManage);

        return R.ok();
    }

    /**
     * 删除管理属性
     */
    @DeleteMapping
    @ApiOperation("删除管理属性")
    @SysLog(value = "删除管理属性")
    @Transactional(rollbackFor = {Exception.class})
    public R delete(@RequestBody String[] pids){
        cominfoEnvironmentalManageService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }
    /**
     * 企业统计基础信息
     */
    @GetMapping("/baseInfoStatic")
    @ApiOperation("统计信息基础查询")
    public R baseStaticinfo(){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
       JSONArray jsonArr = new JSONArray();
        jsonArr = cominfoEnvironmentalManageService.baseInfoStatic();
        return r.put("data",jsonArr);
    }

    /**
     * 企业污染源类别统计
     */
    @GetMapping("/sourceCategoryStatic")
    @ApiOperation("企业污染源类别统计查询")
    public R sourceCategoryStaticinfo(){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArr = new JSONArray();
        jsonArr = cominfoEnvironmentalManageService.sourceCategoryStatic();
        return r.put("data",jsonArr);
    }

    /**
     * 企业风险等级统计
     */
    @GetMapping("/riskLevelStatic")
    @ApiOperation("企业风险等级统计查询")
    public R riskLevelStaticinfo(){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArr = new JSONArray();
        jsonArr = cominfoEnvironmentalManageService.riskLevelStatic();
        return r.put("data",jsonArr);
    }
    /**
     * 企业规模数量统计
     */
    @GetMapping("/enterpriSecaleStatic")
    @ApiOperation("企业规模数量统计查询")
    public R enterpriSecaleStaticinfo(){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArr = new JSONArray();
        jsonArr = cominfoEnvironmentalManageService.enterpriSecaleStatic();
        return r.put("data",jsonArr);
    }
    /**
     * 行业类别占比统计
     */
    @GetMapping("/industryStatic")
    @ApiOperation("行业类别占比统计查询")
    public R industryStaticinfo(){
       // jsonArr = cominfoEnvironmentalManageService.industryidStatic();
        Map<String,Object>  map =  mobileEnforcementSceneService.industryidStatic1();
        return R.ok().put("data1",map.get("jsonArr2")).put("data2",map.get("jsonArr"));
}

}
