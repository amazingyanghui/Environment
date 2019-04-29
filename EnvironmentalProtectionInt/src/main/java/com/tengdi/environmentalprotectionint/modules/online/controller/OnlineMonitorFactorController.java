package com.tengdi.environmentalprotectionint.modules.online.controller;

import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorFactorEntity;
import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineMonitorFactorService;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 因子信息表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-21 14:52:07
 */
@RestController
@RequestMapping("online/onlinemonitorfactor")
@Api(tags="因子信息表")
public class OnlineMonitorFactorController extends BaseController{
    @Autowired
    private OnlineMonitorFactorService onlineMonitorFactorService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = onlineMonitorFactorService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        OnlineMonitorFactorEntity onlineMonitorFactor = onlineMonitorFactorService.selectById(pid);

        return R.ok().put("onlineMonitorFactor", onlineMonitorFactor);
    }

    /**
     * 因子下拉框
     */
    @GetMapping("/selectList/{type}")
    @ApiOperation("因子下拉框")
    public String selectList(@PathVariable("type") int type){
        List<SelectEntity> list = onlineMonitorFactorService.list(type);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存因子信息
     */
    @PostMapping
    @ApiOperation("保存因子信息")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存因子信息")
    public R save(@RequestBody OnlineMonitorFactorEntity onlineMonitorFactor){
        ValidatorUtils.validateEntity(onlineMonitorFactor, AddGroup.class);
        onlineMonitorFactorService.insert(onlineMonitorFactor);

        return R.ok();
    }

    /**
     * 修改因子信息
     */
    @PutMapping
    @ApiOperation("修改因子信息")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改因子信息")
    public R update(@RequestBody OnlineMonitorFactorEntity onlineMonitorFactor){
        ValidatorUtils.validateEntity(onlineMonitorFactor, UpdateGroup.class);
        onlineMonitorFactorService.updateById(onlineMonitorFactor);

        return R.ok();
    }

    /**
     * 删除因子信息
     */
    @DeleteMapping
    @ApiOperation("删除因子信息")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "删除因子信息")
    public R delete(@RequestBody String[] pids){
        onlineMonitorFactorService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
