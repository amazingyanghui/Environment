package com.tengdi.environmentalprotectionint.modules.online.controller;
import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.utils.QueryCriterias;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;

import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.online.entity.EnterprisesDischargeCoefficientEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.EnterprisesDischargeCoefficientService;
import com.tengdi.core.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 工业企业污染物产排污系数核算信息
 *
 * @author tengdi
 * @email 
 * @date 2019-03-08 14:08:30
 */
@RestController
@RequestMapping("comInfo/enterprisesdischargecoefficient" )
@Api(tags = "工业企业污染物产排污系数核算信息" )
public class EnterprisesDischargeCoefficientController extends BaseController {
    @Autowired
    private EnterprisesDischargeCoefficientService enterprisesDischargeCoefficientService;

    /**
     * @param params
     * @return
     */
    @GetMapping("/queryPage")
    @ApiOperation("列表" )
    public String queryPage(@RequestParam Map<String,Object> params) {
        PageUtils page = enterprisesDischargeCoefficientService.queryPage(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }
    /**
     * 信息
     */
    @GetMapping("/{pid}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("pid" ) String pid) {
            EnterprisesDischargeCoefficientEntity enterprisesDischargeCoefficient = enterprisesDischargeCoefficientService.selectById(pid);

        return R.ok().put("enterprisesDischargeCoefficient" , enterprisesDischargeCoefficient);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody EnterprisesDischargeCoefficientEntity enterprisesDischargeCoefficient) {
        ValidatorUtils.validateEntity(enterprisesDischargeCoefficient, AddGroup.class);
        enterprisesDischargeCoefficient.setCreatedate(DateUtils.getStringDate());
        enterprisesDischargeCoefficient.setUpdatedate(DateUtils.getStringDate());
        enterprisesDischargeCoefficientService.insert(enterprisesDischargeCoefficient);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody EnterprisesDischargeCoefficientEntity enterprisesDischargeCoefficient) {
        ValidatorUtils.validateEntity(enterprisesDischargeCoefficient, UpdateGroup.class);
            enterprisesDischargeCoefficient.setUpdatedate(DateUtils.getStringDate());
            enterprisesDischargeCoefficientService.updateById(enterprisesDischargeCoefficient);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]pids) {
            enterprisesDischargeCoefficientService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

    /**
    * @param criterias
    * @return
    */
    @GetMapping
    @ApiOperation("列表" )
    public String queryTableData(QueryCriterias criterias) {
        if (StringUtils.isEmpty(criterias.getTable())) {
            criterias.setTable("enterprises_discharge_coefficient" );
        }
        PageUtils page = enterprisesDischargeCoefficientService.queryTableData(criterias);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

}
