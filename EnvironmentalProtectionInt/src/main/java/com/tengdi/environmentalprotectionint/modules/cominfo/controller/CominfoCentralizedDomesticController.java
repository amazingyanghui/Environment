package com.tengdi.environmentalprotectionint.modules.cominfo.controller;
import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoCentralizedDomesticEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoCentralizedDomesticService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 生活垃圾集中处置厂运行情况
 *
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:38:04
 */
@RestController
@RequestMapping("comInfo/cominfocentralizeddomestic" )
@Api(tags = "生活垃圾集中处置厂运行情况" )
public class CominfoCentralizedDomesticController extends BaseController {
    @Autowired
    private CominfoCentralizedDomesticService cominfoCentralizedDomesticService;


    /**
     * 信息
     */
    @GetMapping("/{pid}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("pid" ) String pid) {
            CominfoCentralizedDomesticEntity cominfoCentralizedDomestic = cominfoCentralizedDomesticService.selectById(pid);

        return R.ok().put("cominfoCentralizedDomestic" , cominfoCentralizedDomestic);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody CominfoCentralizedDomesticEntity cominfoCentralizedDomestic) {
        ValidatorUtils.validateEntity(cominfoCentralizedDomestic, AddGroup.class);
            //cominfoCentralizedDomestic.setCreatedate(DateUtils.getDate());
            cominfoCentralizedDomesticService.insert(cominfoCentralizedDomestic);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody CominfoCentralizedDomesticEntity cominfoCentralizedDomestic) {
        ValidatorUtils.validateEntity(cominfoCentralizedDomestic, UpdateGroup.class);
            //cominfoCentralizedDomestic.setUpdatedate(DateUtils.getDate());
            cominfoCentralizedDomesticService.updateById(cominfoCentralizedDomestic);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]pids) {
            cominfoCentralizedDomesticService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoCentralizedDomesticService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

//    /**
//    * @param criterias
//    * @return
//    */
//    @GetMapping
//    @ApiOperation("列表" )
//    public String queryTableData(QueryCriterias criterias) {
//        if (StringUtils.isEmpty(criterias.getTable())) {
//            criterias.setTable("cominfo_centralized_domestic" );
//        }
//        PageUtils page = cominfoCentralizedDomesticService.queryTableData(criterias);
//        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
//    }

}
