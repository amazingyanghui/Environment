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
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureWastegasEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoMeasureWastegasService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 废气治理设施
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:10
 */
@RestController
@RequestMapping("market/cominfomeasurewastegas")
@Api(tags="废气治理设施")
public class CominfoMeasureWastegasController extends BaseController{
    @Autowired
    private CominfoMeasureWastegasService cominfoMeasureWastegasService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoMeasureWastegasService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<CominfoMeasureWastegasEntity> list= cominfoMeasureWastegasService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        CominfoMeasureWastegasEntity cominfoMeasureWastegas = cominfoMeasureWastegasService.selectById(pid);

        return R.ok().put("cominfoMeasureWastewater", cominfoMeasureWastegas);
    }

    /**
     * 根据公司id获取废气治理设施
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取废气治理设施")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<CominfoMeasureWastegasEntity> list = cominfoMeasureWastegasService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存废气治理设施
     */
    @PostMapping
    @ApiOperation("保存废气治理设施")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存废气治理设施")
    public R save(@RequestBody CominfoMeasureWastegasEntity cominfoMeasureWastegas){
        ValidatorUtils.validateEntity(cominfoMeasureWastegas, AddGroup.class);
        cominfoMeasureWastegas.setCreatedate(DateUtils.getStringDate());
        cominfoMeasureWastegas.setUpdatedate(DateUtils.getStringDate());
        cominfoMeasureWastegasService.insert(cominfoMeasureWastegas);

        return R.ok();
    }

    /**
     * 修改废气治理设施
     */
    @PutMapping
    @ApiOperation("修改废气治理设施")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改废气治理设施")
    public R update(@RequestBody CominfoMeasureWastegasEntity cominfoMeasureWastegas){
        ValidatorUtils.validateEntity(cominfoMeasureWastegas, UpdateGroup.class);
        cominfoMeasureWastegas.setUpdatedate(DateUtils.getStringDate());
        cominfoMeasureWastegasService.updateById(cominfoMeasureWastegas);

        return R.ok();
    }

    /**
     * 删除废气治理设施
     */
    @DeleteMapping
    @ApiOperation("删除废气治理设施")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "删除废气治理设施")
    public R delete(@RequestBody String[] pids){
        cominfoMeasureWastegasService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
