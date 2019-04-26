package com.tengdi.environmentalprotectionint.modules.sys.controller;

import com.tengdi.core.utils.*;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;

import com.tengdi.environmentalprotectionint.modules.sys.entity.SysNoticeEntity;
import com.tengdi.environmentalprotectionint.modules.sys.service.SysNoticeService;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 系统公告
 *
 * @author tengdi
 * @email 
 * @date 2019-03-07 11:01:21
 */
@RestController
@RequestMapping("sys/notice")
@Api(tags="系统公告")
public class SysNoticeController extends BaseController {
    @Autowired
    private SysNoticeService sysNoticeService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = sysNoticeService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{id}")
    @ApiOperation("信息")
    public R info(@PathVariable("id") String id){
			SysNoticeEntity sysNotice = sysNoticeService.selectById(id);

        return R.ok().put("sysNotice", sysNotice);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody SysNoticeEntity sysNotice){
        ValidatorUtils.validateEntity(sysNotice, AddGroup.class);
        String id = UUIDTool.getUUID();
        sysNotice.setId(id);
        int indexPoint = StringUtils.ordinalIndexOf(sysNotice.getFile(), "\\", 2);
        sysNotice.setFile(sysNotice.getFile().substring(indexPoint + 1));
        sysNotice.setCreateTime(DateUtils.getDate());
        sysNoticeService.insert(sysNotice);

        return R.ok().put("id",id);
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody SysNoticeEntity sysNotice){
        ValidatorUtils.validateEntity(sysNotice, UpdateGroup.class);
			sysNoticeService.updateById(sysNotice);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] ids){
			sysNoticeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
