package com.tengdi.environmentalprotectionint.modules.sys.controller;

import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.sys.entity.SysShuiwuranwuEntity;
import com.tengdi.environmentalprotectionint.modules.sys.service.SysShuiwuranwuService;
import com.tengdi.core.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 水污染代码表
 *
 * @author tengdi
 * @email 
 * @date 2018-10-23 11:23:18
 */
@RestController
@RequestMapping("sys/sysshuiwuranwu")
@Api(tags="水污染代码表")
public class SysShuiwuranwuController extends BaseController{
    @Autowired
    private SysShuiwuranwuService sysShuiwuranwuService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = sysShuiwuranwuService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/getLieBiao/{removalOfMaterial}")
    @ApiOperation("列表")
    public String getHangYeLieBiao(@PathVariable("removalOfMaterial") String removalOfMaterial){
        JSONArray jsonarr = sysShuiwuranwuService.getShuiWuRan(removalOfMaterial);

        return LayUiDataUtils.converJsonObjForLayUi(jsonarr).toString();
    }



    /**
     * 信息
     */
    @GetMapping("/{hangbiaoshi}")
    @ApiOperation("信息")
    public R info(@PathVariable("hangbiaoshi") Integer hangbiaoshi){
			SysShuiwuranwuEntity sysShuiwuranwu = sysShuiwuranwuService.selectById(hangbiaoshi);

        return R.ok().put("sysShuiwuranwu", sysShuiwuranwu);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody SysShuiwuranwuEntity sysShuiwuranwu){
        ValidatorUtils.validateEntity(sysShuiwuranwu, AddGroup.class);
			sysShuiwuranwuService.insert(sysShuiwuranwu);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody SysShuiwuranwuEntity sysShuiwuranwu){
        ValidatorUtils.validateEntity(sysShuiwuranwu, UpdateGroup.class);
			sysShuiwuranwuService.updateById(sysShuiwuranwu);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody Integer[] hangbiaoshis){
			sysShuiwuranwuService.deleteBatchIds(Arrays.asList(hangbiaoshis));

        return R.ok();
    }

}
