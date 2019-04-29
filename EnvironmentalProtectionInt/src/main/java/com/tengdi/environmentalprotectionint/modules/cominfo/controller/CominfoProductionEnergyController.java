package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.core.utils.*;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionEnergyEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoProductionEnergyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 能源消耗
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:00
 */
@RestController
@RequestMapping("market/cominfoproductionenergy")
@Api(tags="能源消耗")
public class CominfoProductionEnergyController extends BaseController{
    @Autowired
    private CominfoProductionEnergyService cominfoProductionEnergyService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoProductionEnergyService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<CominfoProductionEnergyEntity> list= cominfoProductionEnergyService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        CominfoProductionEnergyEntity cominfoProductionEnergy = cominfoProductionEnergyService.selectById(pid);

        return R.ok().put("cominfoProductionProcess", cominfoProductionEnergy);
    }

    /**
     * 根据公司id获取能源消耗
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取能源消耗")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<CominfoProductionEnergyEntity> list = cominfoProductionEnergyService.selectByMap(new MapUtils().put("cid",cid));
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存能源消耗
     */
    @PostMapping
    @ApiOperation("保存能源消耗")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存能源消耗")
    public R save(@RequestBody CominfoProductionEnergyEntity cominfoProductionEnergy){
        ValidatorUtils.validateEntity(cominfoProductionEnergy, AddGroup.class);
        cominfoProductionEnergy.setCreatedate(DateUtils.getStringDate());
        cominfoProductionEnergy.setUpdatedate(DateUtils.getStringDate());
        cominfoProductionEnergyService.insert(cominfoProductionEnergy);

        return R.ok();
    }

    /**
     * 修改能源消耗
     */
    @PutMapping
    @ApiOperation("修改能源消耗")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改能源消耗")
    public R update(@RequestBody CominfoProductionEnergyEntity cominfoProductionEnergy){
        ValidatorUtils.validateEntity(cominfoProductionEnergy, UpdateGroup.class);
        cominfoProductionEnergy.setUpdatedate(DateUtils.getStringDate());
        cominfoProductionEnergyService.updateById(cominfoProductionEnergy);

        return R.ok();
    }

    /**
     * 删除能源消耗
     */
    @DeleteMapping
    @ApiOperation("删除能源消耗")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "删除能源消耗")
    public R delete(@RequestBody String[] pids){
        cominfoProductionEnergyService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
