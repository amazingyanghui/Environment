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
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoTotalControlplanEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoTotalControlplanService;
import com.tengdi.core.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 企业总量控制计划
 *
 * @author tengdi
 * @email 
 * @date 2018-12-03 17:54:50
 */
@RestController
@RequestMapping("cominfo/cominfototalcontrolplan")
@Api(tags="企业总量控制计划")
public class CominfoTotalControlplanController extends BaseController{
    @Autowired
    private CominfoTotalControlplanService cominfoTotalControlplanService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoTotalControlplanService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<CominfoTotalControlplanEntity> list= cominfoTotalControlplanService.queryList(params);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
			CominfoTotalControlplanEntity cominfoTotalControlplan = cominfoTotalControlplanService.entityById(pid);

        return R.ok().put("cominfoTotalControlplan", cominfoTotalControlplan);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody CominfoTotalControlplanEntity cominfoTotalControlplan){
        ValidatorUtils.validateEntity(cominfoTotalControlplan, AddGroup.class);
            cominfoTotalControlplan.setCreatedate(DateUtils.getDate());
            cominfoTotalControlplan.setUpdatedate(DateUtils.getDate());
			String pid=cominfoTotalControlplanService.insertData(cominfoTotalControlplan);

        return R.ok().put("pid",pid);
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody CominfoTotalControlplanEntity cominfoTotalControlplan){
        ValidatorUtils.validateEntity(cominfoTotalControlplan, UpdateGroup.class);
            cominfoTotalControlplan.setUpdatedate(DateUtils.getDate());
			cominfoTotalControlplanService.updateById(cominfoTotalControlplan);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
			cominfoTotalControlplanService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
