package com.tengdi.environmentalprotectionint.modules.greentax.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpAtmosphereTaxEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpNoiseTaxEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpNoiseTaxService;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 噪音环保税上报
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:51:49
 */
@RestController
@RequestMapping("market/epnoisetax" )
@Api(tags = "噪音环保税上报" )
public class EpNoiseTaxController extends BaseController {
    @Autowired
    private EpNoiseTaxService epNoiseTaxService;


    /**
     * 信息
     */
    @GetMapping("/{id}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("id" ) String id) {
            EpNoiseTaxEntity epNoiseTax = epNoiseTaxService.selectById(id);

        return R.ok().put("epNoiseTax" , epNoiseTax);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody EpNoiseTaxEntity epNoiseTax) {
        ValidatorUtils.validateEntity(epNoiseTax, AddGroup.class);
        epNoiseTax.setStatus("0");
        epNoiseTax.setCreateDate(DateUtils.getDate());
        epNoiseTaxService.insert(epNoiseTax);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody EpNoiseTaxEntity epNoiseTax) {
        ValidatorUtils.validateEntity(epNoiseTax, UpdateGroup.class);
            epNoiseTaxService.updateById(epNoiseTax);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]ids) {
            epNoiseTaxService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
    * @param
    * @return
    */
    @GetMapping
    @ApiOperation("列表" )
    public String queryTableData(@RequestParam Map<String, Object> params) {
        PageUtils page = epNoiseTaxService.queryTableData(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }
    /**
     * 提交、审核
     */
    @PostMapping("/submitAndAudit")
    @ApiOperation("提交、审核" )
    public R submitAndAudit(@RequestBody EpNoiseTaxEntity epNoiseTax) {
        epNoiseTaxService.updateById(epNoiseTax);
        return R.ok();
    }
}
