package com.tengdi.environmentalprotectionint.modules.greentaxesinformation.controller;


import com.tengdi.core.utils.R;

import com.tengdi.core.utils.UUIDTool;
import com.tengdi.core.validator.ValidatorUtils;
import com.tengdi.core.validator.group.AddGroup;
import com.tengdi.core.validator.group.UpdateGroup;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.tengdi.environmentalprotectionint.modules.cominfo.entity.CominfoBaseinfoEntity;
import com.tengdi.environmentalprotectionint.modules.cominfo.service.CominfoBaseinfoService;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteClientEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteMainEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.entity.EpSolidWasteMeasuresEntity;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpSolidWasteClientService;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpSolidWasteMainService;
import com.tengdi.environmentalprotectionint.modules.greentax.service.EpSolidWasteMeasuresService;
import com.tengdi.environmentalprotectionint.modules.greentaxesinformation.entity.SolidWasteInformationCollection;
import com.tengdi.environmentalprotectionint.modules.greentaxesinformation.entity.SolidwasteInformationEntity;
import com.tengdi.environmentalprotectionint.modules.greentaxesinformation.entity.SysWasteEntity;
import com.tengdi.environmentalprotectionint.modules.greentaxesinformation.service.SolidwasteInformationService;
import com.tengdi.environmentalprotectionint.modules.utils.ApiUtils;
import com.tengdi.userauthenuuid.modules.sys.controller.BaseController;
import com.tengdi.userauthenuuid.modules.sys.entity.SysDeptEntity;
import com.tengdi.userauthenuuid.modules.sys.entity.SysUserEntity;
import com.tengdi.userauthenuuid.modules.sys.service.SysDeptService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tengdi.core.utils.LayUiDataUtils;

import com.tengdi.core.utils.PageUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

/**
 * 固体废物基础信息采集
 *
 * @author tengdi
 * @email
 * @date 2019-03-04 11:14:18
 */
@RestController
@RequestMapping("environmentalTariff/solidWaste")
@Api(tags = "固体废物基础信息采集")
public class SolidwasteInformationController extends BaseController {
    @Autowired
    private SolidwasteInformationService solidwasteInformationService;
    @Autowired
    private CominfoBaseinfoService cominfoBaseinfoService;
    @Autowired
    private SysDeptService sysDeptService;
    @Autowired
    private EpSolidWasteMainService epSolidWasteMainService;
    @Autowired
    private EpSolidWasteClientService epSolidWasteClientService;
    @Autowired
    private EpSolidWasteMeasuresService epSolidWasteMeasuresService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("列表")
    public String list(@RequestParam Map<String, Object> params) {
        PageUtils page = solidwasteInformationService.queryPage(params);

        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }


