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
import com.tengdi.environmentalprotectionint.modules.emergency.entity.EmergencySystemPlanFileEntity;
import com.tengdi.environmentalprotectionint.modules.emergency.service.EmergencySystemPlanFileService;
import com.tengdi.core.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 应急预案文档
 *
 * @author tengdi
 * @email 
 * @date 2018-11-19 19:30:17
 */
@RestController
@RequestMapping("emergency/emergencysystemplanfile")
@Api(tags="应急预案文档")
public class EmergencySystemPlanFileController extends BaseController{
    @Autowired
    private EmergencySystemPlanFileService emergencySystemPlanFileService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = emergencySystemPlanFileService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
			EmergencySystemPlanFileEntity emergencySystemPlanFile = emergencySystemPlanFileService.selectById(pid);

        return R.ok().put("emergencySystemPlanFile", emergencySystemPlanFile);
    }

    /**
     * 根据应急预案id查附件
     */
    @GetMapping("/dataByFile/{aid}")
    @ApiOperation("根据应急预案id查附件")
    public R dataByFile(@PathVariable("aid") String aid){
        List<EmergencySystemPlanFileEntity> systemPlanFileEntityList = emergencySystemPlanFileService.dataByFile(aid);

        return R.ok().put("fileAttachment", systemPlanFileEntityList);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody EmergencySystemPlanFileEntity emergencySystemPlanFile){
        ValidatorUtils.validateEntity(emergencySystemPlanFile, AddGroup.class);
            emergencySystemPlanFile.setCreatedate(DateUtils.getDate());
			emergencySystemPlanFileService.insert(emergencySystemPlanFile);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody EmergencySystemPlanFileEntity emergencySystemPlanFile){
        ValidatorUtils.validateEntity(emergencySystemPlanFile, UpdateGroup.class);
			emergencySystemPlanFileService.updateById(emergencySystemPlanFile);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
			emergencySystemPlanFileService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
