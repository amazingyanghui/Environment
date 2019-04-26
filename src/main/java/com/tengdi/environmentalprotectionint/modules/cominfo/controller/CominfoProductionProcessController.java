package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoProductionProcessEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoProductionProcessService;
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
 * 生产工艺
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:42:28
 */
@RestController
@RequestMapping("market/cominfoproductionprocess")
@Api(tags="生产工艺")
public class CominfoProductionProcessController extends BaseController{
    @Autowired
    private CominfoProductionProcessService cominfoProductionProcessService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoProductionProcessService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<CominfoProductionProcessEntity> list= cominfoProductionProcessService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        CominfoProductionProcessEntity cominfoProductionProcess = cominfoProductionProcessService.selectById(pid);

        return R.ok().put("cominfoProductionProcess", cominfoProductionProcess);
    }

    /**
     * 根据公司id获取生产工艺
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取生产工艺")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<CominfoProductionProcessEntity> list = cominfoProductionProcessService.selectByMap(new MapUtils().put("cid",cid));
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存生产工艺
     */
    @PostMapping
    @ApiOperation("保存生产工艺")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存生产工艺")
    public R save(@RequestBody CominfoProductionProcessEntity cominfoProductionProcess){
        ValidatorUtils.validateEntity(cominfoProductionProcess, AddGroup.class);
        cominfoProductionProcess.setCreatedate(DateUtils.getDate());
        cominfoProductionProcess.setUpdatedate(DateUtils.getDate());
        cominfoProductionProcessService.insert(cominfoProductionProcess);

        return R.ok();
    }

    /**
     * 修改生产工艺
     */
    @PutMapping
    @ApiOperation("修改生产工艺")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改生产工艺")
    public R update(@RequestBody CominfoProductionProcessEntity cominfoProductionProcess){
        ValidatorUtils.validateEntity(cominfoProductionProcess, UpdateGroup.class);
        cominfoProductionProcess.setUpdatedate(DateUtils.getDate());
        cominfoProductionProcessService.updateById(cominfoProductionProcess);

        return R.ok();
    }

    /**
     * 删除生产工艺
     */
    @DeleteMapping
    @ApiOperation("删除生产工艺")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "删除生产工艺")
    public R delete(@RequestBody String[] pids){
        cominfoProductionProcessService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
