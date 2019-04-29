package com.tengdi.environmentalprotectionint.modules.cominfo.controller;
import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;

import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.OrganicLiquidStorageLoadEntity ;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.OrganicLiquidStorageLoadService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 工业企业有机液体储罐、装载信息
 *
 * @author tengdi
 * @email 
 * @date 2019-03-07 16:15:35
 */
@RestController
@RequestMapping("cominfo/organicliquidstorageload" )
@Api(tags = "工业企业有机液体储罐、装载信息" )
public class OrganicLiquidStorageLoadController extends BaseController {
    @Autowired
    private OrganicLiquidStorageLoadService organicLiquidStorageLoadService;


    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = organicLiquidStorageLoadService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("pid" ) String pid) {
            OrganicLiquidStorageLoadEntity organicLiquidStorageLoad = organicLiquidStorageLoadService.selectById(pid);

        return R.ok().put("organicLiquidStorageLoad" , organicLiquidStorageLoad);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody OrganicLiquidStorageLoadEntity organicLiquidStorageLoad) {
        ValidatorUtils.validateEntity(organicLiquidStorageLoad, AddGroup.class);
          //  organicLiquidStorageLoad.setCreatedate(DateUtils.getDate());
            organicLiquidStorageLoadService.insert(organicLiquidStorageLoad);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody OrganicLiquidStorageLoadEntity organicLiquidStorageLoad) {
        ValidatorUtils.validateEntity(organicLiquidStorageLoad, UpdateGroup.class);
          //  organicLiquidStorageLoad.setUpdatedate(DateUtils.getDate());
            organicLiquidStorageLoadService.updateById(organicLiquidStorageLoad);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]pids) {
            organicLiquidStorageLoadService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

//    /**
//    * @param criterias
//    * @return
//    */
//    @GetMapping
//    @ApiOperation("列表" )
//    public String queryTableData(QueryCriterias criterias) {
//        if (StringUtils.isEmpty(criterias.getTable())) {
//            criterias.setTable("organic_liquid_storage_load" );
//        }
//        PageUtils page = organicLiquidStorageLoadService.queryTableData(criterias);
//        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
//    }

}
