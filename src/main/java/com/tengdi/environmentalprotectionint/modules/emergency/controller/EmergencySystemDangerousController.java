package com.tengdi.environmentalprotectionint.modules.emergency.controller;

import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemDangerousEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemDangerousService;
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

import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 危险化学品
 *
 * @author tengdi
 * @email 
 * @date 2018-09-11 11:50:45
 */
@RestController
@RequestMapping("emergency/emergencysystemdangerous")
@Api(tags="危险化学品")
public class EmergencySystemDangerousController extends BaseController{
    @Autowired
    private EmergencySystemDangerousService emergencySystemDangerousService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = emergencySystemDangerousService.queryPage(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<EmergencySystemDangerousEntity> list= emergencySystemDangerousService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/queryName")
    @ApiOperation("列表")
    public String queryName(@RequestParam Map<String, Object> params){
        List<EmergencySystemDangerousEntity> list= emergencySystemDangerousService.queryName(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        EmergencySystemDangerousEntity emergencySystemDangerous = emergencySystemDangerousService.entityById(pid);

        return R.ok().put("emergencySystemDangerous", emergencySystemDangerous);
    }

    /**
     * 根据公司id获取危险化学品
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取危险化学品")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<EmergencySystemDangerousEntity> list = emergencySystemDangerousService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody EmergencySystemDangerousEntity emergencySystemDangerous){
        ValidatorUtils.validateEntity(emergencySystemDangerous, AddGroup.class);
        emergencySystemDangerous.setCreatedate(DateUtils.getDate());
        emergencySystemDangerousService.insert(emergencySystemDangerous);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody EmergencySystemDangerousEntity emergencySystemDangerous){
        ValidatorUtils.validateEntity(emergencySystemDangerous, UpdateGroup.class);
//        emergencySystemDangerous.setUpdatedate(DateUtils.getDate());
        emergencySystemDangerousService.updateById(emergencySystemDangerous);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        emergencySystemDangerousService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
