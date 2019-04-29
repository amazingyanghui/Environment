package com.tengdi.environmentalprotectionint.modules.emergency.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.tengdi.environmentalprotectionint.modules.emergency.entity.RiskPreventionMeasuresEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.RiskPreventionMeasuresService;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;

import com.tengdi.core.utils.PageUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 风险防范措施
 *
 * @author tengdi
 * @email
 * @date 2019-03-13 10:36:05
 */
@RestController
@RequestMapping("emergency/riskpreventionmeasures")
@Api(tags = "风险防范措施")
public class RiskPreventionMeasuresController extends BaseController {
    @Autowired
    private RiskPreventionMeasuresService riskPreventionMeasuresService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params) {
        PageUtils page = riskPreventionMeasuresService.queryPageSql(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }
    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<RiskPreventionMeasuresEntity> list= riskPreventionMeasuresService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid) {
        RiskPreventionMeasuresEntity riskPreventionMeasures = riskPreventionMeasuresService.entityById(pid);

        return R.ok().put("riskPreventionMeasures", riskPreventionMeasures);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody RiskPreventionMeasuresEntity riskPreventionMeasures) {
        ValidatorUtils.validateEntity(riskPreventionMeasures, AddGroup.class);
        riskPreventionMeasures.setCreatedate(DateUtils.getDate());
        riskPreventionMeasuresService.insert(riskPreventionMeasures);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody RiskPreventionMeasuresEntity riskPreventionMeasures) {
        ValidatorUtils.validateEntity(riskPreventionMeasures, UpdateGroup.class);
        riskPreventionMeasures.setUpdatedate(DateUtils.getDate());
        riskPreventionMeasuresService.updateById(riskPreventionMeasures);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids) {
        riskPreventionMeasuresService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
