package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionMaterialsEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoProductionMaterialsService;
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
 * 主要原辅助材料
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:42:35
 */
@RestController
@RequestMapping("market/cominfoproductionmaterials")
@Api(tags="主要原辅助材料")
public class CominfoProductionMaterialsController extends BaseController{
    @Autowired
    private CominfoProductionMaterialsService cominfoProductionMaterialsService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoProductionMaterialsService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<CominfoProductionMaterialsEntity> list= cominfoProductionMaterialsService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        CominfoProductionMaterialsEntity cominfoProductionMaterials = cominfoProductionMaterialsService.selectById(pid);

        return R.ok().put("cominfoProductionProcess", cominfoProductionMaterials);
    }

    /**
     * 根据公司id获取主要原辅助材料
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取主要原辅助材料")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<CominfoProductionMaterialsEntity> list = cominfoProductionMaterialsService.selectByMap(new MapUtils().put("cid",cid));
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存主要原辅助材料
     */
    @PostMapping
    @ApiOperation("保存主要原辅助材料")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存主要原辅助材料")
    public R save(@RequestBody CominfoProductionMaterialsEntity cominfoProductionMaterials){
        ValidatorUtils.validateEntity(cominfoProductionMaterials, AddGroup.class);
//        cominfoProductionMaterials.setCreatedate(DateUtils.getDate());
//        cominfoProductionMaterials.setUpdatedate(DateUtils.getDate());
        cominfoProductionMaterialsService.insert(cominfoProductionMaterials);

        return R.ok();
    }

    /**
     * 修改主要原辅助材料
     */
    @PutMapping
    @ApiOperation("修改主要原辅助材料")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改主要原辅助材料")
    public R update(@RequestBody CominfoProductionMaterialsEntity cominfoProductionMaterials){
        ValidatorUtils.validateEntity(cominfoProductionMaterials, UpdateGroup.class);
//        cominfoProductionMaterials.setUpdatedate(DateUtils.getDate());
        cominfoProductionMaterialsService.updateById(cominfoProductionMaterials);

        return R.ok();
    }

    /**
     * 删除主要原辅助材料
     */
    @DeleteMapping
    @ApiOperation("删除主要原辅助材料")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "删除主要原辅助材料")
    public R delete(@RequestBody String[] pids){
        cominfoProductionMaterialsService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
