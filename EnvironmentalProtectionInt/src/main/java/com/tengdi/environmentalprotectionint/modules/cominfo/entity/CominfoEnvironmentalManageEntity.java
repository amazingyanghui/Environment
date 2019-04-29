package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;

/**
 * 环境管理属性
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:29
 */
@TableName("cominfo_environmental_manage")
public class CominfoEnvironmentalManageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 映射基本信息表主键（UUID）
	 */
	private String cid;
	/**
	 * 环保监管级别
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer regulatoryLevel;
	/**
	 * 环保监管级别name
	 */
	@TableField(exist = false)
	private String regulatoryLevelName;
	/**
	 * 环保监管年份
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer regulatoryYear;
	/**
	 * 环保监管年份name
	 */
	@TableField(exist = false)
	private String regulatoryYearName;
	/**
	 * 是否重点源
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer keySource;
	/**
	 * 是否重点源name
	 */
	@TableField(exist = false)
	private String keySourceName;
	/**
	 * 是否风险源
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer riskSource;
	/**
	 * 是否风险源name
	 */
	@TableField(exist = false)
	private String riskSourceName;
	/**
	 * 风险等级
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer riskRating;
	/**
	 * 风险等级name
	 */
	@TableField(exist = false)
	private String riskRatingName;
	/**
	 * 是否污水处理厂
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer sewagePlant;
	/**
	 * 是否污水处理厂name
	 */
	@TableField(exist = false)
	private String sewagePlantName;
	/**
	 * 是否废水排放企业
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer wasteWater;
	/**
	 * 是否废水排放企业name
	 */
	@TableField(exist = false)
	private String wasteWaterName;
	/**
	 * 是否废气排放企业
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer emissionEnterprises;
	/**
	 * 是否废气排放企业name
	 */
	@TableField(exist = false)
	private String emissionEnterprisesName;
	/**
	 * 是否涉源单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer sourceUnit;
	/**
	 * 是否涉源单位name
	 */
	@TableField(exist = false)
	private String sourceUnitName;
	/**
	 * 是否涉重金属排放企业
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer heavyMetal;
	/**
	 * 是否涉重金属排放企业name
	 */
	@TableField(exist = false)
	private String heavyMetalName;
	/**
	 * 是否通过清洁生产审核
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer cleanerProduction;
	/**
	 * 是否通过清洁生产审核name
	 */
	@TableField(exist = false)
	private String cleanerProductionName;
	/**
	 * 是否环境统计企业
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer environmentalStatistics;
	/**
	 * 是否环境统计企业
	 */
	@TableField(exist = false)
	private String environmentalStatisticsName;
	/**
	 * 是否在线监测企业
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer onlineMonitoring;
	/**
	 * 是否在线监测企业name
	 */
	@TableField(exist = false)
	private String onlineMonitoringName;
	/**
	 * 是否开征排污费
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer dischargeFee;
	/**
	 * 是否开征排污费name
	 */
	@TableField(exist = false)
	private String dischargeFeeName;
	/**
	 * 是否排污申报企业
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer emissionDeclaration;
	/**
	 * 是否排污申报企业name
	 */
	@TableField(exist = false)
	private String emissionDeclarationName;
	/**
	 * 是否固废经营单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer wasteManagement;
	/**
	 * 是否固废经营单位name
	 */
	@TableField(exist = false)
	private String wasteManagementName;
	/**
	 * 是否固废产生单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer wasteGeneration;
	/**
	 * 是否固废产生单位name
	 */
	@TableField(exist = false)
	private String wasteGenerationName;
	/**
	 * 是否30万千瓦以上电力企业
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer thirtykwCompany;
	/**
	 * 是否30万千瓦以上电力企业name
	 */
	@TableField(exist = false)
	private String thirtykwCompanyName;
	/**
	 * 电力企业装机容量（万千瓦）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String powerEnterprises;
	/**
	 * 是否参与随机抽查
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer randomCheck;
	/**
	 * 是否参与随机抽查name
	 */
	@TableField(exist = false)
	private String randomCheckName;
	/**
	 * 是否特殊源
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer specialSource;
	/**
	 * 是否特殊源name
	 */
	@TableField(exist = false)
	private String specialSourceName;
	/**
	 * 污染源信用评价等级
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer creditEvaluation;
	/**
	 * 污染源信用评价等级name
	 */
	@TableField(exist = false)
	private String creditEvaluationName;
	/**
	 * 污染源标签
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer sourceLabel;
	/**
	 * 污染源标签name
	 */
	@TableField(exist = false)
	private String sourceLabelName;
	/**
	 * 是否取消管理
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer cancelManagement;
	/**
	 * 是否取消管理name
	 */
	@TableField(exist = false)
	private String cancelManagementName;
	/**
	 * 创建时间
	 */
	private String createdate;
	/**
	 * 修改时间
	 */
	private String updatedate;
	/**
	 * 删除时间
	 */
	private String deletedate;
	/**
	 * 是否是voc排放企业
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer vocEnterprises;
	/**
	 * 是否是voc排放企业name
	 */
	@TableField(exist = false)
	private String vocEnterprisesName;
	/**
	 * 污染源类别
	 */
	@TableField(exist = false)
	private String sourcecategory ;

	/**
	 * 类别数量
	 */
	@TableField(exist = false)
	private String sourcecounts ;

	/**
	 *风险等级（统计返回）
	 */
	@TableField(exist = false)
	private String riskLevel;

	/**
	 * 风险等级企业数量
	 */
	@TableField(exist = false)
	private String riskCount;


	/**
	 * 企业规模类别
	 * @return
	 */
	@TableField(exist = false)
	private String enterpriseScale;
	/**
	 * 企业规模对应的企业数量
	 * @return
	 */
	@TableField(exist = false)
	private String enterpriseCount;

	/**
	 * 行业类别码
	 * @return
	 */
	@TableField(exist = false)
	private String industryCode ;

	/**
	 * 行业类别对应企业数量
	 * @return
	 */
	@TableField(exist = false)
	private String industryidCount ;

	/**
	 * 行业类别名称
	 * @return
	 */
	@TableField(exist = false)
	private String industryName ;

	/**
	 * 行业类别父类别
	 */
	@TableField(exist = false)
	private String parent ;

	/**
	 * 行业标识
	 */
	@TableField(exist = false)
	private String industryID ;

	/**
	 * 父级行业类别标识
	 */
	@TableField(exist = false)
	private String parname ;
	/**
	 *父行业类别名称
	 */
	@TableField(exist = false)
	private String parparent ;

	/**
	 * 是否通过ISO14000
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isiso;
	/**
	 * 是否通过ISO14000name
	 */
	@TableField(exist = false)
	private String isisoName;

	/**
	 * 是否采用抽样测算法计算
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isSampling;
	/**
	 * 是否采用抽样测算法计算name
	 */
	@TableField(exist = false)
	private String isSamplingName;
	/**
	 * 城乡污水集中处理场所
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String isSewagetreatmentSites;

	/**
	 * 是否从事海洋工程
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isOceaneering;
	/**
	 * 是否从事海洋工程name
	 */
	@TableField(exist = false)
	private String isOceaneeringName;
	/**
	 * 生活垃圾集中处理场所
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String isDomesticwasteSites;
	/**
	 * 危险废物集中处理场所
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String isHazardousWasteSites;

	public String getIsHazardousWasteSites() {
		return isHazardousWasteSites;
	}

	public void setIsHazardousWasteSites(String isHazardousWasteSites) {
		this.isHazardousWasteSites = isHazardousWasteSites;
	}

	/**
	 *是否有锅炉/燃气轮机
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isBoilerOrGasTurbine;
	/**
	 *是否有锅炉/燃气轮机name
	 */
	@TableField(exist = false)
	private String isBoilerOrGasTurbineName;
	/**
	 * 是否有工业炉窑
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isIndustrialFurnace;
	/**
	 * 是否有工业炉窑name
	 */
	@TableField(exist = false)
	private String isIndustrialFurnaceName;
	/**
	 * 是否有炼焦工序
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isCokingProcess;
	/**
	 * 是否有炼焦工序name
	 */
	@TableField(exist = false)
	private String isCokingProcessName;
	/**
	 * 是否有烧结/球团工序
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isSinterOrpelletizProcess;
	/**
	 * 是否有烧结/球团工序name
	 */
	@TableField(exist = false)
	private String isSinterOrpelletizProcessName;
	/**
	 * 是否有炼铁工序
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isIronmakingProcess;
	/**
	 * 是否有炼铁工序name
	 */
	@TableField(exist = false)
	private String isIronmakingProcessName;
	/**
	 * 是否有炼钢工序
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isSteelmakingProcess;
	/**
	 * 是否有炼钢工序name
	 */
	@TableField(exist = false)
	private String isSteelmakingProcessName;
	/**
	 * 是否有熟料生产
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isClinkerProduction;
	/**
	 * 是否有熟料生产name
	 */
	@TableField(exist = false)
	private String isClinkerProductionName;
	/**
	 * 是否为石化企业
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isPetrochemicalEnterprises;
	/**
	 * 是否为石化企业name
	 */
	@TableField(exist = false)
	private String isPetrochemicalEnterprisesName;
	/**
	 * 是否有有机液体储罐/装载
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isOrganicLiquidTankOrLoad;
	/**
	 * 是否有有机液体储罐/装载name
	 */
	@TableField(exist = false)
	private String isOrganicLiquidTankOrLoadName;
	/**
	 * 是否含挥发性有机物原辅材料使用
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isContainOrganicMaterialUse;
	/**
	 * 是否含挥发性有机物原辅材料使用name
	 */
	@TableField(exist = false)
	private String isContainOrganicMaterialUseName;
	/**
	 * 是否有工业固体物料堆存
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isSolidMaterialStorage;
	/**
	 * 是否有工业固体物料堆存name
	 */
	@TableField(exist = false)
	private String isSolidMaterialStorageName;
	/**
	 * 是否有其他生产废气
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isOtherWasteGasProduction;
	/**
	 * 是否有其他生产废气name
	 */
	@TableField(exist = false)
	private String isOtherWasteGasProductionName;
	/**
	 * 是否有一般工业固体废物
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isGeneralIndustrialSolidWaste;
	/**
	 * 是否有一般工业固体废物name
	 */
	@TableField(exist = false)
	private String isGeneralIndustrialSolidWasteName;
	/**
	 * 是否涉及稀土等15类矿产
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isInvolvingMinerals;
	/**
	 * 是否涉及稀土等15类矿产name
	 */
	@TableField(exist = false)
	private String isInvolvingMineralsName;
	/**
	 * 是否发放排污许可证
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isGrantDischargePermit;
	/**
	 * 是否发放排污许可证name
	 */
	@TableField(exist = false)
	private String isGrantDischargePermitName;
	/**
	 * 排污许可证编号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String dischargePermitCode;

	public String getIsisoName() {
		return isisoName;
	}

	public void setIsisoName(String isisoName) {
		this.isisoName = isisoName;
	}

	public String getIsSamplingName() {
		return isSamplingName;
	}

	public void setIsSamplingName(String isSamplingName) {
		this.isSamplingName = isSamplingName;
	}

	public String getIsOceaneeringName() {
		return isOceaneeringName;
	}

	public void setIsOceaneeringName(String isOceaneeringName) {
		this.isOceaneeringName = isOceaneeringName;
	}

	public String getIsBoilerOrGasTurbineName() {
		return isBoilerOrGasTurbineName;
	}

	public void setIsBoilerOrGasTurbineName(String isBoilerOrGasTurbineName) {
		this.isBoilerOrGasTurbineName = isBoilerOrGasTurbineName;
	}

	public String getIsIndustrialFurnaceName() {
		return isIndustrialFurnaceName;
	}

	public void setIsIndustrialFurnaceName(String isIndustrialFurnaceName) {
		this.isIndustrialFurnaceName = isIndustrialFurnaceName;
	}

	public String getIsCokingProcessName() {
		return isCokingProcessName;
	}

	public void setIsCokingProcessName(String isCokingProcessName) {
		this.isCokingProcessName = isCokingProcessName;
	}

	public String getIsSinterOrpelletizProcessName() {
		return isSinterOrpelletizProcessName;
	}

	public void setIsSinterOrpelletizProcessName(String isSinterOrpelletizProcessName) {
		this.isSinterOrpelletizProcessName = isSinterOrpelletizProcessName;
	}

	public String getIsIronmakingProcessName() {
		return isIronmakingProcessName;
	}

	public void setIsIronmakingProcessName(String isIronmakingProcessName) {
		this.isIronmakingProcessName = isIronmakingProcessName;
	}

	public String getIsSteelmakingProcessName() {
		return isSteelmakingProcessName;
	}

	public void setIsSteelmakingProcessName(String isSteelmakingProcessName) {
		this.isSteelmakingProcessName = isSteelmakingProcessName;
	}

	public String getIsClinkerProductionName() {
		return isClinkerProductionName;
	}

	public void setIsClinkerProductionName(String isClinkerProductionName) {
		this.isClinkerProductionName = isClinkerProductionName;
	}

	public String getIsPetrochemicalEnterprisesName() {
		return isPetrochemicalEnterprisesName;
	}

	public void setIsPetrochemicalEnterprisesName(String isPetrochemicalEnterprisesName) {
		this.isPetrochemicalEnterprisesName = isPetrochemicalEnterprisesName;
	}

	public String getIsOrganicLiquidTankOrLoadName() {
		return isOrganicLiquidTankOrLoadName;
	}

	public void setIsOrganicLiquidTankOrLoadName(String isOrganicLiquidTankOrLoadName) {
		this.isOrganicLiquidTankOrLoadName = isOrganicLiquidTankOrLoadName;
	}

	public String getIsContainOrganicMaterialUseName() {
		return isContainOrganicMaterialUseName;
	}

	public void setIsContainOrganicMaterialUseName(String isContainOrganicMaterialUseName) {
		this.isContainOrganicMaterialUseName = isContainOrganicMaterialUseName;
	}

	public String getIsSolidMaterialStorageName() {
		return isSolidMaterialStorageName;
	}

	public void setIsSolidMaterialStorageName(String isSolidMaterialStorageName) {
		this.isSolidMaterialStorageName = isSolidMaterialStorageName;
	}

	public String getIsOtherWasteGasProductionName() {
		return isOtherWasteGasProductionName;
	}

	public void setIsOtherWasteGasProductionName(String isOtherWasteGasProductionName) {
		this.isOtherWasteGasProductionName = isOtherWasteGasProductionName;
	}

	public String getIsGeneralIndustrialSolidWasteName() {
		return isGeneralIndustrialSolidWasteName;
	}

	public void setIsGeneralIndustrialSolidWasteName(String isGeneralIndustrialSolidWasteName) {
		this.isGeneralIndustrialSolidWasteName = isGeneralIndustrialSolidWasteName;
	}

	public String getIsInvolvingMineralsName() {
		return isInvolvingMineralsName;
	}

	public void setIsInvolvingMineralsName(String isInvolvingMineralsName) {
		this.isInvolvingMineralsName = isInvolvingMineralsName;
	}

	public String getIsGrantDischargePermitName() {
		return isGrantDischargePermitName;
	}

	public void setIsGrantDischargePermitName(String isGrantDischargePermitName) {
		this.isGrantDischargePermitName = isGrantDischargePermitName;
	}

	public Integer getIsBoilerOrGasTurbine() {
		return isBoilerOrGasTurbine;
	}

	public void setIsBoilerOrGasTurbine(Integer isBoilerOrGasTurbine) {
		this.isBoilerOrGasTurbine = isBoilerOrGasTurbine;
	}

	public Integer getIsIndustrialFurnace() {
		return isIndustrialFurnace;
	}

	public void setIsIndustrialFurnace(Integer isIndustrialFurnace) {
		this.isIndustrialFurnace = isIndustrialFurnace;
	}

	public Integer getIsCokingProcess() {
		return isCokingProcess;
	}

	public void setIsCokingProcess(Integer isCokingProcess) {
		this.isCokingProcess = isCokingProcess;
	}

	public Integer getIsSinterOrpelletizProcess() {
		return isSinterOrpelletizProcess;
	}

	public void setIsSinterOrpelletizProcess(Integer isSinterOrpelletizProcess) {
		this.isSinterOrpelletizProcess = isSinterOrpelletizProcess;
	}

	public Integer getIsIronmakingProcess() {
		return isIronmakingProcess;
	}

	public void setIsIronmakingProcess(Integer isIronmakingProcess) {
		this.isIronmakingProcess = isIronmakingProcess;
	}

	public Integer getIsSteelmakingProcess() {
		return isSteelmakingProcess;
	}

	public void setIsSteelmakingProcess(Integer isSteelmakingProcess) {
		this.isSteelmakingProcess = isSteelmakingProcess;
	}

	public Integer getIsClinkerProduction() {
		return isClinkerProduction;
	}

	public void setIsClinkerProduction(Integer isClinkerProduction) {
		this.isClinkerProduction = isClinkerProduction;
	}

	public Integer getIsPetrochemicalEnterprises() {
		return isPetrochemicalEnterprises;
	}

	public void setIsPetrochemicalEnterprises(Integer isPetrochemicalEnterprises) {
		this.isPetrochemicalEnterprises = isPetrochemicalEnterprises;
	}

	public Integer getIsOrganicLiquidTankOrLoad() {
		return isOrganicLiquidTankOrLoad;
	}

	public void setIsOrganicLiquidTankOrLoad(Integer isOrganicLiquidTankOrLoad) {
		this.isOrganicLiquidTankOrLoad = isOrganicLiquidTankOrLoad;
	}

	public Integer getIsContainOrganicMaterialUse() {
		return isContainOrganicMaterialUse;
	}

	public void setIsContainOrganicMaterialUse(Integer isContainOrganicMaterialUse) {
		this.isContainOrganicMaterialUse = isContainOrganicMaterialUse;
	}

	public Integer getIsSolidMaterialStorage() {
		return isSolidMaterialStorage;
	}

	public void setIsSolidMaterialStorage(Integer isSolidMaterialStorage) {
		this.isSolidMaterialStorage = isSolidMaterialStorage;
	}

	public Integer getIsOtherWasteGasProduction() {
		return isOtherWasteGasProduction;
	}

	public void setIsOtherWasteGasProduction(Integer isOtherWasteGasProduction) {
		this.isOtherWasteGasProduction = isOtherWasteGasProduction;
	}

	public Integer getIsGeneralIndustrialSolidWaste() {
		return isGeneralIndustrialSolidWaste;
	}

	public void setIsGeneralIndustrialSolidWaste(Integer isGeneralIndustrialSolidWaste) {
		this.isGeneralIndustrialSolidWaste = isGeneralIndustrialSolidWaste;
	}

	public Integer getIsInvolvingMinerals() {
		return isInvolvingMinerals;
	}

	public void setIsInvolvingMinerals(Integer isInvolvingMinerals) {
		this.isInvolvingMinerals = isInvolvingMinerals;
	}

	public Integer getIsGrantDischargePermit() {
		return isGrantDischargePermit;
	}

	public void setIsGrantDischargePermit(Integer isGrantDischargePermit) {
		this.isGrantDischargePermit = isGrantDischargePermit;
	}

	public String getDischargePermitCode() {
		return dischargePermitCode;
	}

	public void setDischargePermitCode(String dischargePermitCode) {
		this.dischargePermitCode = dischargePermitCode;
	}

	public Integer getIsSampling() {
		return isSampling;
	}

	public void setIsSampling(Integer isSampling) {
		this.isSampling = isSampling;
	}

	public String getIsSewagetreatmentSites() {
		return isSewagetreatmentSites;
	}

	public void setIsSewagetreatmentSites(String isSewagetreatmentSites) {
		this.isSewagetreatmentSites = isSewagetreatmentSites;
	}

	public Integer getIsOceaneering() {
		return isOceaneering;
	}

	public void setIsOceaneering(Integer isOceaneering) {
		this.isOceaneering = isOceaneering;
	}

	public String getIsDomesticwasteSites() {
		return isDomesticwasteSites;
	}

	public void setIsDomesticwasteSites(String isDomesticwasteSites) {
		this.isDomesticwasteSites = isDomesticwasteSites;
	}

	/**
	 * 设置：主键UUID
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：主键UUID
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：映射基本信息表主键（UUID）
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：映射基本信息表主键（UUID）
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：环保监管级别
	 */
	public void setRegulatoryLevel(Integer regulatoryLevel) {
		this.regulatoryLevel = regulatoryLevel;
	}
	/**
	 * 获取：环保监管级别
	 */
	public Integer getRegulatoryLevel() {
		return regulatoryLevel;
	}
	/**
	 * 设置：环保监管年份
	 */
	public void setRegulatoryYear(Integer regulatoryYear) {
		this.regulatoryYear = regulatoryYear;
	}
	/**
	 * 获取：环保监管年份
	 */
	public Integer getRegulatoryYear() {
		return regulatoryYear;
	}
	/**
	 * 设置：是否重点源
	 */
	public void setKeySource(Integer keySource) {
		this.keySource = keySource;
	}
	/**
	 * 获取：是否重点源
	 */
	public Integer getKeySource() {
		return keySource;
	}
	/**
	 * 设置：是否风险源
	 */
	public void setRiskSource(Integer riskSource) {
		this.riskSource = riskSource;
	}
	/**
	 * 获取：是否风险源
	 */
	public Integer getRiskSource() {
		return riskSource;
	}
	/**
	 * 设置：是否污水处理厂
	 */
	public void setSewagePlant(Integer sewagePlant) {
		this.sewagePlant = sewagePlant;
	}
	/**
	 * 获取：是否污水处理厂
	 */
	public Integer getSewagePlant() {
		return sewagePlant;
	}
	/**
	 * 设置：是否废水排放企业
	 */
	public void setWasteWater(Integer wasteWater) {
		this.wasteWater = wasteWater;
	}
	/**
	 * 获取：是否废水排放企业
	 */
	public Integer getWasteWater() {
		return wasteWater;
	}
	/**
	 * 设置：是否废气排放企业
	 */
	public void setEmissionEnterprises(Integer emissionEnterprises) {
		this.emissionEnterprises = emissionEnterprises;
	}
	/**
	 * 获取：是否废气排放企业
	 */
	public Integer getEmissionEnterprises() {
		return emissionEnterprises;
	}
	/**
	 * 设置：是否涉源单位
	 */
	public void setSourceUnit(Integer sourceUnit) {
		this.sourceUnit = sourceUnit;
	}
	/**
	 * 获取：是否涉源单位
	 */
	public Integer getSourceUnit() {
		return sourceUnit;
	}
	/**
	 * 设置：是否涉重金属排放企业
	 */
	public void setHeavyMetal(Integer heavyMetal) {
		this.heavyMetal = heavyMetal;
	}
	/**
	 * 获取：是否涉重金属排放企业
	 */
	public Integer getHeavyMetal() {
		return heavyMetal;
	}
	/**
	 * 设置：是否通过清洁生产审核
	 */
	public void setCleanerProduction(Integer cleanerProduction) {
		this.cleanerProduction = cleanerProduction;
	}
	/**
	 * 获取：是否通过清洁生产审核
	 */
	public Integer getCleanerProduction() {
		return cleanerProduction;
	}
	/**
	 * 设置：是否环境统计企业
	 */

	/**
	 * 获取：是否环境统计企业
	 */
	public Integer getEnvironmentalStatistics() {
		return environmentalStatistics;
	}
	/**
	 * 设置：是否在线监测企业
	 */
	public void setOnlineMonitoring(Integer onlineMonitoring) {
		this.onlineMonitoring = onlineMonitoring;
	}
	/**
	 * 获取：是否在线监测企业
	 */
	public Integer getOnlineMonitoring() {
		return onlineMonitoring;
	}
	/**
	 * 设置：是否开征排污费
	 */
	public void setDischargeFee(Integer dischargeFee) {
		this.dischargeFee = dischargeFee;
	}
	/**
	 * 获取：是否开征排污费
	 */
	public Integer getDischargeFee() {
		return dischargeFee;
	}
	/**
	 * 设置：是否排污申报企业
	 */
	public void setEmissionDeclaration(Integer emissionDeclaration) {
		this.emissionDeclaration = emissionDeclaration;
	}
	/**
	 * 获取：是否排污申报企业
	 */
	public Integer getEmissionDeclaration() {
		return emissionDeclaration;
	}
	/**
	 * 设置：是否固废经营单位
	 */
	public void setWasteManagement(Integer wasteManagement) {
		this.wasteManagement = wasteManagement;
	}
	/**
	 * 获取：是否固废经营单位
	 */
	public Integer getWasteManagement() {
		return wasteManagement;
	}
	/**
	 * 设置：是否固废产生单位
	 */
	public void setWasteGeneration(Integer wasteGeneration) {
		this.wasteGeneration = wasteGeneration;
	}
	/**
	 * 获取：是否固废产生单位
	 */
	public Integer getWasteGeneration() {
		return wasteGeneration;
	}
	/**
	 * 设置：是否30万千瓦以上电力企业
	 */
	public void setThirtykwCompany(Integer thirtykwCompany) {
		this.thirtykwCompany = thirtykwCompany;
	}
	/**
	 * 获取：是否30万千瓦以上电力企业
	 */
	public Integer getThirtykwCompany() {
		return thirtykwCompany;
	}
	/**
	 * 获取：电力企业装机容量（万千瓦）
	 */
	public String getPowerEnterprises() {
		return powerEnterprises;
	}
	/**
	 * 设置：电力企业装机容量（万千瓦）
	 */
	public void setPowerEnterprises(String powerEnterprises) {
		this.powerEnterprises = powerEnterprises;
	}
	/**
	 * 设置：是否参与随机抽查
	 */
	public void setRandomCheck(Integer randomCheck) {
		this.randomCheck = randomCheck;
	}
	/**
	 * 获取：是否参与随机抽查
	 */
	public Integer getRandomCheck() {
		return randomCheck;
	}
	/**
	 * 设置：是否特殊源
	 */
	public void setSpecialSource(Integer specialSource) {
		this.specialSource = specialSource;
	}
	/**
	 * 获取：是否特殊源
	 */
	public Integer getSpecialSource() {
		return specialSource;
	}
	/**
	 * 设置：污染源信用评价等级
	 */
	public void setCreditEvaluation(Integer creditEvaluation) {
		this.creditEvaluation = creditEvaluation;
	}
	/**
	 * 获取：污染源信用评价等级
	 */
	public Integer getCreditEvaluation() {
		return creditEvaluation;
	}
	/**
	 * 设置：污染源标签
	 */
	public void setSourceLabel(Integer sourceLabel) {
		this.sourceLabel = sourceLabel;
	}
	/**
	 * 获取：污染源标签
	 */
	public Integer getSourceLabel() {
		return sourceLabel;
	}
	/**
	 * 设置：是否取消管理
	 */
	public void setCancelManagement(Integer cancelManagement) {
		this.cancelManagement = cancelManagement;
	}
	/**
	 * 获取：是否取消管理
	 */
	public Integer getCancelManagement() {
		return cancelManagement;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：修改时间
	 */
	public String getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeletedate(String deletedate) {
		this.deletedate = deletedate;
	}
	/**
	 * 获取：删除时间
	 */
	public String getDeletedate() {
		return deletedate;
	}

	public String getRegulatoryLevelName() {
		return regulatoryLevelName;
	}

	public void setRegulatoryLevelName(String regulatoryLevelName) {
		this.regulatoryLevelName = regulatoryLevelName;
	}

	public String getRegulatoryYearName() {
		return regulatoryYearName;
	}

	public void setRegulatoryYearName(String regulatoryYearName) {
		this.regulatoryYearName = regulatoryYearName;
	}

	public String getKeySourceName() {
		return keySourceName;
	}

	public void setKeySourceName(String keySourceName) {
		this.keySourceName = keySourceName;
	}

	public String getRiskSourceName() {
		return riskSourceName;
	}

	public void setRiskSourceName(String riskSourceName) {
		this.riskSourceName = riskSourceName;
	}

	public String getRiskRatingName() {
		return riskRatingName;
	}

	public void setRiskRatingName(String riskRatingName) {
		this.riskRatingName = riskRatingName;
	}

	public String getSewagePlantName() {
		return sewagePlantName;
	}

	public void setSewagePlantName(String sewagePlantName) {
		this.sewagePlantName = sewagePlantName;
	}

	public String getWasteWaterName() {
		return wasteWaterName;
	}

	public void setWasteWaterName(String wasteWaterName) {
		this.wasteWaterName = wasteWaterName;
	}

	public String getEmissionEnterprisesName() {
		return emissionEnterprisesName;
	}

	public void setEmissionEnterprisesName(String emissionEnterprisesName) {
		this.emissionEnterprisesName = emissionEnterprisesName;
	}

	public String getSourceUnitName() {
		return sourceUnitName;
	}

	public void setSourceUnitName(String sourceUnitName) {
		this.sourceUnitName = sourceUnitName;
	}

	public String getHeavyMetalName() {
		return heavyMetalName;
	}

	public void setHeavyMetalName(String heavyMetalName) {
		this.heavyMetalName = heavyMetalName;
	}

	public String getCleanerProductionName() {
		return cleanerProductionName;
	}

	public void setCleanerProductionName(String cleanerProductionName) {
		this.cleanerProductionName = cleanerProductionName;
	}

	public String getEnvironmentalStatisticsName() {
		return environmentalStatisticsName;
	}

	public void setEnvironmentalStatisticsName(String environmentalStatisticsName) {
		this.environmentalStatisticsName = environmentalStatisticsName;
	}

	public String getOnlineMonitoringName() {
		return onlineMonitoringName;
	}

	public void setOnlineMonitoringName(String onlineMonitoringName) {
		this.onlineMonitoringName = onlineMonitoringName;
	}

	public String getDischargeFeeName() {
		return dischargeFeeName;
	}

	public void setDischargeFeeName(String dischargeFeeName) {
		this.dischargeFeeName = dischargeFeeName;
	}

	public String getEmissionDeclarationName() {
		return emissionDeclarationName;
	}

	public void setEmissionDeclarationName(String emissionDeclarationName) {
		this.emissionDeclarationName = emissionDeclarationName;
	}

	public String getWasteManagementName() {
		return wasteManagementName;
	}

	public void setWasteManagementName(String wasteManagementName) {
		this.wasteManagementName = wasteManagementName;
	}

	public String getWasteGenerationName() {
		return wasteGenerationName;
	}

	public void setWasteGenerationName(String wasteGenerationName) {
		this.wasteGenerationName = wasteGenerationName;
	}

	public String getThirtykwCompanyName() {
		return thirtykwCompanyName;
	}

	public void setThirtykwCompanyName(String thirtykwCompanyName) {
		this.thirtykwCompanyName = thirtykwCompanyName;
	}

	public String getRandomCheckName() {
		return randomCheckName;
	}

	public void setRandomCheckName(String randomCheckName) {
		this.randomCheckName = randomCheckName;
	}

	public String getSpecialSourceName() {
		return specialSourceName;
	}

	public void setSpecialSourceName(String specialSourceName) {
		this.specialSourceName = specialSourceName;
	}

	public String getCreditEvaluationName() {
		return creditEvaluationName;
	}

	public void setCreditEvaluationName(String creditEvaluationName) {
		this.creditEvaluationName = creditEvaluationName;
	}

	public String getSourceLabelName() {
		return sourceLabelName;
	}

	public void setSourceLabelName(String sourceLabelName) {
		this.sourceLabelName = sourceLabelName;
	}

	public String getCancelManagementName() {
		return cancelManagementName;
	}

	public void setCancelManagementName(String cancelManagementName) {
		this.cancelManagementName = cancelManagementName;
	}
	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getRiskCount() {
		return riskCount;
	}

	public void setRiskCount(String riskCount) {
		this.riskCount = riskCount;
	}
	public String getSourcecategory() {
		return sourcecategory;
	}

	public void setSourcecategory(String sourcecategory) {
		this.sourcecategory = sourcecategory;
	}

	public String getSourcecounts() {
		return sourcecounts;
	}

	public void setSourcecounts(String sourcecounts) {
		this.sourcecounts = sourcecounts;
	}
	public String getEnterpriseScale() {
		return enterpriseScale;
	}


	public void setEnterpriseScale(String enterpriseScale) {
		this.enterpriseScale = enterpriseScale;
	}

	public String getEnterpriseCount() {
		return enterpriseCount;
	}

	public void setEnterpriseCount(String enterpriseCount) {
		this.enterpriseCount = enterpriseCount;
	}

	public String getVocEnterprisesName() {
		return vocEnterprisesName;
	}

	public void setVocEnterprisesName(String vocEnterprisesName) {
		this.vocEnterprisesName = vocEnterprisesName;
	}

	public Integer getVocEnterprises() {
		return vocEnterprises;
	}

	public void setVocEnterprises(Integer vocEnterprises) {
		this.vocEnterprises = vocEnterprises;
	}

	public Integer getRiskRating() {
		return riskRating;
	}

	public void setRiskRating(Integer riskRating) {
		this.riskRating = riskRating;
	}
	public void setEnvironmentalStatistics(Integer environmentalStatistics) {
		this.environmentalStatistics = environmentalStatistics;
	}


	public String getIndustryidCount() {
		return industryidCount;
	}

	public void setIndustryidCount(String industryidCount) {
		this.industryidCount = industryidCount;
	}

	public String getIndustryCode() {
		return industryCode;
	}

	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}


	public String getIndustryID() {
		return industryID;
	}

	public void setIndustryID(String industryID) {
		this.industryID = industryID;
	}

	public String getParname() {
		return parname;
	}

	public void setParname(String parname) {
		this.parname = parname;
	}

	public String getParparent() {
		return parparent;
	}

	public void setParparent(String parparent) {
		this.parparent = parparent;
	}

	public Integer getIsiso() {
		return isiso;
	}

	public void setIsiso(Integer isiso) {
		this.isiso = isiso;
	}
}
