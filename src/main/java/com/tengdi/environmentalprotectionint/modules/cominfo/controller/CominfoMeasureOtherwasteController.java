package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.core.utils.DateUtils;

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
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureOtherwasteEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoMeasureOtherwasteService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 其他治理设施
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:20
 */
@RestController
@RequestMapping("market/cominfomeasureotherwaste")
@Api(tags="其他治理设施")
public class CominfoMeasureOtherwasteController extends BaseController{
    @Autowired
    private CominfoMeasureOtherwasteService cominfoMeasureOtherwasteService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoMeasureOtherwasteService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<CominfoMeasureOtherwasteEntity> list= cominfoMeasureOtherwasteService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        CominfoMeasureOtherwasteEntity cominfoMeasureOtherwaste = cominfoMeasureOtherwasteService.selectById(pid);

        return R.ok().put("cominfoMeasureWastewater", cominfoMeasureOtherwaste);
    }

    /**
     * 根据公司id获取其他治理设施
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取其他治理设施")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<CominfoMeasureOtherwasteEntity> list = cominfoMeasureOtherwasteService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存其他治理设施
     */
    @PostMapping
    @ApiOperation("保存其他治理设施")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存其他治理设施")
    public R save(@RequestBody CominfoMeasureOtherwasteEntity cominfoMeasureOtherwaste){
        ValidatorUtils.validateEntity(cominfoMeasureOtherwaste, AddGroup.class);
        cominfoMeasureOtherwaste.setCreatedate(DateUtils.getStringDate());
        cominfoMeasureOtherwaste.setUpdatedate(DateUtils.getStringDate());
        cominfoMeasureOtherwasteService.insert(cominfoMeasureOtherwaste);

        return R.ok();
    }

    /**
     * 修改其他治理设施
     */
    @PutMapping
    @ApiOperation("修改其他治理设施")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改其他治理设施")
    public R update(@RequestBody CominfoMeasureOtherwasteEntity cominfoMeasureOtherwaste){
        ValidatorUtils.validateEntity(cominfoMeasureOtherwaste, UpdateGroup.class);
        cominfoMeasureOtherwaste.setUpdatedate(DateUtils.getStringDate());
        cominfoMeasureOtherwasteService.updateById(cominfoMeasureOtherwaste);

        return R.ok();
    }

    /**
     * 删除其他治理设施
     */
    @DeleteMapping
    @ApiOperation("删除其他治理设施")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "删除其他治理设施")
    public R delete(@RequestBody String[] pids){
        cominfoMeasureOtherwasteService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
