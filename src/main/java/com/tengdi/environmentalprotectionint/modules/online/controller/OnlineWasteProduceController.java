package com.tengdi.environmentalprotectionint.modules.online.controller;

import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineWasteProduceEntity;
import com.tengdi.environmentalprotectionint.modules.online.service.OnlineWasteProduceService;
import com.tengdi.core.utils.*;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 固废产生与利用（危废产生与利用）
 *
 * @author tengdi
 * @email 
 * @date 2003-07-16 01:03:26
 */
@RestController
@RequestMapping("online/onlinewasteproduce")
@Api(tags="固废产生与利用（危废产生与利用）")
public class OnlineWasteProduceController extends BaseController{
    @Autowired
    private OnlineWasteProduceService onlineWasteProduceService;
    @Autowired
    private SysDictService sysDictService;
    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = onlineWasteProduceService.queryPage(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }
    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        OnlineWasteProduceEntity onlineWasteProduce = onlineWasteProduceService.selectById(pid);

        return R.ok().put("onlineWasteProduce", onlineWasteProduce);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody OnlineWasteProduceEntity onlineWasteProduce){
        ValidatorUtils.validateEntity(onlineWasteProduce, AddGroup.class);
        onlineWasteProduce.setCreatedate(DateUtils.getDate());
        onlineWasteProduceService.insert(onlineWasteProduce);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody OnlineWasteProduceEntity onlineWasteProduce){
        ValidatorUtils.validateEntity(onlineWasteProduce, UpdateGroup.class);
        onlineWasteProduce.setUpdatedate(DateUtils.getDate());
        onlineWasteProduceService.updateById(onlineWasteProduce);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        onlineWasteProduceService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }
    /**
     * 查询字典废物类型
     */
    @GetMapping("/wasteType/{type}")
    @ApiOperation("查询题目字典类型")
    public String selectPracticetype(@PathVariable("type") String  type) {
        List<SysDictEntity> list=sysDictService.selectByMap(new MapUtils().put("type",type));
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }
}
