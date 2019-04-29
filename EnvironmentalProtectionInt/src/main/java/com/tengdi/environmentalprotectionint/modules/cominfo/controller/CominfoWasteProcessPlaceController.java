package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.utils.QueryCriterias;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoWasteProcessPlaceEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoWasteProcessPlaceService;
import com.tengdi.core.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * (固废,危险)废物处理场所
 *
 * @author tengdi
 * @email 
 * @date 2019-03-07 16:51:37
 */
@RestController
@RequestMapping("comInfo/cominfowasteprocessplace" )
@Api(tags = "(固废,危险)废物处理场所" )
public class CominfoWasteProcessPlaceController extends BaseController {
    @Autowired
    private CominfoWasteProcessPlaceService cominfoWasteProcessPlaceService;

    /**
     * @param params
     * @return
     */
    @GetMapping("/queryPage")
    @ApiOperation("列表" )
    public String queryPage(@RequestParam Map<String,Object> params) {
        PageUtils page = cominfoWasteProcessPlaceService.queryPage(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<CominfoWasteProcessPlaceEntity> list= cominfoWasteProcessPlaceService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("pid" ) String pid) {
            CominfoWasteProcessPlaceEntity cominfoWasteProcessPlace = cominfoWasteProcessPlaceService.selectById(pid);

        return R.ok().put("cominfoWasteProcessPlace" , cominfoWasteProcessPlace);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody CominfoWasteProcessPlaceEntity cominfoWasteProcessPlace) {
        ValidatorUtils.validateEntity(cominfoWasteProcessPlace, AddGroup.class);
        cominfoWasteProcessPlace.setCreatedate(DateUtils.getStringDate());
        cominfoWasteProcessPlace.setUpdatedate(DateUtils.getStringDate());
        cominfoWasteProcessPlaceService.insert(cominfoWasteProcessPlace);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody CominfoWasteProcessPlaceEntity cominfoWasteProcessPlace) {
        ValidatorUtils.validateEntity(cominfoWasteProcessPlace, UpdateGroup.class);
            cominfoWasteProcessPlace.setUpdatedate(DateUtils.getStringDate());
            cominfoWasteProcessPlaceService.updateById(cominfoWasteProcessPlace);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]pids) {
            cominfoWasteProcessPlaceService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

    /**
     * 废物处理场所名称下拉框
     */
    @GetMapping("/selectList/{wasteCategoryType}/{cid}")
    @ApiOperation("废物处理场所名称下拉框")
    public String selectList(@PathVariable("wasteCategoryType") String wasteCategoryType,@PathVariable("cid") String cid){
        List<SelectEntity> list = cominfoWasteProcessPlaceService.list(wasteCategoryType,cid);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
    * @param criterias
    * @return
    */
    @GetMapping
    @ApiOperation("列表" )
    public String queryTableData(QueryCriterias criterias) {
        if (StringUtils.isEmpty(criterias.getTable())) {
            criterias.setTable("cominfo_waste_process_place" );
        }
        PageUtils page = cominfoWasteProcessPlaceService.queryTableData(criterias);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

}
