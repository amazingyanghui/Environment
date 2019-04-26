package com.tengdi.environmentalprotectionint.modules.radioactiveore.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.radioactiveore.entity.CominfoRadioactiveOreMonitorEntity;
import com.tengdi.environmentalprotectionint.modules.radioactiveore.service.CominfoRadioactiveOreMonitorService;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 放射性检测表（包含【废水】放射性检测、和【固体物料及废物】放射性检测）
 *
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:25:58
 */
@RestController
@RequestMapping("market/cominforadioactiveoremonitor" )
@Api(tags = "放射性检测表（包含【废水】放射性检测、和【固体物料及废物】放射性检测）" )
public class CominfoRadioactiveOreMonitorController extends BaseController {
    @Autowired
    private CominfoRadioactiveOreMonitorService cominfoRadioactiveOreMonitorService;

    /**
     * @param
     * @return
     */
    @GetMapping
    @ApiOperation("列表")
    public String queryTableData(@RequestParam Map<String, Object> params) {
        PageUtils page = cominfoRadioactiveOreMonitorService.queryTableData(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("pid" ) String pid) {
            CominfoRadioactiveOreMonitorEntity cominfoRadioactiveOreMonitor = cominfoRadioactiveOreMonitorService.selectById(pid);

        return R.ok().put("cominfoRadioactiveOreMonitor" , cominfoRadioactiveOreMonitor);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody CominfoRadioactiveOreMonitorEntity cominfoRadioactiveOreMonitor) {
        ValidatorUtils.validateEntity(cominfoRadioactiveOreMonitor, AddGroup.class);
//            cominfoRadioactiveOreMonitor.setCreatedate(DateUtils.getDate());
            cominfoRadioactiveOreMonitorService.insert(cominfoRadioactiveOreMonitor);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody CominfoRadioactiveOreMonitorEntity cominfoRadioactiveOreMonitor) {
        ValidatorUtils.validateEntity(cominfoRadioactiveOreMonitor, UpdateGroup.class);
//            cominfoRadioactiveOreMonitor.setUpdatedate(DateUtils.getDate());
            cominfoRadioactiveOreMonitorService.updateById(cominfoRadioactiveOreMonitor);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]pids) {
            cominfoRadioactiveOreMonitorService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }


}
