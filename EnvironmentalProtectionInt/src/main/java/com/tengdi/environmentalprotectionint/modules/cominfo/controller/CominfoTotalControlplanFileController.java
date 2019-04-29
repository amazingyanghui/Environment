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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoTotalControlplanFileEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoTotalControlplanFileService;
import com.tengdi.core.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 控制计划附件
 *
 * @author tengdi
 * @email 
 * @date 2018-12-04 18:08:41
 */
@RestController
@RequestMapping("cominfo/cominfototalcontrolplanfile")
@Api(tags="控制计划附件")
public class CominfoTotalControlplanFileController extends BaseController{
    @Autowired
    private CominfoTotalControlplanFileService cominfoTotalControlplanFileService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoTotalControlplanFileService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
			CominfoTotalControlplanFileEntity cominfoTotalControlplanFile = cominfoTotalControlplanFileService.selectById(pid);

        return R.ok().put("cominfoTotalControlplanFile", cominfoTotalControlplanFile);
    }

    /**
     * 根据项目id查附件
     */
    @GetMapping("/dataByFile/{aid}")
    @ApiOperation("根据项目id查附件")
    public R dataByFile(@PathVariable("aid") String aid){
        List<CominfoTotalControlplanFileEntity> buildingProjectAttachment = cominfoTotalControlplanFileService.dataByFile(aid);

        return R.ok().put("fileAttachment", buildingProjectAttachment);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody CominfoTotalControlplanFileEntity cominfoTotalControlplanFile){
        ValidatorUtils.validateEntity(cominfoTotalControlplanFile, AddGroup.class);
            cominfoTotalControlplanFile.setCreatedate(DateUtils.getDate());
			cominfoTotalControlplanFileService.insert(cominfoTotalControlplanFile);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody CominfoTotalControlplanFileEntity cominfoTotalControlplanFile){
        ValidatorUtils.validateEntity(cominfoTotalControlplanFile, UpdateGroup.class);
			cominfoTotalControlplanFileService.updateById(cominfoTotalControlplanFile);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
			cominfoTotalControlplanFileService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
