package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.core.utils.*;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionEquipmentEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoProductionEquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 生产设备
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:42:48
 */
@RestController
@RequestMapping("market/cominfoproductionequipment")
@Api(tags="生产设备")
public class CominfoProductionEquipmentController extends BaseController{
    @Autowired
    private CominfoProductionEquipmentService cominfoProductionEquipmentService;
    @Autowired
    private SysDictService sysDictService;
    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoProductionEquipmentService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<CominfoProductionEquipmentEntity> list= cominfoProductionEquipmentService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        CominfoProductionEquipmentEntity cominfoProductionEquipment = cominfoProductionEquipmentService.entityById(pid);
        return R.ok().put("cominfoProductionProcess", cominfoProductionEquipment);
    }

    /**
     * 根据公司id获取生产设备
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取生产设备")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        Map<String,Object> params=new HashMap<>();
        params.put("cid",cid);
        List<CominfoProductionEquipmentEntity> list = cominfoProductionEquipmentService.queryList(params);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存生产设备
     */
    @PostMapping
    @ApiOperation("保存生产设备")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存生产设备")
    public R save(@RequestBody CominfoProductionEquipmentEntity cominfoProductionEquipment){
        ValidatorUtils.validateEntity(cominfoProductionEquipment, AddGroup.class);
        cominfoProductionEquipment.setCreatedate(DateUtils.getDate());
        cominfoProductionEquipment.setUpdatedate(DateUtils.getDate());
        cominfoProductionEquipmentService.insert(cominfoProductionEquipment);

        return R.ok();
    }

    /**
     * 修改生产设备
     */
    @PutMapping
    @ApiOperation("修改生产设备")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改生产设备")
    public R update(@RequestBody CominfoProductionEquipmentEntity cominfoProductionEquipment){
        ValidatorUtils.validateEntity(cominfoProductionEquipment, UpdateGroup.class);
        cominfoProductionEquipment.setUpdatedate(DateUtils.getDate());
        cominfoProductionEquipmentService.updateById(cominfoProductionEquipment);

        return R.ok();
    }

    /**
     * 删除生产设备
     */
    @DeleteMapping
    @ApiOperation("删除生产设备")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "删除生产设备")
    public R delete(@RequestBody String[] pids){
        cominfoProductionEquipmentService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
