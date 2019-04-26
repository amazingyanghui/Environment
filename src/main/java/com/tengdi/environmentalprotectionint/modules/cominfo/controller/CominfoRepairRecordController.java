package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoRepairRecordEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoRepairRecordService;
import com.tengdi.core.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 治理设施维护记录表
 *
 * @author tengdi
 * @email 
 * @date 2018-10-19 15:19:06
 */
@RestController
@RequestMapping("cominfo/cominforepairrecord")
@Api(tags="治理设施维护记录表")
public class CominfoRepairRecordController extends BaseController{
    @Autowired
    private CominfoRepairRecordService cominfoRepairRecordService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoRepairRecordService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
			CominfoRepairRecordEntity cominfoRepairRecord = cominfoRepairRecordService.selectById(pid);

        return R.ok().put("cominfoRepairRecord", cominfoRepairRecord);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody CominfoRepairRecordEntity cominfoRepairRecord){
        ValidatorUtils.validateEntity(cominfoRepairRecord, AddGroup.class);
            cominfoRepairRecord.setCreateDate(DateUtils.getDate());
            cominfoRepairRecord.setUpdateDate(DateUtils.getDate());
			cominfoRepairRecordService.insert(cominfoRepairRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody CominfoRepairRecordEntity cominfoRepairRecord){
        ValidatorUtils.validateEntity(cominfoRepairRecord, UpdateGroup.class);
            cominfoRepairRecord.setUpdateDate(DateUtils.getDate());
			cominfoRepairRecordService.updateById(cominfoRepairRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
			cominfoRepairRecordService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
