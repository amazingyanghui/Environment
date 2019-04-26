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
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoCentralizedSewageEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoCentralizedSewageService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 集中式污水处理厂运行情况
 *
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:38:07
 */
@RestController
@RequestMapping("comInfo/cominfocentralizedsewage" )
@Api(tags = "集中式污水处理厂运行情况" )
public class CominfoCentralizedSewageController extends BaseController {
    @Autowired
    private CominfoCentralizedSewageService cominfoCentralizedSewageService;


    /**
     * 信息
     */
    @GetMapping("/{pid}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("pid" ) String pid) {
            CominfoCentralizedSewageEntity cominfoCentralizedSewage = cominfoCentralizedSewageService.selectById(pid);

        return R.ok().put("cominfoCentralizedSewage" , cominfoCentralizedSewage);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody CominfoCentralizedSewageEntity cominfoCentralizedSewage) {
        ValidatorUtils.validateEntity(cominfoCentralizedSewage, AddGroup.class);
           // cominfoCentralizedSewage.setCreatedate(DateUtils.getDate());
            cominfoCentralizedSewageService.insert(cominfoCentralizedSewage);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody CominfoCentralizedSewageEntity cominfoCentralizedSewage) {
        ValidatorUtils.validateEntity(cominfoCentralizedSewage, UpdateGroup.class);
           // cominfoCentralizedSewage.setUpdatedate(DateUtils.getDate());
            cominfoCentralizedSewageService.updateById(cominfoCentralizedSewage);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]pids) {
            cominfoCentralizedSewageService.deleteBatchIds(Arrays.asList(pids));

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
//            criterias.setTable("cominfo_centralized_sewage" );
//        }
//        PageUtils page = cominfoCentralizedSewageService.queryTableData(criterias);
//        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
//    }

}
