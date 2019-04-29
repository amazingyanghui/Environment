package com.tengdi.environmentalprotectionint.modules.emergency.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.tengdi.core.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 风险防范措施
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-13 10:36:05
 */
@TableName("risk_prevention_measures")
public class RiskPreventionMeasuresEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键（UUID）
	 */
	@TableId
	private String pid;
	/**
	 * 企业ID
	 */
	private String cid;
	/**
	 * 年度
	 */
	private String year;
	/**
	 * 风险单元名称
	 */
	private String unitName;
	/**
	 * 主要化学物质_名称
	 */
	private String mainChemicalName;
	/**
	 * 主要化学物质_现存量(吨)
	 */
	private String mainChemicalStock;
	/**
	 * 主要化学物质_最大存储量(吨)
	 */
	private String maxStorageCapacity;
	/**
	 * 风险特征(0反应条件条件高温高压;1易燃易爆;2化学物质易泄漏;3其他)
	 */
	private String riskProfiles;
	/**
	 * 风险特征其他的名称
	 */
	private String riskProfilesOtherName;
	/**
	 * 围堰(0无； 1有)
	 */
	private String cofferdam;
	/**
	 * 围堰的有效面积
	 */
	private String cofferdamEffectiveArea;
	/**
	 * 专用排泄沟/管(0无1有)
	 */
	private String specialDrainageDitch;
	/**
	 * 地面防渗(0无1有)
	 */
	private String groundSeepageControl;
	/**
	 * 地面防渗材料
	 */
	private String imperviousMaterial;
	/**
	 * 气/液体泄漏侦测(0无;1有)
	 */
	private String leakDetection;
	/**
	 * 报警系统是否接入远程监控网(0无1有)
	 */
	private String isRemoteMonitor;
	/**
	 * 泄漏气体吸收装置
	 */
	private String gasAbsorptionDevice;
	/**
	 * 事故废水排放去向(0进入厂区的污水处理系统;1进入事故应急池;2进入清净下水系统或雨水排水系统;3其他)
	 */
	private String fateType;
	/**
	 * 事故废水排放其他去向
	 */
	private String otherFateType;
	/**
	 * 事故应急池(0无1有)
	 */
	private String emergencyPool;
	/**
	 * 事故应急池容积
	 */
	private String emergencyPoolVolume;
	/**
	 * 清净下水排放切换阀门(0无 1有)
	 */
	private String isChangeValve;
	/**
	 * 清净下水排水缓冲池(0无1有)
	 */
	private String isBufferPool;
	/**
	 * 清净下水排水缓冲池容积
	 */
	private String bufferPoolArea;
	/**
	 * 毒性气体泄漏监控预警措施
	 */
	private String gasLeakMonitorwarningMeasures;
	/**
	 * 截流措施情况
	 */
	private String closureMeasures;
	/**
	 * 事故废水收集措施
	 */
	private String accidentWastewaterCollectionMeasures;
	/**
	 * 清净废水系统风险防控措施
	 */
	private String cleanWaterPreventionMeasures;
	/**
	 * 雨水排水系统风险防控措施
	 */
	private String rainPreventionMeasures;
	/**
	 * 依法获取污水排入排水管网许可
	 */
	private String productionWastewaterPreventionMeasures;
	/**
	 * 生产废水处理系统风险防控措施
	 */
	private String pipeNetworkPermit;
	/**
	 * 厂内危险废物环境管理
	 */
	private String environmentalManagement;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 创建时间
	 */
	private Date createdate;

	/**
	 * 创建时间
	 */
	@TableField(exist = false)
	private String createdatestr;
	/**
	 * 更新时间
	 */
	private Date updatedate;
	/**
	 * 删除时间
	 */
	private Date deletedate;
	/**
	 * 单位名称
	 */
	@TableField(exist = false)
	private String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 设置：主键（UUID）
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * 获取：主键（UUID）
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * 设置：企业ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：企业ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：年度
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取：年度
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 设置：风险单元名称
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	/**
	 * 获取：风险单元名称
	 */
	public String getUnitName() {
		return unitName;
	}
	/**
	 * 设置：主要化学物质_名称
	 */
	public void setMainChemicalName(String mainChemicalName) {
		this.mainChemicalName = mainChemicalName;
	}
	/**
	 * 获取：主要化学物质_名称
	 */
	public String getMainChemicalName() {
		return mainChemicalName;
	}
	/**
	 * 设置：主要化学物质_现存量(吨)
	 */
	public void setMainChemicalStock(String mainChemicalStock) {
		this.mainChemicalStock = mainChemicalStock;
	}
	/**
	 * 获取：主要化学物质_现存量(吨)
	 */
	public String getMainChemicalStock() {
		return mainChemicalStock;
	}
	/**
	 * 设置：主要化学物质_最大存储量(吨)
	 */
	public void setMaxStorageCapacity(String maxStorageCapacity) {
		this.maxStorageCapacity = maxStorageCapacity;
	}
	/**
	 * 获取：主要化学物质_最大存储量(吨)
	 */
	public String getMaxStorageCapacity() {
		return maxStorageCapacity;
	}
	/**
	 * 设置：风险特征(0反应条件条件高温高压;1易燃易爆;2化学物质易泄漏;3其他)
	 */
	public void setRiskProfiles(String riskProfiles) {
		this.riskProfiles = riskProfiles;
	}
	/**
	 * 获取：风险特征(0反应条件条件高温高压;1易燃易爆;2化学物质易泄漏;3其他)
	 */
	public String getRiskProfiles() {
		return riskProfiles;
	}
	/**
	 * 设置：风险特征其他的名称
	 */
	public void setRiskProfilesOtherName(String riskProfilesOtherName) {
		this.riskProfilesOtherName = riskProfilesOtherName;
	}
	/**
	 * 获取：风险特征其他的名称
	 */
	public String getRiskProfilesOtherName() {
		return riskProfilesOtherName;
	}
	/**
	 * 设置：围堰(0无； 1有)
	 */
	public void setCofferdam(String cofferdam) {
		this.cofferdam = cofferdam;
	}
	/**
	 * 获取：围堰(0无； 1有)
	 */
	public String getCofferdam() {
		return cofferdam;
	}
	/**
	 * 设置：围堰的有效面积
	 */
	public void setCofferdamEffectiveArea(String cofferdamEffectiveArea) {
		this.cofferdamEffectiveArea = cofferdamEffectiveArea;
	}
	/**
	 * 获取：围堰的有效面积
	 */
	public String getCofferdamEffectiveArea() {
		return cofferdamEffectiveArea;
	}
	/**
	 * 设置：专用排泄沟/管(0无1有)
	 */
	public void setSpecialDrainageDitch(String specialDrainageDitch) {
		this.specialDrainageDitch = specialDrainageDitch;
	}
	/**
	 * 获取：专用排泄沟/管(0无1有)
	 */
	public String getSpecialDrainageDitch() {
		return specialDrainageDitch;
	}
	/**
	 * 设置：地面防渗(0无1有)
	 */
	public void setGroundSeepageControl(String groundSeepageControl) {
		this.groundSeepageControl = groundSeepageControl;
	}
	/**
	 * 获取：地面防渗(0无1有)
	 */
	public String getGroundSeepageControl() {
		return groundSeepageControl;
	}
	/**
	 * 设置：地面防渗材料
	 */
	public void setImperviousMaterial(String imperviousMaterial) {
		this.imperviousMaterial = imperviousMaterial;
	}
	/**
	 * 获取：地面防渗材料
	 */
	public String getImperviousMaterial() {
		return imperviousMaterial;
	}
	/**
	 * 设置：气/液体泄漏侦测(0无;1有)
	 */
	public void setLeakDetection(String leakDetection) {
		this.leakDetection = leakDetection;
	}
	/**
	 * 获取：气/液体泄漏侦测(0无;1有)
	 */
	public String getLeakDetection() {
		return leakDetection;
	}
	/**
	 * 设置：报警系统是否接入远程监控网(0无1有)
	 */
	public void setIsRemoteMonitor(String isRemoteMonitor) {
		this.isRemoteMonitor = isRemoteMonitor;
	}
	/**
	 * 获取：报警系统是否接入远程监控网(0无1有)
	 */
	public String getIsRemoteMonitor() {
		return isRemoteMonitor;
	}
	/**
	 * 设置：泄漏气体吸收装置
	 */
	public void setGasAbsorptionDevice(String gasAbsorptionDevice) {
		this.gasAbsorptionDevice = gasAbsorptionDevice;
	}
	/**
	 * 获取：泄漏气体吸收装置
	 */
	public String getGasAbsorptionDevice() {
		return gasAbsorptionDevice;
	}
	/**
	 * 设置：事故废水排放去向(0进入厂区的污水处理系统;1进入事故应急池;2进入清净下水系统或雨水排水系统;3其他)
	 */
	public void setFateType(String fateType) {
		this.fateType = fateType;
	}
	/**
	 * 获取：事故废水排放去向(0进入厂区的污水处理系统;1进入事故应急池;2进入清净下水系统或雨水排水系统;3其他)
	 */
	public String getFateType() {
		return fateType;
	}
	/**
	 * 设置：事故废水排放其他去向
	 */
	public void setOtherFateType(String otherFateType) {
		this.otherFateType = otherFateType;
	}
	/**
	 * 获取：事故废水排放其他去向
	 */
	public String getOtherFateType() {
		return otherFateType;
	}
	/**
	 * 设置：事故应急池(0无1有)
	 */
	public void setEmergencyPool(String emergencyPool) {
		this.emergencyPool = emergencyPool;
	}
	/**
	 * 获取：事故应急池(0无1有)
	 */
	public String getEmergencyPool() {
		return emergencyPool;
	}
	/**
	 * 设置：事故应急池容积
	 */
	public void setEmergencyPoolVolume(String emergencyPoolVolume) {
		this.emergencyPoolVolume = emergencyPoolVolume;
	}
	/**
	 * 获取：事故应急池容积
	 */
	public String getEmergencyPoolVolume() {
		return emergencyPoolVolume;
	}
	/**
	 * 设置：清净下水排放切换阀门(0无 1有)
	 */
	public void setIsChangeValve(String isChangeValve) {
		this.isChangeValve = isChangeValve;
	}
	/**
	 * 获取：清净下水排放切换阀门(0无 1有)
	 */
	public String getIsChangeValve() {
		return isChangeValve;
	}
	/**
	 * 设置：清净下水排水缓冲池(0无1有)
	 */
	public void setIsBufferPool(String isBufferPool) {
		this.isBufferPool = isBufferPool;
	}
	/**
	 * 获取：清净下水排水缓冲池(0无1有)
	 */
	public String getIsBufferPool() {
		return isBufferPool;
	}
	/**
	 * 设置：清净下水排水缓冲池容积
	 */
	public void setBufferPoolArea(String bufferPoolArea) {
		this.bufferPoolArea = bufferPoolArea;
	}
	/**
	 * 获取：清净下水排水缓冲池容积
	 */
	public String getBufferPoolArea() {
		return bufferPoolArea;
	}
	/**
	 * 设置：毒性气体泄漏监控预警措施
	 */
	public void setGasLeakMonitorwarningMeasures(String gasLeakMonitorwarningMeasures) {
		this.gasLeakMonitorwarningMeasures = gasLeakMonitorwarningMeasures;
	}
	/**
	 * 获取：毒性气体泄漏监控预警措施
	 */
	public String getGasLeakMonitorwarningMeasures() {
		return gasLeakMonitorwarningMeasures;
	}
	/**
	 * 设置：截流措施情况
	 */
	public void setClosureMeasures(String closureMeasures) {
		this.closureMeasures = closureMeasures;
	}
	/**
	 * 获取：截流措施情况
	 */
	public String getClosureMeasures() {
		return closureMeasures;
	}
	/**
	 * 设置：事故废水收集措施
	 */
	public void setAccidentWastewaterCollectionMeasures(String accidentWastewaterCollectionMeasures) {
		this.accidentWastewaterCollectionMeasures = accidentWastewaterCollectionMeasures;
	}
	/**
	 * 获取：事故废水收集措施
	 */
	public String getAccidentWastewaterCollectionMeasures() {
		return accidentWastewaterCollectionMeasures;
	}
	/**
	 * 设置：清净废水系统风险防控措施
	 */
	public void setCleanWaterPreventionMeasures(String cleanWaterPreventionMeasures) {
		this.cleanWaterPreventionMeasures = cleanWaterPreventionMeasures;
	}
	/**
	 * 获取：清净废水系统风险防控措施
	 */
	public String getCleanWaterPreventionMeasures() {
		return cleanWaterPreventionMeasures;
	}
	/**
	 * 设置：雨水排水系统风险防控措施
	 */
	public void setRainPreventionMeasures(String rainPreventionMeasures) {
		this.rainPreventionMeasures = rainPreventionMeasures;
	}
	/**
	 * 获取：雨水排水系统风险防控措施
	 */
	public String getRainPreventionMeasures() {
		return rainPreventionMeasures;
	}
	/**
	 * 设置：依法获取污水排入排水管网许可
	 */
	public void setProductionWastewaterPreventionMeasures(String productionWastewaterPreventionMeasures) {
		this.productionWastewaterPreventionMeasures = productionWastewaterPreventionMeasures;
	}
	/**
	 * 获取：依法获取污水排入排水管网许可
	 */
	public String getProductionWastewaterPreventionMeasures() {
		return productionWastewaterPreventionMeasures;
	}
	/**
	 * 设置：生产废水处理系统风险防控措施
	 */
	public void setPipeNetworkPermit(String pipeNetworkPermit) {
		this.pipeNetworkPermit = pipeNetworkPermit;
	}
	/**
	 * 获取：生产废水处理系统风险防控措施
	 */
	public String getPipeNetworkPermit() {
		return pipeNetworkPermit;
	}
	/**
	 * 设置：厂内危险废物环境管理
	 */
	public void setEnvironmentalManagement(String environmentalManagement) {
		this.environmentalManagement = environmentalManagement;
	}
	/**
	 * 获取：厂内危险废物环境管理
	 */
	public String getEnvironmentalManagement() {
		return environmentalManagement;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatedate() {
		return createdate;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：更新时间
	 */
	public  Date getUpdatedate() {
		return updatedate;
	}
	/**
	 * 设置：删除时间
	 */
	public void setDeletedate(Date deletedate) {
		this.deletedate = deletedate;
	}
	/**
	 * 获取：删除时间
	 */
	public Date getDeletedate() {
		return deletedate;
	}

	public String getCreatedatestr() {
		return DateUtils.format(createdate, DateUtils.DATE_TIME_PATTERN);
	}

	public void setCreatedatestr(String createdatestr) {
		this.createdatestr = createdatestr;
	}
}
