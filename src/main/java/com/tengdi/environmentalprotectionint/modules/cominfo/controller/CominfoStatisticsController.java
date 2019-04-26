package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.MapUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalManageEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoEnvironmentalManageService;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoStatisticsService;
import com.tengdi.environmentalprotectionint.modules.mobile.service.MobileEnforcementSceneService;
import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页统计信息
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:29
 */
@RestController
@RequestMapping("comInfo/statistics")
public class CominfoStatisticsController extends BaseController{
    @Autowired
    private CominfoStatisticsService cominfoStatisticsService;
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
        PageUtils page = cominfoStatisticsService.queryPage(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 企业统计基础信息,查询第一行六个
     */
    @GetMapping("/baseInfoStatic")
    @ApiOperation("统计信息基础查询")
    public R baseStaticinfo(){
        R r = new R();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArr = new JSONArray();
        jsonArr = cominfoStatisticsService.baseInfoStatic();
        return r.put("data",jsonArr);
    }


    /**
     * 企业统计 按类型查询
     */
    @GetMapping("/industryStatic")
    @ApiOperation("企业类型统计查询")
    public R industryStaticinfo() {
        // jsonArr = cominfoEnvironmentalManageService.industryidStatic();
        Map<String, Object> map = mobileEnforcementSceneService.industryidStatic1();
        return R.ok().put("data1", map.get("jsonArr2")).put("data2", map.get("jsonArr"));
    }

    /**
     * 企业统计 按规模查询
     */
    @GetMapping("/enterpriScaleStatic")
    @ApiOperation("企业规模数量统计查询")
    public R enterpriScaleStaticinfo() {
        R r = new R();
        JSONArray jsonArr = new JSONArray();
        jsonArr = cominfoStatisticsService.enterpriScaleStatic();
        return r.put("data", jsonArr);
    }

    /**
     * 企业统计 按区域查询
     */
    @GetMapping("/enterpriAreaStatic")
    @ApiOperation("企业区域数量统计查询")
    public R enterpriAreaStaticinfo() {
        R r = new R();
        JSONArray jsonArr = new JSONArray();
        jsonArr = cominfoStatisticsService.enterpriAreaStatic();
        return r.put("data", jsonArr);
    }


    /**
     * 执法统计  按年和月
     * @param year
     * @param month
     * @return
     */
    @GetMapping("/lawEnforceStatic/{year}/{month}")
    public R lawEnforceStaticInfo(@PathVariable("year") String year,@PathVariable("month") String month){
        JSONObject jsonObject = null;
        Map<String,Object> params = new HashMap<>();
        params.put("year",year);
        params.put("month",month);
        jsonObject = cominfoStatisticsService.lawEnforceStatic(params);
        return new R().put("data", jsonObject);
    }


}
