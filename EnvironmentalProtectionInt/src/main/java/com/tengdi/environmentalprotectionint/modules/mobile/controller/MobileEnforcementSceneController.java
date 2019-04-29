package com.tengdi.environmentalprotectionint.modules.mobile.controller;

import com.tengdi.core.utils.*;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;

import java.util.*;

import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.environmentalprotectionint.modules.mobile.entity.MobileEnforcementSceneEntity;
import com.tengdi.environmentalprotectionint.modules.mobile.service.MobileEnforcementSceneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 移动执法现场执法
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 11:57:35
 */
@RestController
@RequestMapping("mobile/mobileenforcementscene")
@Api(tags="移动执法现场执法")
public class MobileEnforcementSceneController extends BaseController{
    @Autowired
    private MobileEnforcementSceneService mobileEnforcementSceneService;
    @Autowired
    private SysDictService sysDictService;
    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = mobileEnforcementSceneService.mobilelist(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }
    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<MobileEnforcementSceneEntity> list= mobileEnforcementSceneService.queryList(params);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/queryName")
    @ApiOperation("列表")
    public String queryName(@RequestParam Map<String, Object> params){
        List<MobileEnforcementSceneEntity> list= mobileEnforcementSceneService.queryName(params);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        MobileEnforcementSceneEntity mobileEnforcementScene = mobileEnforcementSceneService.entityById(pid);
        return R.ok().put("mobileEnforcementScene", mobileEnforcementScene);
    }

    /**
     * 根据公司id获取移动执法现场执法
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取移动执法现场执法")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<MobileEnforcementSceneEntity> list = mobileEnforcementSceneService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody MobileEnforcementSceneEntity mobileEnforcementScene){
        ValidatorUtils.validateEntity(mobileEnforcementScene, AddGroup.class);
        mobileEnforcementScene.setCreatedate(DateUtils.getDate());
        String pid=mobileEnforcementSceneService.insertData(mobileEnforcementScene);
        return R.ok().put("pid",pid);
    }
    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody MobileEnforcementSceneEntity mobileEnforcementScene){
        ValidatorUtils.validateEntity(mobileEnforcementScene, UpdateGroup.class);
        mobileEnforcementSceneService.updateById(mobileEnforcementScene);
        return R.ok();
    }
    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        mobileEnforcementSceneService.deleteBatchIds(Arrays.asList(pids));
        return R.ok();
    }
    /**
     *  移动执法记录列表信息
     */
    @GetMapping("/lq")
    @ApiOperation("列表")
    public String mobilelist(@RequestParam Map<String, Object> params){
        PageUtils page = mobileEnforcementSceneService.mobilelist(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }
    /**
     * 移动执法-图标统计
     */
    @GetMapping("/comprehensiveStatistical/{year}")
    @ApiOperation("移动执法-图标统计")
    public R comprehensiveStatistical(@PathVariable ("year") String year){
        int lastyear=(Integer.parseInt(year)-1);
        Map<String,Object> map=new HashMap<>();
        map.put("year",year);
        map.put("lastyear",lastyear+"");
        //移动执法统计：该年累计值法人次、执法人员总数、发现问题总数、相比去年执法总数增加百分比
       Map<String,Object> map1= mobileEnforcementSceneService.comprehensiveStatistical(map);
        //移动执法图表统计:月执法统计
        int [] monthContainer= mobileEnforcementSceneService.statistical(map);
        //移动执法统计：去年执法次数与今年对比
        int [] contrast = mobileEnforcementSceneService.statisticalLastyearAndThisyear(map);
        //移动执法统计：检查结果
        JSONArray checkTheResultStatistical= mobileEnforcementSceneService.checkTheResultStatistical(map);
        //移动执法统计：问题类型
        JSONArray statisticalProblemType= mobileEnforcementSceneService.statisticalProblemType(map);
        //移动执法统计：本年度执法类型统计
        JSONArray lawEnforcementTypeStatisticalist= mobileEnforcementSceneService.lawEnforcementTypeStatistical(map);
        return  R.ok().put("LawEnforcementNumber",map1.get("LawEnforcementNumber"))
                .put("LawEnforcementPersonnel", map1.get("LawEnforcementPersonnel"))
                .put("FoundTheProblem", map1.get("FoundTheProblem"))
                .put("growth", map.get("growth"))
                .put("monthContainer",monthContainer)
                .put("contrast",contrast)
                .put("checkTheResultStatistical",checkTheResultStatistical)
                .put("statisticalProblemType",statisticalProblemType)
                .put("lawEnforcementTypeStatisticalist",lawEnforcementTypeStatisticalist);
    }
    /**
     * 获取字典中的年份
     */
    @GetMapping("/statisticalYearQuery")
    @ApiOperation("图标统计年份查询")
    public R statisticalYearQuery(){
        String type="statisticalYear";
        int  status=1;
        List<SysDictEntity> dicts = sysDictService.selectByMap(new MapUtils().put("type",type).put("status",status));
        List<SysDictEntity> dicts1=mobileEnforcementSceneService.storByList(dicts);
        return R.ok().put("dicts", dicts1);
    }
    /**
     * 环保执法监察
     */
    @GetMapping("/environmentalLawEnforcementMonitoring/{type}")
    @ApiOperation("环保执法监察")
    public R environmentalLawEnforcementMonitoring(@PathVariable ("type") String type){
        //根据类型（全部、本年、本月）查询移动执法-现场执法和调查问卷的次数\执法次数、执法人数、发现违法行为数、立案数
        Map<String,Object> map=mobileEnforcementSceneService.environmentalLawEnforcementMonitoring(type);
        return R.ok()
        .put("data",map.get("data"))
        .put("interrogationRecord",map.get("interrogationRecord"))
        .put("onSiteInspection",map.get("onSiteInspection"))
        .put("numberOfLawEnforcement",map.get("numberOfLawEnforcement"))
        .put("LawEnforcementPersonnel",map.get("LawEnforcementPersonnel"))
        .put("FoundTheProblem",map.get("FoundTheProblem"))
        .put("putOnRecord",map.get("putOnRecord"));
    }

    /**
     * 移动执法页头弹框列表查询接口
     */
    @GetMapping("/playListBox")
    @ApiOperation("列表")
    public String playListBox(@RequestParam Map<String, Object> params){
        PageUtils page = mobileEnforcementSceneService.playListBox(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }
}
