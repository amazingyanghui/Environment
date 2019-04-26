package com.tengdi.environmentalprotectionint.modules.emergency.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemDrillFileEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemDrillFileService;
import com.tengdi.core.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 应急演练文档
 *
 * @author tengdi
 * @email 
 * @date 2018-11-19 19:30:23
 */
@RestController
@RequestMapping("emergency/emergencysystemdrillfile")
@Api(tags="应急演练文档")
public class EmergencySystemDrillFileController extends BaseController{
    @Autowired
    private EmergencySystemDrillFileService emergencySystemDrillFileService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = emergencySystemDrillFileService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
			EmergencySystemDrillFileEntity emergencySystemDrillFile = emergencySystemDrillFileService.selectById(pid);

        return R.ok().put("emergencySystemDrillFile", emergencySystemDrillFile);
    }


    /**
     * 根据应急演练id查附件
     */
    @GetMapping("/dataByFile/{aid}")
    @ApiOperation("根据应急演练id查附件")
    public R dataByFile(@PathVariable("aid") String aid){
        List<EmergencySystemDrillFileEntity> systemDrillFileEntityList = emergencySystemDrillFileService.dataByFile(aid);

        return R.ok().put("fileAttachment", systemDrillFileEntityList);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody EmergencySystemDrillFileEntity emergencySystemDrillFile){
        ValidatorUtils.validateEntity(emergencySystemDrillFile, AddGroup.class);
            emergencySystemDrillFile.setCreatedate(DateUtils.getDate());
			emergencySystemDrillFileService.insert(emergencySystemDrillFile);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody EmergencySystemDrillFileEntity emergencySystemDrillFile){
        ValidatorUtils.validateEntity(emergencySystemDrillFile, UpdateGroup.class);
			emergencySystemDrillFileService.updateById(emergencySystemDrillFile);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
			emergencySystemDrillFileService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
