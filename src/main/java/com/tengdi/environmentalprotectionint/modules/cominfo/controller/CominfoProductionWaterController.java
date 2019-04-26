package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionWaterEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoProductionWaterService;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用水情况
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 14:30:09
 */
@RestController
@RequestMapping("market/cominfoproductionwater")
@Api(tags="用水情况")
public class CominfoProductionWaterController extends BaseController{
    @Autowired
    private CominfoProductionWaterService cominfoProductionWaterService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoProductionWaterService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<CominfoProductionWaterEntity> list= cominfoProductionWaterService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }



    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        CominfoProductionWaterEntity cominfoProductionWater = cominfoProductionWaterService.selectById(pid);

        return R.ok().put("cominfoProductionProcess", cominfoProductionWater);
    }

    /**
     * 根据公司id获取用水情况
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取用水情况")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<CominfoProductionWaterEntity> list = cominfoProductionWaterService.selectByMap(new MapUtils().put("cid",cid));
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存用水情况
     */
    @PostMapping
    @ApiOperation("保存用水情况")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存用水情况")
    public R save(@RequestBody CominfoProductionWaterEntity cominfoProductionWater){
        ValidatorUtils.validateEntity(cominfoProductionWater, AddGroup.class);
        cominfoProductionWater.setCreatedate(DateUtils.getStringDate());
        cominfoProductionWater.setUpdatedate(DateUtils.getStringDate());
        cominfoProductionWaterService.insert(cominfoProductionWater);

        return R.ok();
    }

    /**
     * 修改用水情况
     */
    @PutMapping
    @ApiOperation("修改用水情况")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改用水情况")
    public R update(@RequestBody CominfoProductionWaterEntity cominfoProductionWater){
        ValidatorUtils.validateEntity(cominfoProductionWater, UpdateGroup.class);
        cominfoProductionWater.setUpdatedate(DateUtils.getStringDate());
        cominfoProductionWaterService.updateById(cominfoProductionWater);

        return R.ok();
    }

    /**
     * 删除用水情况
     */
    @DeleteMapping
    @ApiOperation("删除用水情况")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "删除用水情况")
    public R delete(@RequestBody String[] pids){
        cominfoProductionWaterService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
