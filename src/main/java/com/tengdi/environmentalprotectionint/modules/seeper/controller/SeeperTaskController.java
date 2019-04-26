package com.tengdi.environmentalprotectionint.modules.seeper.controller;

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
import com.tengdi.environmentalprotectionint.modules.seeper.entity.SeeperTaskEntity;
import com.tengdi.environmentalprotectionint.modules.seeper.service.SeeperTaskService;
import com.tengdi.core.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 江北新区积淹水点整治任务表
 *
 * @author tengdi
 * @email 
 * @date 2018-10-26 10:10:19
 */
@RestController
@RequestMapping("seeper/seepertask")
@Api(tags="江北新区积淹水点整治任务表")
public class SeeperTaskController extends BaseController{
    @Autowired
    private SeeperTaskService seeperTaskService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = seeperTaskService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
			SeeperTaskEntity seeperTask = seeperTaskService.selectById(pid);

        return R.ok().put("seeperTask", seeperTask);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody SeeperTaskEntity seeperTask){
        ValidatorUtils.validateEntity(seeperTask, AddGroup.class);
            seeperTask.setCreatedate(DateUtils.getStringDate());
            seeperTask.setUpdatedate(DateUtils.getStringDate());
			seeperTaskService.insert(seeperTask);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody SeeperTaskEntity seeperTask){
        ValidatorUtils.validateEntity(seeperTask, UpdateGroup.class);
            seeperTask.setUpdatedate(DateUtils.getStringDate());
			seeperTaskService.updateById(seeperTask);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
			seeperTaskService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
