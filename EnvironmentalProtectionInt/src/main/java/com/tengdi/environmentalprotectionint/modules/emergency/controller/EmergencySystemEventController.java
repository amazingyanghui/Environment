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
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemEventEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemEventService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 环境应急事件
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:15:20
 */
@RestController
@RequestMapping("emergency/emergencysystemevent")
@Api(tags="环境应急事件")
public class EmergencySystemEventController extends BaseController{
    @Autowired
    private EmergencySystemEventService emergencySystemEventService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = emergencySystemEventService.queryPageSql(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<EmergencySystemEventEntity> list= emergencySystemEventService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/queryName")
    @ApiOperation("列表")
    public String queryName(@RequestParam Map<String, Object> params){
        List<EmergencySystemEventEntity> list= emergencySystemEventService.queryName(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        EmergencySystemEventEntity emergencySystemEvent = emergencySystemEventService.entityById(pid);

        return R.ok().put("emergencySystemEvent", emergencySystemEvent);
    }

    /**
     * 根据公司id获取环境应急事件
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取环境应急事件")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<EmergencySystemEventEntity> list = emergencySystemEventService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody EmergencySystemEventEntity emergencySystemEvent){
        ValidatorUtils.validateEntity(emergencySystemEvent, AddGroup.class);
        emergencySystemEvent.setCreatedate(DateUtils.getDate());
        emergencySystemEventService.insert(emergencySystemEvent);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody EmergencySystemEventEntity emergencySystemEvent){
        ValidatorUtils.validateEntity(emergencySystemEvent, UpdateGroup.class);
        emergencySystemEventService.updateById(emergencySystemEvent);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        emergencySystemEventService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
