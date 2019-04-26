package com.tengdi.environmentalprotectionint.modules.cominfo.controller;

import com.tengdi.core.utils.MapUtils;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.tengdi.environmentalprotectionint.modules.common.entity.SelectEntity;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.environmentalprotectionint.modules.cominfo.entity.SysHangyedaimaEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.SysHangyedaimaService;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 *行业代码表
 * @author tengdi
 * @email 
 * @date 2018-09-11 14:56:09
 */
@RestController
@RequestMapping("sys/syshangyedaima")
@Api(tags="")
public class SysHangyedaimaController extends BaseController{
    @Autowired
    private SysHangyedaimaService sysHangyedaimaService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params){
        PageUtils page = sysHangyedaimaService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/getHangYeLieBiao/{industryids}")
    @ApiOperation("列表")
    public String getHangYeLieBiao(@PathVariable("industryids") String industryids){
        JSONArray jsonarr = sysHangyedaimaService.getHangYeLieBiao(industryids);

        return LayUiDataUtils.converJsonObjForLayUi(jsonarr).toString();
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation("列表")
    public String queryList(@RequestParam Map<String, Object> params){
        List<SysHangyedaimaEntity> list=sysHangyedaimaService.queryList(params);
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{hangbiaoshi}")
    @ApiOperation("信息")
    public R info(@PathVariable("hangbiaoshi") Integer hangbiaoshi){
        SysHangyedaimaEntity sysHangyedaima = sysHangyedaimaService.selectById(hangbiaoshi);

        return R.ok().put("sysHangyedaima", sysHangyedaima);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody SysHangyedaimaEntity sysHangyedaima){
        ValidatorUtils.validateEntity(sysHangyedaima, AddGroup.class);
        sysHangyedaimaService.insert(sysHangyedaima);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody SysHangyedaimaEntity sysHangyedaima){
        ValidatorUtils.validateEntity(sysHangyedaima, UpdateGroup.class);
        sysHangyedaimaService.updateById(sysHangyedaima);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody Integer[] hangbiaoshis){
        sysHangyedaimaService.deleteBatchIds(Arrays.asList(hangbiaoshis));

        return R.ok();
    }

    /**
     * 根据行业名获取代码值
     */
    @GetMapping("/getDaiMaZhi")
    @ApiOperation("根据行业名获取代码值")
    public R getDaiMaZhi(@RequestParam Map<String, Object> params){
        String mingCheng=(String)params.get("value");
        String[] strList=mingCheng.split(",");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strList.length;i++){
            List<SysHangyedaimaEntity> list=sysHangyedaimaService.selectByMap(new MapUtils().put("MingCheng",strList[i]));
            if(i==0){
                sb.append(list.get(0).getDaimazhi());
            }else{
                sb.append(",");
                sb.append(list.get(0).getDaimazhi());
            }
        }

        return R.ok().put("daiMaZhi",sb.toString());
    }
    /**
     * 获取行业列表下拉框
     */
    @GetMapping("/selectGetHangYeLieBiao/{cid}")
    @ApiOperation("获取行业列表下拉框")
    public String selectGetHangYeLieBiao(@PathVariable("cid") String cid){
        List<SelectEntity> list = sysHangyedaimaService.selectGetHangYeLieBiao();
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(list)).toString();
    }
}
