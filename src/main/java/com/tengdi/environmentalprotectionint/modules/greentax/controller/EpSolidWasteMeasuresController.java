package com.tengdi.environmentalprotectionint.modules.greentax.controller;
import com.tengdi.core.utils.DateUtils;
import com.tengdi.core.utils.R;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.tengdi.environmentalprotectionint.modules.common.entity.QueryCriterias;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteMeasuresEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpSolidWasteMeasuresService;
import com.tengdi.environmentalprotectionint.modules.online.entity.OnlineMonitorPortinfoEntity;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;
import com.tengdi.core.utils.PageUtils;
import com.tengdi.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 固体废物基础信息采集-污染防治措施表
 *
 * @author tengdi
 * @email 
 * @date 2019-03-06 10:20:29
 */
@RestController
@RequestMapping("epTaxManagement/epsolidwastemeasures" )
@Api(tags = "固体废物基础信息采集-污染防治措施表" )
public class EpSolidWasteMeasuresController extends BaseController {
    @Autowired
    private EpSolidWasteMeasuresService epSolidWasteMeasuresService;


    /**
     * 信息
     */
    @GetMapping("/{id}" )
    @ApiOperation("信息" )
    public R info(@PathVariable("id" ) String id) {
            EpSolidWasteMeasuresEntity epSolidWasteMeasures = epSolidWasteMeasuresService.selectById(id);

        return R.ok().put("epSolidWasteMeasures" , epSolidWasteMeasures);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存" )
    public R save(@RequestBody EpSolidWasteMeasuresEntity epSolidWasteMeasures) {
        ValidatorUtils.validateEntity(epSolidWasteMeasures, AddGroup.class);
//            epSolidWasteMeasures.setCreatedate(DateUtils.getDate());
            epSolidWasteMeasuresService.insert(epSolidWasteMeasures);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改" )
    public R update(@RequestBody EpSolidWasteMeasuresEntity epSolidWasteMeasures) {
        ValidatorUtils.validateEntity(epSolidWasteMeasures, UpdateGroup.class);
//            epSolidWasteMeasures.setUpdatedate(DateUtils.getDate());
            epSolidWasteMeasuresService.updateById(epSolidWasteMeasures);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除" )
    public R delete(@RequestBody String[]ids) {
            epSolidWasteMeasuresService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
    * @param criterias
    * @return
    */
//    @GetMapping
//    @ApiOperation("列表" )
//    public String queryTableData(QueryCriterias criterias) {
//        if (StringUtils.isEmpty(criterias.getTable())) {
//            criterias.setTable("ep_solid_waste_measures" );
//        }
//        PageUtils page = epSolidWasteMeasuresService.queryTableData(criterias);
//        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
//    }
    /**
     * 获取固废下拉选项
     */
    @GetMapping("/getSolidWaste/{cid}")
    @ApiOperation("获取固废下拉选项")
    public String getSolidWaste(@PathVariable("cid") String cid) {
        JSONArray jsonArray = new JSONArray();
        List<EpSolidWasteMeasuresEntity> list = epSolidWasteMeasuresService.getSolidWaste(cid);
        for (int i = 0; i < list.size(); i++) {
            JSONObject jsonObject = new JSONObject();
            EpSolidWasteMeasuresEntity ldarEquipmentUnitEntity = list.get(i);
            jsonObject.put("id", ldarEquipmentUnitEntity.getId());//排口ID
            jsonObject.put("name", ldarEquipmentUnitEntity.getMeasuresCode());//排口编号名称
            jsonArray.add(jsonObject);
        }
        return LayUiDataUtils.converJsonObjForLayUi(JSONArray.fromObject(jsonArray)).toString();
    }

}
