package com.tengdi.environmentalprotectionint.modules.radioactive.controller;

import com.tengdi.environmentalprotectionint.modules.radioactive.entity.RadioactiveIsotopeInfoEntity;
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
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.environmentalprotectionint.modules.radioactive.service.RadioactiveIsotopeInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 放射性同位素
 *
 * @author tengdi
 * @email 
 * @date 2018-09-17 15:37:10
 */
@RestController
@RequestMapping("radioactive/radioactiveisotopeinfo")
@Api(tags="放射性同位素")
public class RadioactiveIsotopeInfoController extends BaseController{
    @Autowired
    private RadioactiveIsotopeInfoService radioactiveIsotopeInfoService;
    @Autowired
    private SysDictService sysDictService;
    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = radioactiveIsotopeInfoService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<RadioactiveIsotopeInfoEntity> list= radioactiveIsotopeInfoService.queryList(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/queryName")
    @ApiOperation("列表")
    public String queryName(@RequestParam Map<String, Object> params){
        List<RadioactiveIsotopeInfoEntity> list= radioactiveIsotopeInfoService.queryName(params);

        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 信息
     */
    @GetMapping("/{pid}")
    @ApiOperation("信息")
    public R info(@PathVariable("pid") String pid){
        RadioactiveIsotopeInfoEntity radioactiveIsotopeInfo = radioactiveIsotopeInfoService.selectById(pid);

        if(radioactiveIsotopeInfo!=null){
            if(radioactiveIsotopeInfo.getRadioactiveCategory()!=null){
                List<SysDictEntity> radioactiveCategoryList=sysDictService.selectByMap(new MapUtils().put("`key`", radioactiveIsotopeInfo.getRadioactiveCategory()).put("type","radioactive_category_type"));
                if(radioactiveCategoryList.size()>0){
                   radioactiveIsotopeInfo.setRadioactiveCategoryName(radioactiveCategoryList.get(0).getValue());
                }
            }
        }
        if(radioactiveIsotopeInfo!=null){
            if(radioactiveIsotopeInfo.getCurstatus()!=null){
                List<SysDictEntity> curstatusList=sysDictService.selectByMap(new MapUtils().put("`key`", radioactiveIsotopeInfo.getCurstatus()).put("type","curstatus_type"));
                if(curstatusList.size()>0){
                    radioactiveIsotopeInfo.setCurstatusName(curstatusList.get(0).getValue());
                }
            }
        }
        return R.ok().put("radioactiveIsotopeInfo", radioactiveIsotopeInfo);
    }

    /**
     * 根据公司id获取放射性同位素
     */
    @GetMapping("/dataById/{cid}")
    @ApiOperation("根据公司id获取放射性同位素")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public String dataById(@PathVariable("cid") String cid){
        List<RadioactiveIsotopeInfoEntity> list = radioactiveIsotopeInfoService.dataById(cid);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody RadioactiveIsotopeInfoEntity radioactiveIsotopeInfo){
        ValidatorUtils.validateEntity(radioactiveIsotopeInfo, AddGroup.class);
        radioactiveIsotopeInfo.setCreatedate(DateUtils.getStringDate());
        radioactiveIsotopeInfoService.insert(radioactiveIsotopeInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody RadioactiveIsotopeInfoEntity radioactiveIsotopeInfo){
        ValidatorUtils.validateEntity(radioactiveIsotopeInfo, UpdateGroup.class);
        radioactiveIsotopeInfo.setUpdatedate(DateUtils.getStringDate());
        radioactiveIsotopeInfoService.updateById(radioactiveIsotopeInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] pids){
        radioactiveIsotopeInfoService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
