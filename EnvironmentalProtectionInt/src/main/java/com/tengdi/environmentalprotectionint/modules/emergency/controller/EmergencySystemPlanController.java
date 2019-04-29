package com.tengdi.environmentalprotectionint.modules.emergency.controller;

import com.tengdi.core.utils.DateUtils;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemPlanEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemPlanService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 应急预案
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:12:16
 */
@RestController
@RequestMapping("emergency/emergencysystemplan")
@Api(tags="应急预案")
public class EmergencySystemPlanController extends BaseController{
    @Autowired
    private EmergencySystemPlanService emergencySystemPlanService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = emergencySystemPlanService.queryPageSql(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<EmergencySystemPlanEntity> list= emergencySystemPlanService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/queryName")
    @ApiOperation("列表")
    public String queryName(@RequestParam Map<String, Object> params){
        List<EmergencySystemPlanEntity> list= emergencySystemPlanService.queryName(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        EmergencySystemPlanEntity emergencySystemPlan = emergencySystemPlanService.entityById(pid);

        return R.ok().put("emergencySystemPlan", emergencySystemPlan);
    }

    /**
     * 根据公司id获取应急预案
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取应急预案")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<EmergencySystemPlanEntity> list = emergencySystemPlanService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody EmergencySystemPlanEntity emergencySystemPlan){
        ValidatorUtils.validateEntity(emergencySystemPlan, AddGroup.class);
        emergencySystemPlan.setCreatedate(DateUtils.getDate());
        String pid=emergencySystemPlanService.insertData(emergencySystemPlan);

        return R.ok().put("pid",pid);
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody EmergencySystemPlanEntity emergencySystemPlan){
        ValidatorUtils.validateEntity(emergencySystemPlan, UpdateGroup.class);
        emergencySystemPlanService.updateById(emergencySystemPlan);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        emergencySystemPlanService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
