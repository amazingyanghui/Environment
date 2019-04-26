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
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemDrillEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemDrillService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 应急演练
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:16:54
 */
@RestController
@RequestMapping("emergency/emergencysystemdrill")
@Api(tags="应急演练")
public class EmergencySystemDrillController extends BaseController{
    @Autowired
    private EmergencySystemDrillService emergencySystemDrillService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        //PageUtils page = emergencySystemDrillService.queryPage(params);
        PageUtils page = emergencySystemDrillService.queryPageSql(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<EmergencySystemDrillEntity> list= emergencySystemDrillService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/queryName")
    @ApiOperation("列表")
    public String queryName(@RequestParam Map<String, Object> params){
        List<EmergencySystemDrillEntity> list= emergencySystemDrillService.queryName(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        EmergencySystemDrillEntity emergencySystemDrill = emergencySystemDrillService.entityById(pid);

        return R.ok().put("emergencySystemDrill", emergencySystemDrill);
    }

    /**
     * 根据公司id获取应急演练
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取应急演练")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<EmergencySystemDrillEntity> list = emergencySystemDrillService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody EmergencySystemDrillEntity emergencySystemDrill){
        ValidatorUtils.validateEntity(emergencySystemDrill, AddGroup.class);
        emergencySystemDrill.setCreatedate(DateUtils.getDate());
        String pid=emergencySystemDrillService.insertData(emergencySystemDrill);

        return R.ok().put("pid",pid);
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody EmergencySystemDrillEntity emergencySystemDrill){
        ValidatorUtils.validateEntity(emergencySystemDrill, UpdateGroup.class);
        emergencySystemDrillService.updateById(emergencySystemDrill);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        emergencySystemDrillService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
