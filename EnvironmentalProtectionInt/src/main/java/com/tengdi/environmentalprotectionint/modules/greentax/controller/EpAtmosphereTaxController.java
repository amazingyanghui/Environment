package com.tengdi.environmentalprotectionint.modules.greentax.controller;

import com.tengdi.core.utils.*;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpAtmosphereTaxEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpAtmosphereTaxService;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPortinfoEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorPortinfoService;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 大气水排放税上报
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 09:50:05
 */
@RestController
@RequestMapping("market/epatmospheretax" )
@Api(tags = "大气水排放税上报" )
public class EpAtmosphereTaxController extends BaseController {
    @Autowired
    private EpAtmosphereTaxService epAtmosphereTaxService;
    @Autowired
    private OnlineMonitorPortinfoService onlineMonitorPortinfoService;


    /**
     * 信息
     */
    @GetMapping("/{id}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("id" ) String id) {
            EpAtmosphereTaxEntity epAtmosphereTax = epAtmosphereTaxService.selectById(id);

        return R.ok().put("epAtmosphereTax" , epAtmosphereTax);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody EpAtmosphereTaxEntity epAtmosphereTax) {
        ValidatorUtils.validateEntity(epAtmosphereTax, AddGroup.class);
        epAtmosphereTax.setStatus("0");
        epAtmosphereTax.setCreateDate(DateUtils.getDate());
        epAtmosphereTaxService.insert(epAtmosphereTax);
        Map<String,Object> map =new HashMap();
        map.put("computingMethod",epAtmosphereTax.getComputingMethod());
        map.put("pid",epAtmosphereTax.getDischargeId());
        epAtmosphereTaxService.updateOnlineMonitorPortinfoEntity(map);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody EpAtmosphereTaxEntity epAtmosphereTax) {
        ValidatorUtils.validateEntity(epAtmosphereTax, UpdateGroup.class);
        epAtmosphereTaxService.updateById(epAtmosphereTax);
        Map<String,Object> map =new HashMap();
        map.put("computingMethod",epAtmosphereTax.getComputingMethod());
        map.put("pid",epAtmosphereTax.getDischargeId());
        epAtmosphereTaxService.updateOnlineMonitorPortinfoEntity(map);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]ids) {
            epAtmosphereTaxService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     *
    * @param
    * @return
    */
    @GetMapping
    @ApiOperation("列表" )
    public String queryTableData(@RequestParam Map<String, Object> params) {
        PageUtils page = epAtmosphereTaxService.queryTableData(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }
    /**
     * 提交、审核
     */
    @PostMapping("/submitAndAudit")
    @ApiOperation("提交、审核" )
    public R submitAndAudit(@RequestBody EpAtmosphereTaxEntity epAtmosphereTax) {
        epAtmosphereTaxService.updateById(epAtmosphereTax);
        return R.ok();
    }
}
