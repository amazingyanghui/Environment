package com.tengdi.environmentalprotectionint.modules.online.controller;

import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineTableRetrieveEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineTableRetrieveService;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 表名检索表
 *
 * @author tengdi
 * @email 
 * @date 2018-08-24 10:54:40
 */
@RestController
@RequestMapping("market/onlinetableretrieve")
@Api(tags="表名检索表")
public class OnlineTableRetrieveController extends BaseController{
    @Autowired
    private OnlineTableRetrieveService onlineTableRetrieveService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = onlineTableRetrieveService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        OnlineTableRetrieveEntity onlineTableRetrieve = onlineTableRetrieveService.selectById(pid);

        return R.ok().put("onlineTableRetrieve", onlineTableRetrieve);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody OnlineTableRetrieveEntity onlineTableRetrieve){
        ValidatorUtils.validateEntity(onlineTableRetrieve, AddGroup.class);
        onlineTableRetrieveService.insert(onlineTableRetrieve);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody OnlineTableRetrieveEntity onlineTableRetrieve){
        ValidatorUtils.validateEntity(onlineTableRetrieve, UpdateGroup.class);
        onlineTableRetrieveService.updateById(onlineTableRetrieve);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        onlineTableRetrieveService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
