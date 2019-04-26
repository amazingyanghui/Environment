package com.tengdi.environmentalprotectionint.modules.greentax.controller;

import com.tengdi.core.constant.CommonConstant;
import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpTaxFormulaEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpTaxFormulaService;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 环保税公式，根据行业类别和污染物来适配所用公式
 *
 * @author tengdi
 * @email 
 * @date 2019-03-05 11:19:08
 */
@RestController
@RequestMapping("greentax/eptaxformula")
@Api(tags="环保税公式，根据行业类别和污染物来适配所用公式")
public class EpTaxFormulaController extends BaseController {
    @Autowired
    private EpTaxFormulaService epTaxFormulaService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = epTaxFormulaService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{id}")
    @ApiOperation("信息")
    public R info(@PathVariable("id") String id){
			EpTaxFormulaEntity epTaxFormula = epTaxFormulaService.selectById(id);

        return R.ok().put("epTaxFormula", epTaxFormula);
    }


    /**
     * 根据行业类别和污染物查找对应排放量和污染当量计算公式
     * @param industryCategory
     * @param contaminant
     * @return
     */
    @GetMapping("/{industry}/{contaminant}")
    @ApiOperation("查找对应排放量和污染当量计算公式")
    public String infoByParam(@PathVariable("industry") String industryCategory,@PathVariable("contaminant") String contaminant){
        JSONObject root = new JSONObject();
        Map<String,Object> params = new HashMap<>();
//        params.put("industryCategory",industryCategory);
//        params.put("contaminant",contaminant);
        params.put("industryCategory","001");
        params.put("contaminant","二氧化硫");
        EpTaxFormulaEntity epTaxFormula = epTaxFormulaService.queryFormula(params);
        root.put("code","1");
        String msg = "";
        if(null == epTaxFormula){
            msg = "查询公式失败!";
        }else if(null == epTaxFormula.getEpTaxFormulaItemEntityList() || epTaxFormula.getEpTaxFormulaItemEntityList().size()==0){
            msg = "查询公式项失败!";
        } else if(null == epTaxFormula.getEpTaxAmountEntity()) {
            msg = "查询污染当量计算系数失败!";
        } else {
            root.put("code",CommonConstant.HTTP_STATUS_OK);
            root.put("epTaxFormula", epTaxFormula);
        }
        root.put("msg",msg);
        return root.toString();
    }




    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody EpTaxFormulaEntity epTaxFormula){
        ValidatorUtils.validateEntity(epTaxFormula, AddGroup.class);
			epTaxFormulaService.insert(epTaxFormula);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody EpTaxFormulaEntity epTaxFormula){
        ValidatorUtils.validateEntity(epTaxFormula, UpdateGroup.class);
			epTaxFormulaService.updateById(epTaxFormula);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] ids){
			epTaxFormulaService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
