package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.EnvironmentalMonitoringRecordEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.EnvironmentalMonitoringRecordService;
import com.tengdi.core.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 环境监察记录表
 *
 * @author tengdi
 * @email 
 * @date 2018-12-04 10:50:12
 */
@RestController
@RequestMapping("cominfo/environmentalmonitoringrecord")
@Api(tags="环境监察记录表")
public class EnvironmentalMonitoringRecordController extends BaseController{
    @Autowired
    private EnvironmentalMonitoringRecordService environmentalMonitoringRecordService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = environmentalMonitoringRecordService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<EnvironmentalMonitoringRecordEntity> list= environmentalMonitoringRecordService.queryList(params);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
			EnvironmentalMonitoringRecordEntity environmentalMonitoringRecord = environmentalMonitoringRecordService.entityById(pid);

        return R.ok().put("environmentalMonitoringRecord", environmentalMonitoringRecord);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody EnvironmentalMonitoringRecordEntity environmentalMonitoringRecord){
        ValidatorUtils.validateEntity(environmentalMonitoringRecord, AddGroup.class);
            environmentalMonitoringRecord.setCreatedate(DateUtils.getDate());
            environmentalMonitoringRecord.setUpdatedate(DateUtils.getDate());
			environmentalMonitoringRecordService.insert(environmentalMonitoringRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody EnvironmentalMonitoringRecordEntity environmentalMonitoringRecord){
        ValidatorUtils.validateEntity(environmentalMonitoringRecord, UpdateGroup.class);
            environmentalMonitoringRecord.setUpdatedate(DateUtils.getDate());
			environmentalMonitoringRecordService.updateById(environmentalMonitoringRecord);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
			environmentalMonitoringRecordService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
