package com.tengdi.environmentalprotectionint.modules.radioactiveore.controller;

import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.Map;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.radioactiveore.entity.CominfoRadioactiveOreEntity;
import com.tengdi.environmentalprotectionint.modules.radioactiveore.service.CominfoRadioactiveOreService;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 伴生放射性矿产企业含放射性固体物料及废物情况
 *
 * @author tengdi
 * @email 
 * @date 2019-03-12 14:52:38
 */
@RestController
@RequestMapping("market/cominforadioactiveore" )
@Api(tags = "伴生放射性矿产企业含放射性固体物料及废物情况" )
public class CominfoRadioactiveOreController extends BaseController {
    @Autowired
    private CominfoRadioactiveOreService cominfoRadioactiveOreService;

    /**
     * @param
     * @return
     */
    @GetMapping
    @ApiOperation("列表" )
    public String queryTableData(@RequestParam Map<String, Object> params) {
        PageUtils page = cominfoRadioactiveOreService.queryTableData(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("pid" ) String pid) {
            CominfoRadioactiveOreEntity cominfoRadioactiveOre = cominfoRadioactiveOreService.selectById(pid);

        return R.ok().put("cominfoRadioactiveOre" , cominfoRadioactiveOre);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody CominfoRadioactiveOreEntity cominfoRadioactiveOre) {
        ValidatorUtils.validateEntity(cominfoRadioactiveOre, AddGroup.class);
//            cominfoRadioactiveOre.setCreatedate(DateUtils.getDate());
            cominfoRadioactiveOreService.insert(cominfoRadioactiveOre);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody CominfoRadioactiveOreEntity cominfoRadioactiveOre) {
        ValidatorUtils.validateEntity(cominfoRadioactiveOre, UpdateGroup.class);
//            cominfoRadioactiveOre.setUpdatedate(DateUtils.getDate());
            cominfoRadioactiveOreService.updateById(cominfoRadioactiveOre);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]pids) {
            cominfoRadioactiveOreService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }



}
