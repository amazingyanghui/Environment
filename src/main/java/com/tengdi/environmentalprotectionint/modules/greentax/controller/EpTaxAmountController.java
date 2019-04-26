package com.tengdi.environmentalprotectionint.modules.greentax.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;

import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpTaxAmountEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpTaxAmountService;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 环境保护税税目税额表
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:19:00
 */
@RestController
@RequestMapping("market/eptaxamount")
@Api(tags="环境保护税税目税额表")
public class EpTaxAmountController extends BaseController {
    @Autowired
    private EpTaxAmountService epTaxAmountService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = epTaxAmountService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pollutant}")
    @ApiOperation("信息")
    public R info(@PathVariable("pollutant") String pollutant){
			EpTaxAmountEntity epTaxAmount = epTaxAmountService.selectById(pollutant);

        return R.ok().put("epTaxAmount", epTaxAmount);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody EpTaxAmountEntity epTaxAmount){
        ValidatorUtils.validateEntity(epTaxAmount, AddGroup.class);
			epTaxAmountService.insert(epTaxAmount);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody EpTaxAmountEntity epTaxAmount){
        ValidatorUtils.validateEntity(epTaxAmount, UpdateGroup.class);
			epTaxAmountService.updateById(epTaxAmount);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pollutants){
			epTaxAmountService.deleteBatchIds(Arrays.asList(pollutants));

        return R.ok();
    }

}
