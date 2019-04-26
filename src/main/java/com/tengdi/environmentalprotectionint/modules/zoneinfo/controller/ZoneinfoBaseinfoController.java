package com.tengdi.environmentalprotectionint.modules.zoneinfo.controller;
import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.zoneinfo.entity.ZoneinfoBaseinfoEntity ;
import com.tengdi.environmentalprotectionint.modules.zoneinfo.service.ZoneinfoBaseinfoService ;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 园区环境管理信息
 *
 * @author tengdi
 * @email 
 * @date 2019-03-11 09:56:11
 */
@RestController
@RequestMapping("zoneinfo/zoneinfobaseinfo" )
@Api(tags = "园区环境管理信息" )
public class ZoneinfoBaseinfoController extends BaseController {
    @Autowired
    private ZoneinfoBaseinfoService zoneinfoBaseinfoService;


    /**
     * 信息
     */
    @GetMapping("/{pid}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("pid" ) String pid) {
            ZoneinfoBaseinfoEntity zoneinfoBaseinfo = zoneinfoBaseinfoService.selectById(pid);

        return R.ok().put("zoneinfoBaseinfo" , zoneinfoBaseinfo);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody ZoneinfoBaseinfoEntity zoneinfoBaseinfo) {
        ValidatorUtils.validateEntity(zoneinfoBaseinfo, AddGroup.class);
            //zoneinfoBaseinfo.setCreatedate(DateUtils.getDate());
            zoneinfoBaseinfoService.insert(zoneinfoBaseinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody ZoneinfoBaseinfoEntity zoneinfoBaseinfo) {
        ValidatorUtils.validateEntity(zoneinfoBaseinfo, UpdateGroup.class);
          //  zoneinfoBaseinfo.setUpdatedate(DateUtils.getDate());
            zoneinfoBaseinfoService.updateById(zoneinfoBaseinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]pids) {
            zoneinfoBaseinfoService.deleteBatchIds(Arrays.asList(pids));

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
//            criterias.setTable("zoneinfo_baseinfo" );
//        }
//       PageUtils page = zoneinfoBaseinfoService.queryTableData(criterias);
//        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
//    }


    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = zoneinfoBaseinfoService.queryTableData(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }
}
