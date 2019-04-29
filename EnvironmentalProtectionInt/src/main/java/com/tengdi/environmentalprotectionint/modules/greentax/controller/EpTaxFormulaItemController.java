package com.tengdi.environmentalprotectionint.modules.greentax.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;

import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpTaxFormulaItemEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpTaxFormulaItemService;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 环保税公式的公式项
 *
 * @author tengdi
 * @email 
 * @date 2019-03-05 11:19:12
 */
@RestController
@RequestMapping("market/eptaxformulaitem")
@Api(tags="环保税公式的公式项")
public class EpTaxFormulaItemController extends BaseController {
    @Autowired
    private EpTaxFormulaItemService epTaxFormulaItemService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = epTaxFormulaItemService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{id}")
    @ApiOperation("信息")
    public R info(@PathVariable("id") String id){
			EpTaxFormulaItemEntity epTaxFormulaItem = epTaxFormulaItemService.selectById(id);

        return R.ok().put("epTaxFormulaItem", epTaxFormulaItem);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody EpTaxFormulaItemEntity epTaxFormulaItem){
        ValidatorUtils.validateEntity(epTaxFormulaItem, AddGroup.class);
			epTaxFormulaItemService.insert(epTaxFormulaItem);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody EpTaxFormulaItemEntity epTaxFormulaItem){
        ValidatorUtils.validateEntity(epTaxFormulaItem, UpdateGroup.class);
			epTaxFormulaItemService.updateById(epTaxFormulaItem);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] ids){
			epTaxFormulaItemService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
