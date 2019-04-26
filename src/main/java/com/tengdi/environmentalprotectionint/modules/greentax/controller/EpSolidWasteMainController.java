package com.tengdi.environmentalprotectionint.modules.greentax.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteMainEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpSolidWasteMainService;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 固体废物基础信息采集主表
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 10:20:18
 */
@RestController
@RequestMapping("market/epsolidwastemain" )
@Api(tags = "固体废物基础信息采集主表" )
public class EpSolidWasteMainController extends BaseController {
    @Autowired
    private EpSolidWasteMainService epSolidWasteMainService;


    /**
     * 信息
     */
    @GetMapping("/{id}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("id" ) String id) {
            EpSolidWasteMainEntity epSolidWasteMain = epSolidWasteMainService.selectById(id);

        return R.ok().put("epSolidWasteMain" , epSolidWasteMain);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody EpSolidWasteMainEntity epSolidWasteMain) {
        ValidatorUtils.validateEntity(epSolidWasteMain, AddGroup.class);
//            epSolidWasteMain.setCreatedate(DateUtils.getDate());
            epSolidWasteMainService.insert(epSolidWasteMain);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody EpSolidWasteMainEntity epSolidWasteMain) {
        ValidatorUtils.validateEntity(epSolidWasteMain, UpdateGroup.class);
//            epSolidWasteMain.setUpdatedate(DateUtils.getDate());
            epSolidWasteMainService.updateById(epSolidWasteMain);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]ids) {
            epSolidWasteMainService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
    * @param criterias
    * @return
    */
//    @GetMapping
//    @ApiOperation("列表" )
//    public String queryTableData(QueryCriterias criterias) {
//        if (StringUtils.isEmpty(criterias.getTable())) {
//            criterias.setTable("ep_solid_waste_main" );
//        }
//        PageUtils page = epSolidWasteMainService.queryTableData(criterias);
//        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
//    }

}
