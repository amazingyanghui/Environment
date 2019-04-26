package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionProductEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoProductionProductService;
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
 * 主要产品
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:42:18
 */
@RestController
@RequestMapping("market/cominfoproductionproduct")
@Api(tags="主要产品")
public class CominfoProductionProductController extends BaseController{
    @Autowired
    private CominfoProductionProductService cominfoProductionProductService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoProductionProductService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<CominfoProductionProductEntity> list= cominfoProductionProductService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        CominfoProductionProductEntity cominfoProductionProduct = cominfoProductionProductService.selectById(pid);

        return R.ok().put("cominfoProductionProcess", cominfoProductionProduct);
    }

    /**
     * 根据公司id获取主要产品
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取主要产品")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<CominfoProductionProductEntity> list = cominfoProductionProductService.selectByMap(new MapUtils().put("cid",cid));
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存主要产品
     */
    @PostMapping
    @ApiOperation("保存主要产品")
    @SysLog(value = "保存主要产品")
    @Transactional(rollbackFor = {Exception.class})
    public R save(@RequestBody CominfoProductionProductEntity cominfoProductionProduct){
        ValidatorUtils.validateEntity(cominfoProductionProduct, AddGroup.class);
        cominfoProductionProduct.setCreatedate(DateUtils.getDate());
        cominfoProductionProduct.setUpdatedate(DateUtils.getDate());
        cominfoProductionProductService.insert(cominfoProductionProduct);

        return R.ok();
    }

    /**
     * 修改主要产品
     */
    @PutMapping
    @ApiOperation("修改主要产品")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改主要产品")
    public R update(@RequestBody CominfoProductionProductEntity cominfoProductionProduct){
        ValidatorUtils.validateEntity(cominfoProductionProduct, UpdateGroup.class);
        cominfoProductionProduct.setUpdatedate(DateUtils.getDate());
        cominfoProductionProductService.updateById(cominfoProductionProduct);

        return R.ok();
    }

    /**
     * 删除主要产品
     */
    @DeleteMapping
    @ApiOperation("删除主要产品")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "删除主要产品")
    public R delete(@RequestBody String[] pids){
        cominfoProductionProductService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
