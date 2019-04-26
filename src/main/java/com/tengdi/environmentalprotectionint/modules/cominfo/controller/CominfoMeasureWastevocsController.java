package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureWastevocsEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoMeasureWastevocsService;
import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * vocs治理设施
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:10
 */
@RestController
@RequestMapping("market/cominfomeasurewastevocs")
@Api(tags="vocs治理设施")
public class CominfoMeasureWastevocsController extends BaseController{
    @Autowired
    private CominfoMeasureWastevocsService cominfoMeasureWastevocsService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoMeasureWastevocsService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<CominfoMeasureWastevocsEntity> list= cominfoMeasureWastevocsService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        CominfoMeasureWastevocsEntity cominfoMeasureWastevocs = cominfoMeasureWastevocsService.selectById(pid);

        return R.ok().put("cominfoMeasureWastewater", cominfoMeasureWastevocs);
    }

    /**
     * 根据公司id获取vocs治理设施
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取vocs治理设施")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<CominfoMeasureWastevocsEntity> list = cominfoMeasureWastevocsService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存vocs治理设施
     */
    @PostMapping
    @ApiOperation("保存vocs治理设施")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存vocs治理设施")
    public R save(@RequestBody CominfoMeasureWastevocsEntity cominfoMeasureWastevocs){
        ValidatorUtils.validateEntity(cominfoMeasureWastevocs, AddGroup.class);
        cominfoMeasureWastevocs.setCreatedate(DateUtils.getStringDate());
        cominfoMeasureWastevocs.setUpdatedate(DateUtils.getStringDate());
        cominfoMeasureWastevocsService.insert(cominfoMeasureWastevocs);

        return R.ok();
    }

    /**
     * 修改vocs治理设施
     */
    @PutMapping
    @ApiOperation("修改vocs治理设施")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改vocs治理设施")
    public R update(@RequestBody CominfoMeasureWastevocsEntity cominfoMeasureWastevocs){
        ValidatorUtils.validateEntity(cominfoMeasureWastevocs, UpdateGroup.class);
        cominfoMeasureWastevocs.setUpdatedate(DateUtils.getStringDate());
        cominfoMeasureWastevocsService.updateById(cominfoMeasureWastevocs);

        return R.ok();
    }

    /**
     * 删除vocs治理设施
     */
    @DeleteMapping
    @ApiOperation("删除vocs治理设施")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "删除vocs治理设施")
    public R delete(@RequestBody String[] pids){
        cominfoMeasureWastevocsService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