    /**
     * 信息
     */
    @GetMapping("/{id}")
    @ApiOperation("信息")
    public R info(@PathVariable("id") String id) {
        SolidwasteInformationEntity solidwasteInformation = solidwasteInformationService.selectById(id);

        return R.ok().put("solidwasteInformation", solidwasteInformation);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public R save(@RequestBody SolidwasteInformationEntity solidwasteInformation) {
        ValidatorUtils.validateEntity(solidwasteInformation, AddGroup.class);

        solidwasteInformationService.insert(solidwasteInformation);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping
    @ApiOperation("修改")
    public R update(@RequestBody SolidwasteInformationEntity solidwasteInformation) {
        ValidatorUtils.validateEntity(solidwasteInformation, UpdateGroup.class);

        solidwasteInformationService.updateById(solidwasteInformation);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R delete(@RequestBody String[] ids) {
        solidwasteInformationService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    @GetMapping("/getWasteAll")
    @ApiOperation("查询废物列表")
    public String getWasteAll(@RequestParam Map<String, Object> params) {
        PageUtils page = solidwasteInformationService.getWasteAll(params);
        return LayUiDataUtils.converPageJsonObjForLayUi(page).toString();
    }

    @GetMapping("/getCompanyInfo/{pid}")
    @ApiOperation("获取当前登录企业信息")
    public R getCompanyInfo(@PathVariable("pid") String pid) {
        CominfoBaseinfoEntity cominfoBaseinfo = cominfoBaseinfoService.selectById(pid);
        return R.ok().put("cominfoBaseinfo", cominfoBaseinfo);
    }

    @PostMapping("/addWasteInfo")
    @ApiOperation("保存")
    public R addWasteInfo(
            @RequestBody SolidWasteInformationCollection solidWasteInformationCollection, HttpServletRequest req) {
        SysUserEntity userEntity = ApiUtils.getUserByToken(req);
        R r = new R();
        String deptId = userEntity.getDeptId();
        String uuid = UUIDTool.getUUID();
        //获得当前登录用户的企业信息
        CominfoBaseinfoEntity cominfoBaseinfoEntity = cominfoBaseinfoService.selectById(deptId);
        cominfoBaseinfoEntity.setLocalCity(solidWasteInformationCollection.getLocalCity());
        cominfoBaseinfoEntity.setStreetOrTown(solidWasteInformationCollection.getStreetOrTown());
        cominfoBaseinfoService.updateById(cominfoBaseinfoEntity);
        if (StringUtils.isEmpty(deptId) == false) {
            SysDeptEntity sysDeptEntity = sysDeptService.selectById(deptId);
            //危废主表
            EpSolidWasteMainEntity epSolidWasteMainEntity = new EpSolidWasteMainEntity();
            epSolidWasteMainEntity.setId(uuid);
            epSolidWasteMainEntity.setCompanyId(deptId);
            epSolidWasteMainEntity.setCompetentDepartment(solidWasteInformationCollection.getEpSolidWasteMainEntity().getCompetentDepartment());
            epSolidWasteMainEntity.setCompetentTax(solidWasteInformationCollection.getEpSolidWasteMainEntity().getCompetentTax());
            epSolidWasteMainEntity.setWasteIds(solidWasteInformationCollection.getEpSolidWasteMainEntity().getId());
            epSolidWasteMainEntity.setCreateDate(new Date());
            epSolidWasteMainEntity.setCreateUser(solidWasteInformationCollection.getCreateName());
            epSolidWasteMainService.insert(epSolidWasteMainEntity);
        } else {
            return r.put("code", 0).put("msg", "当前登录用户企业ID为空");
        }
        //接受或委托单位处理情况表
        EpSolidWasteClientEntity epSolidWasteClientEntity = new EpSolidWasteClientEntity();
        //存入主表ID 以及接受或委托单位处理情况
        epSolidWasteClientEntity.setMainId(uuid);
        epSolidWasteClientEntity.setClientType(solidWasteInformationCollection.getEpSolidWasteClientEntities().getClientType());
        epSolidWasteClientEntity.setClientName(solidWasteInformationCollection.getEpSolidWasteClientEntities().getClientName());
        epSolidWasteClientEntity.setClientSocialCreditCode(solidWasteInformationCollection.getEpSolidWasteClientEntities().getClientSocialCreditCode());
        epSolidWasteClientEntity.setClientWaste(solidWasteInformationCollection.getEpSolidWasteClientEntities().getClientWaste());
        epSolidWasteClientEntity.setHandleMode(solidWasteInformationCollection.getEpSolidWasteClientEntities().getHandleMode());
        epSolidWasteClientEntity.setQualification(solidWasteInformationCollection.getEpSolidWasteClientEntities().getQualification());
        epSolidWasteClientEntity.setClientLinkman(solidWasteInformationCollection.getEpSolidWasteClientEntities().getClientLinkman());
        epSolidWasteClientEntity.setClientContractDeadline(solidWasteInformationCollection.getEpSolidWasteClientEntities().getClientContractDeadline());
        epSolidWasteClientService.insert(epSolidWasteClientEntity);

        //epSolidWasteMeasuresService
        EpSolidWasteMeasuresEntity epSolidWasteMeasuresEntity_two = new EpSolidWasteMeasuresEntity();
        // 固体废物基础信息采集-污染防治措施表  相关数据存储
        for (EpSolidWasteMeasuresEntity epSolidWasteMeasuresEntity : solidWasteInformationCollection.getList()) {
            String uuid_two = UUIDTool.getUUID();
            ValidatorUtils.validateEntity(epSolidWasteMeasuresEntity, UpdateGroup.class);
            //如果type类型为3则存储的数据为 合规储存场所(设施)
            if (null != epSolidWasteMeasuresEntity.getType()) {
                if ("3".equals(epSolidWasteMeasuresEntity.getType())) {
                    epSolidWasteMeasuresEntity_two.setId(uuid_two);
                    epSolidWasteMeasuresEntity_two.setMainId(uuid);
                    epSolidWasteMeasuresEntity_two.setCompanyId(deptId);
                    epSolidWasteMeasuresEntity_two.setType(epSolidWasteMeasuresEntity.getType());
                    epSolidWasteMeasuresEntity_two.setWaste(epSolidWasteMeasuresEntity.getWaste());
                    epSolidWasteMeasuresEntity_two.setProcessingCapacity(epSolidWasteMeasuresEntity.getProcessingCapacity());
                    epSolidWasteMeasuresEntity_two.setMeasuresCode(epSolidWasteMeasuresEntity.getMeasuresCode());
                    epSolidWasteMeasuresEntity_two.setMeasuresName(epSolidWasteMeasuresEntity.getMeasuresName());
                    //设施基本情况（贮存设施) 独有
                    epSolidWasteMeasuresEntity_two.setMeasuresBasic(epSolidWasteMeasuresEntity.getMeasuresBasic());
                    epSolidWasteMeasuresService.insert(epSolidWasteMeasuresEntity_two);
                } else {
                    //如果不是 则 存储的是 合规综合利用设施、合规处置设施 数据
                    epSolidWasteMeasuresEntity_two.setId(uuid_two);
                    epSolidWasteMeasuresEntity_two.setMainId(uuid);
                    epSolidWasteMeasuresEntity_two.setCompanyId(deptId);
                    epSolidWasteMeasuresEntity_two.setMeasuresCode(epSolidWasteMeasuresEntity.getMeasuresCode());
                    epSolidWasteMeasuresEntity_two.setMeasuresName(epSolidWasteMeasuresEntity.getMeasuresName());
                    epSolidWasteMeasuresEntity_two.setMeasuresBasic(epSolidWasteMeasuresEntity.getMeasuresBasic());
                    epSolidWasteMeasuresEntity_two.setWaste(epSolidWasteMeasuresEntity.getWaste());
                    epSolidWasteMeasuresEntity_two.setEightCode(epSolidWasteMeasuresEntity.getWaste());
                    epSolidWasteMeasuresEntity_two.setWasteSource(epSolidWasteMeasuresEntity.getWasteSource());
                    //合规综合利用设施 独有-综合利用产物
                    epSolidWasteMeasuresEntity_two.setProduct(epSolidWasteMeasuresEntity.getProduct());
                    epSolidWasteMeasuresEntity_two.setMode(epSolidWasteMeasuresEntity.getMode());
                    epSolidWasteMeasuresEntity_two.setProcessingCapacity(epSolidWasteMeasuresEntity.getProcessingCapacity());
                    epSolidWasteMeasuresEntity_two.setType(epSolidWasteMeasuresEntity.getType());
                    epSolidWasteMeasuresService.insert(epSolidWasteMeasuresEntity_two);
                }
            }
        }
        return R.ok();

    }

}
