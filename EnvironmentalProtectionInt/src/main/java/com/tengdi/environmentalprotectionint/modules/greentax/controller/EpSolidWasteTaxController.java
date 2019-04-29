package com.tengdi.environmentalprotectionint.modules.greentax.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpNoiseTaxEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteTaxEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpSolidWasteTaxService;
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
 * 固体废物环保税上报
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:52:02
 */
@RestController
@RequestMapping("market/epsolidwastetax" )
@Api(tags = "固体废物环保税上报" )
public class EpSolidWasteTaxController extends BaseController {
    @Autowired
    private EpSolidWasteTaxService epSolidWasteTaxService;


    /**
     * 信息
     */
    @GetMapping("/{id}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("id" ) String id) {
            EpSolidWasteTaxEntity epSolidWasteTax = epSolidWasteTaxService.selectById(id);

        return R.ok().put("epSolidWasteTax" , epSolidWasteTax);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody EpSolidWasteTaxEntity epSolidWasteTax) {
        ValidatorUtils.validateEntity(epSolidWasteTax, AddGroup.class);
        epSolidWasteTax.setStatus("0");
        epSolidWasteTax.setCreateDate(DateUtils.getDate());
        epSolidWasteTaxService.insert(epSolidWasteTax);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody EpSolidWasteTaxEntity epSolidWasteTax) {
        ValidatorUtils.validateEntity(epSolidWasteTax, UpdateGroup.class);
            epSolidWasteTaxService.updateById(epSolidWasteTax);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]ids) {
            epSolidWasteTaxService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
    * @param
    * @return
    */
    @GetMapping
    @ApiOperation("列表" )
    public String queryTableData(@RequestParam Map<String, Object> params) {
        PageUtils page = epSolidWasteTaxService.queryTableData(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }
    /**
     * 提交、审核
     */
    @PostMapping("/submitAndAudit")
    @ApiOperation("提交、审核" )
    public R submitAndAudit(@RequestBody EpSolidWasteTaxEntity epSolidWasteTax) {
        epSolidWasteTaxService.updateById(epSolidWasteTax);
        return R.ok();
    }
}
