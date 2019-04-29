package com.tengdi.environmentalprotectionint.modules.online.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;

import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorWasteEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorWasteinfoService;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 排放污染物信息表
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 16:46:24
 */
@RestController
@RequestMapping("online/onlinemonitorWasteinfo")
@Api(tags="排放污染物信息表")
public class OnlineMonitorWasteinfoController extends BaseController{
    @Autowired
    private OnlineMonitorWasteinfoService onlineMonitorWasteinfoService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = onlineMonitorWasteinfoService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        OnlineMonitorWasteEntity onlineMonitorWasteEntity = onlineMonitorWasteinfoService.selectById(pid);

        return R.ok().put("onlineMonitorStoreinfo", onlineMonitorWasteEntity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody OnlineMonitorWasteEntity onlineMonitorWasteEntity){
        ValidatorUtils.validateEntity(onlineMonitorWasteEntity, AddGroup.class);
           // onlineMonitorStoreinfo.setCreatedate(DateUtils.getDate());
        onlineMonitorWasteinfoService.insert(onlineMonitorWasteEntity);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody OnlineMonitorWasteEntity onlineMonitorWasteEntity){
        ValidatorUtils.validateEntity(onlineMonitorWasteEntity, UpdateGroup.class);
           // onlineMonitorStoreinfo.setUpdatedate(DateUtils.getDate());
        onlineMonitorWasteinfoService.updateById(onlineMonitorWasteEntity);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        onlineMonitorWasteinfoService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
