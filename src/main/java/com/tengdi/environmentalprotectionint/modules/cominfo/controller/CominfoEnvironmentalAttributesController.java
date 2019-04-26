package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoEnvironmentalAttributesEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoEnvironmentalAttributesService;
import com.tengdi.core.utils.*;

import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.tengdi.userauthenuuid.common.annotation.SysLog;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDictEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDictService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 环境属性
 *
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:34
 */
@RestController
@RequestMapping("market/cominfoenvironmentalattributes")
@Api(tags="环境属性")
public class CominfoEnvironmentalAttributesController extends BaseController{
    @Autowired
    private CominfoEnvironmentalAttributesService cominfoEnvironmentalAttributesService;
    @Autowired
    private SysDictService sysDictService;
    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = cominfoEnvironmentalAttributesService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 根据公司id获取环境属性(特殊)
     */
    @GetMapping("/{cid}")
    @ApiOperation("根据公司id获取环境属性(特殊)")
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "path", dataType = "String", name = "cid", value = "公司id", required = false), })
    public R info(@PathVariable("cid") String cid){
        CominfoEnvironmentalAttributesEntity manageEntity = cominfoEnvironmentalAttributesService.dataById(cid);
        if(manageEntity!=null){
            if(manageEntity.getWaterLevel()!=null){
                List<SysDictEntity> waterLevelList=sysDictService.selectByMap(new MapUtils().put("`key`", manageEntity.getWaterLevel()).put("type","water_level_type"));
                if(waterLevelList.size()>0){
                    manageEntity.setWaterLevelName(waterLevelList.get(0).getValue());
                }
            }
            if(manageEntity.getNoiseLevel()!=null){
                List<SysDictEntity> noiseLevelList=sysDictService.selectByMap(new MapUtils().put("`key`", manageEntity.getNoiseLevel()).put("type","noise_level_type"));
                if(noiseLevelList.size()>0){
                    manageEntity.setNoiseLevelName(noiseLevelList.get(0).getValue());
                }
            }
            if(manageEntity.getAirLevel()!=null){
                List<SysDictEntity> airLevelList=sysDictService.selectByMap(new MapUtils().put("`key`", manageEntity.getAirLevel()).put("type","air_level_type"));
                if(airLevelList.size()>0){
                    manageEntity.setAirLevelName(airLevelList.get(0).getValue());
                }
            }
            if(manageEntity.getSeaLevel()!=null){
                List<SysDictEntity> seaLevelList=sysDictService.selectByMap(new MapUtils().put("`key`", manageEntity.getSeaLevel()).put("type","sea_level_type"));
                if(seaLevelList.size()>0){
                    manageEntity.setSeaLevelName(seaLevelList.get(0).getValue());
                }
            }
            if(manageEntity.getWaterSourceArea()!=null){
                List<SysDictEntity> waterSourceAreaList=sysDictService.selectByMap(new MapUtils().put("`key`", manageEntity.getWaterSourceArea()).put("type","boolean_type"));
                if(waterSourceAreaList.size()>0){
                    manageEntity.setWaterSourceAreaName(waterSourceAreaList.get(0).getValue());
                }
            }
            if(manageEntity.getSotwoArea()!=null){
                List<SysDictEntity> sotwoArealList=sysDictService.selectByMap(new MapUtils().put("`key`", manageEntity.getSotwoArea()).put("type","boolean_type"));
                if(sotwoArealList.size()>0){
                    manageEntity.setSotwoAreaName(sotwoArealList.get(0).getValue());
                }
            }
            if(manageEntity.getAcidRainArea()!=null){
                List<SysDictEntity> acidRainAreaList=sysDictService.selectByMap(new MapUtils().put("`key`", manageEntity.getAcidRainArea()).put("type","boolean_type"));
                if(acidRainAreaList.size()>0){
                    manageEntity.setAcidRainAreaName(acidRainAreaList.get(0).getValue());
                }
            }
        }
        return R.ok().put("cominfoEnvironmental", manageEntity);
    }

    /**
     * 保存环境属性
     */
    @PostMapping
    @ApiOperation("保存环境属性")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "保存环境属性")
    public R save(@RequestBody CominfoEnvironmentalAttributesEntity cominfoEnvironmentalAttributes){
        ValidatorUtils.validateEntity(cominfoEnvironmentalAttributes, AddGroup.class);
        cominfoEnvironmentalAttributes.setCreatedate(DateUtils.getDate());
        cominfoEnvironmentalAttributes.setUpdatedate(DateUtils.getDate());
        cominfoEnvironmentalAttributesService.insert(cominfoEnvironmentalAttributes);

        return R.ok();
    }

    /**
     * 修改环境属性
     */
    @PutMapping
    @ApiOperation("修改环境属性")
    @Transactional(rollbackFor = {Exception.class})
    @SysLog(value = "修改环境属性")
    public R update(@RequestBody CominfoEnvironmentalAttributesEntity cominfoEnvironmentalAttributes){
        ValidatorUtils.validateEntity(cominfoEnvironmentalAttributes, UpdateGroup.class);
        cominfoEnvironmentalAttributes.setUpdatedate(DateUtils.getDate());
        cominfoEnvironmentalAttributesService.updateById(cominfoEnvironmentalAttributes);

        return R.ok();
    }

    /**
     * 删除环境属性
     */
    @DeleteMapping
    @ApiOperation("删除环境属性")
    @SysLog(value = "删除环境属性")
    @Transactional(rollbackFor = {Exception.class})
    public R delete(@RequestBody String[] pids){
        cominfoEnvironmentalAttributesService.deleteBatchIds(Arrays.asList(pids));

        return R.ok();
    }

}
