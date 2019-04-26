package com.tengdi.environmentalprotectionint.modules.online.controller;

import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorStoreinfoEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorStoreinfoService;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 企业数据存放信息表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:02
 */
@RestController
@RequestMapping("online/onlinemonitorstoreinfo")
@Api(tags="企业数据存放信息表")
public class OnlineMonitorStoreinfoController extends BaseController{
    @Autowired
    private OnlineMonitorStoreinfoService onlineMonitorStoreinfoService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = onlineMonitorStoreinfoService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        OnlineMonitorStoreinfoEntity onlineMonitorStoreinfo = onlineMonitorStoreinfoService.selectById(pid);

        return R.ok().put("onlineMonitorStoreinfo", onlineMonitorStoreinfo);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    @Transactional(rollbackFor = {Exception.class})
    public R save(@RequestBody OnlineMonitorStoreinfoEntity onlineMonitorStoreinfo){
        ValidatorUtils.validateEntity(onlineMonitorStoreinfo, AddGroup.class);
        onlineMonitorStoreinfoService.insert(onlineMonitorStoreinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    @Transactional(rollbackFor = {Exception.class})
    public R update(@RequestBody OnlineMonitorStoreinfoEntity onlineMonitorStoreinfo){
        ValidatorUtils.validateEntity(onlineMonitorStoreinfo, UpdateGroup.class);
        onlineMonitorStoreinfoService.updateById(onlineMonitorStoreinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    @Transactional(rollbackFor = {Exception.class})
    public R delete(@RequestBody String[] pids){
        onlineMonitorStoreinfoService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
