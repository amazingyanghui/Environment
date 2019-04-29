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
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoCentralizedHazardouswasteEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoCentralizedHazardouswasteService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 危险废物集中处置厂运行情况
 *
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:37:58
 */
@RestController
@RequestMapping("comInfo/cominfocentralizedhazardouswaste" )
@Api(tags = "危险废物集中处置厂运行情况" )
public class CominfoCentralizedHazardouswasteController extends BaseController {
    @Autowired
    private CominfoCentralizedHazardouswasteService cominfoCentralizedHazardouswasteService;


    /**
     * 信息
     */
    @GetMapping("/{pid}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("pid" ) String pid) {
            CominfoCentralizedHazardouswasteEntity cominfoCentralizedHazardouswaste = cominfoCentralizedHazardouswasteService.selectById(pid);

        return R.ok().put("cominfoCentralizedHazardouswaste" , cominfoCentralizedHazardouswaste);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody CominfoCentralizedHazardouswasteEntity cominfoCentralizedHazardouswaste) {
        ValidatorUtils.validateEntity(cominfoCentralizedHazardouswaste, AddGroup.class);
            //cominfoCentralizedHazardouswaste.setCreatedate(DateUtils.getDate());
            cominfoCentralizedHazardouswasteService.insert(cominfoCentralizedHazardouswaste);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody CominfoCentralizedHazardouswasteEntity cominfoCentralizedHazardouswaste) {
        ValidatorUtils.validateEntity(cominfoCentralizedHazardouswaste, UpdateGroup.class);
            //cominfoCentralizedHazardouswaste.setUpdatedate(DateUtils.getDate());
            cominfoCentralizedHazardouswasteService.updateById(cominfoCentralizedHazardouswaste);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]pids) {
            cominfoCentralizedHazardouswasteService.deleteBatchIds(Arrays.asList(pids));

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
//            criterias.setTable("cominfo_centralized_hazardouswaste" );
//        }
//        PageUtils page = cominfoCentralizedHazardouswasteService.queryTableData(criterias);
//        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
//    }

}
