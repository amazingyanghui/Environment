package com.tengdi.environmentalprotectionint.modules.greentax.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteClientEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpSolidWasteClientService;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 固体废物基础信息采集-
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 10:20:06
 */
@RestController
@RequestMapping("market/epsolidwasteclient" )
@Api(tags = "固体废物基础信息采集-" )
public class EpSolidWasteClientController extends BaseController {
    @Autowired
    private EpSolidWasteClientService epSolidWasteClientService;


    /**
     * 信息
     */
    @GetMapping("/{id}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("id" ) String id) {
            EpSolidWasteClientEntity epSolidWasteClient = epSolidWasteClientService.selectById(id);

        return R.ok().put("epSolidWasteClient" , epSolidWasteClient);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody EpSolidWasteClientEntity epSolidWasteClient) {
        ValidatorUtils.validateEntity(epSolidWasteClient, AddGroup.class);
//            epSolidWasteClient.setCreatedate(DateUtils.getDate());
            epSolidWasteClientService.insert(epSolidWasteClient);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody EpSolidWasteClientEntity epSolidWasteClient) {
        ValidatorUtils.validateEntity(epSolidWasteClient, UpdateGroup.class);
//            epSolidWasteClient.setUpdatedate(DateUtils.getDate());
            epSolidWasteClientService.updateById(epSolidWasteClient);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]ids) {
            epSolidWasteClientService.deleteBatchIds(Arrays.asList(ids));

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
//            criterias.setTable("ep_solid_waste_client" );
//        }
//        PageUtils page = epSolidWasteClientService.queryTableData(criterias);
//        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
//    }

}
