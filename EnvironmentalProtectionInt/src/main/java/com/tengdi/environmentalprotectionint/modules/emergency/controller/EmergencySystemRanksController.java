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
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemRanksEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemRanksService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 应急队伍
 *
 * @author tengdi
 * @email 
 * @date 2018-08-23 15:10:45
 */
@RestController
@RequestMapping("emergency/emergencysystemranks")
@Api(tags="应急队伍")
public class EmergencySystemRanksController extends BaseController{
    @Autowired
    private EmergencySystemRanksService emergencySystemRanksService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = emergencySystemRanksService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<EmergencySystemRanksEntity> list= emergencySystemRanksService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        EmergencySystemRanksEntity emergencySystemRanks = emergencySystemRanksService.selectById(pid);

        return R.ok().put("emergencySystemRanks", emergencySystemRanks);
    }

    /**
     * 根据公司id获取应急队伍
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取应急队伍")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<EmergencySystemRanksEntity> list = emergencySystemRanksService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody EmergencySystemRanksEntity emergencySystemRanks){
        ValidatorUtils.validateEntity(emergencySystemRanks, AddGroup.class);
        emergencySystemRanks.setCreatedate(DateUtils.getDate());
        emergencySystemRanksService.insert(emergencySystemRanks);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody EmergencySystemRanksEntity emergencySystemRanks){
        ValidatorUtils.validateEntity(emergencySystemRanks, UpdateGroup.class);
        emergencySystemRanksService.updateById(emergencySystemRanks);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        emergencySystemRanksService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
