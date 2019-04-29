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
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoMeasureWastewaterEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoMeasureWastewaterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 废水治理设施
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:05
 */
@RestController
@RequestMapping("market/cominfomeasurewastewater")
@Api(tags="废水治理设施")
public class CominfoMeasureWastewaterController extends BaseController{
    @Autowired
    private CominfoMeasureWastewaterService cominfoMeasureWastewaterService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoMeasureWastewaterService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<CominfoMeasureWastewaterEntity> list= cominfoMeasureWastewaterService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        CominfoMeasureWastewaterEntity cominfoMeasureWastewater = cominfoMeasureWastewaterService.selectById(pid);
        if(cominfoMeasureWastewater!=null){
            if(StringUtils.isNotBlank(cominfoMeasureWastewater.getRemovalOfMaterial())){
                String industryidstemp=cominfoMeasureWastewaterService.getIndustry(cominfoMeasureWastewater.getRemovalOfMaterial());
                if(StringUtils.isNotBlank(industryidstemp)){
                    cominfoMeasureWastewater.setRemovalOfMaterialName(industryidstemp);
                }
            }
        }
        return R.ok().put("cominfoMeasureWastewater", cominfoMeasureWastewater);
    }

    /**
     * 根据公司id获取废水治理设施
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取废水治理设施")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<CominfoMeasureWastewaterEntity> list = cominfoMeasureWastewaterService.dataById(cid);
        list=cominfoMeasureWastewaterService.getList(list);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存废水治理设施
     */
    @PostMapping
    @ApiOperation("保存废水治理设施")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存废水治理设施")
    public R save(@RequestBody CominfoMeasureWastewaterEntity cominfoMeasureWastewater){
        ValidatorUtils.validateEntity(cominfoMeasureWastewater, AddGroup.class);
        cominfoMeasureWastewater.setCreatedate(DateUtils.getStringDate());
        cominfoMeasureWastewater.setUpdatedate(DateUtils.getStringDate());
        cominfoMeasureWastewaterService.insert(cominfoMeasureWastewater);

        return R.ok();
    }

    /**
     * 修改废水治理设施
     */
    @PutMapping
    @ApiOperation("修改废水治理设施")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改废水治理设施")
    public R update(@RequestBody CominfoMeasureWastewaterEntity cominfoMeasureWastewater){
        ValidatorUtils.validateEntity(cominfoMeasureWastewater, UpdateGroup.class);
        cominfoMeasureWastewater.setUpdatedate(DateUtils.getStringDate());
        cominfoMeasureWastewaterService.updateById(cominfoMeasureWastewater);

        return R.ok();
    }

    /**
     * 删除废水治理设施
     */
    @DeleteMapping
    @ApiOperation("删除废水治理设施")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "删除废水治理设施")
    public R delete(@RequestBody String[] pids){
        cominfoMeasureWastewaterService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
