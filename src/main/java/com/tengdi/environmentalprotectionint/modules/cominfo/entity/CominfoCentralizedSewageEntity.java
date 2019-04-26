package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 集中式污水处理厂运行情况
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:38:07
 */
@TableName("cominfo_centralized_sewage")
public class CominfoCentralizedSewageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 对应的企业ID
	 */
	private String cid;
	/**
	 * 年运行天数
	 */
	private String operationDays;
	/**
	 * 用电量
	 */
	private String electricityConsumption;
	/**
	 * 污水设计处理能力
	 */
	private String sewageTreatmentDesign;
	/**
	 * 污水实际处理量
	 */
	private String sewageTreatmentActual;
	/**
	 * 处理的生活污水量
	 */
	private String sewageTreatmentDomestic;
	/**
	 * 再生水量
	 */
	private String reclaimedWaterVolume;
	/**
	 * 工业用水量
	 */
	private String industrialWaterConsumption;
	/**
	 * 市政用水量
	 */
	private String municipaWaterConsumption;
	/**
	 * 景观用水量
	 */
	private String landscapeWaterConsumption;
	/**
	 * 干污泥产生量
	 */
	private String drySludgeProduction;
	/**
	 * 污泥厌氧消化装置产气量（有厌氧装置的填报）
	 */
	private String anaerobicInstallationGasProduction;
	/**
	 * 污泥厌氧消化装置产气利用方式
	 */
	private String anaerobicInstallationGasUtilizationMode;
	/**
	 * 干污泥处置量
	 */
	private String drySludgeDisposal;
	/**
	 * 自行处置量
	 */
	private String selfDisposalCapacity;
	/**
	 * 其中：土地利用量
	 */
	private String landUse;
	/**
	 * 填埋处置量
	 */
	private String landfillDisposal;
	/**
	 * 建筑材料利用量
	 */
	private String buildingMaterialsUtilization;
	/**
	 * 焚烧处置量
	 */
	private String incinerationDisposal;
	/**
	 * 送外单位处置量
	 */
	private String forOuterDisposalQuantity;
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
	 * 备注
	 */
	private String remarks;

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
	 * 设置：对应的企业ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：对应的企业ID
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * 设置：年运行天数
	 */
	public void setOperationDays(String operationDays) {
		this.operationDays = operationDays;
	}
	/**
	 * 获取：年运行天数
	 */
	public String getOperationDays() {
		return operationDays;
	}
	/**
	 * 设置：用电量
	 */
	public void setElectricityConsumption(String electricityConsumption) {
		this.electricityConsumption = electricityConsumption;
	}
	/**
	 * 获取：用电量
	 */
	public String getElectricityConsumption() {
		return electricityConsumption;
	}
	/**
	 * 设置：污水设计处理能力
	 */
	public void setSewageTreatmentDesign(String sewageTreatmentDesign) {
		this.sewageTreatmentDesign = sewageTreatmentDesign;
	}
	/**
	 * 获取：污水设计处理能力
	 */
	public String getSewageTreatmentDesign() {
		return sewageTreatmentDesign;
	}
	/**
	 * 设置：污水实际处理量
	 */
	public void setSewageTreatmentActual(String sewageTreatmentActual) {
		this.sewageTreatmentActual = sewageTreatmentActual;
	}
	/**
	 * 获取：污水实际处理量
	 */
	public String getSewageTreatmentActual() {
		return sewageTreatmentActual;
	}
	/**
	 * 设置：处理的生活污水量
	 */
	public void setSewageTreatmentDomestic(String sewageTreatmentDomestic) {
		this.sewageTreatmentDomestic = sewageTreatmentDomestic;
	}
	/**
	 * 获取：处理的生活污水量
	 */
	public String getSewageTreatmentDomestic() {
		return sewageTreatmentDomestic;
	}
	/**
	 * 设置：再生水量
	 */
	public void setReclaimedWaterVolume(String reclaimedWaterVolume) {
		this.reclaimedWaterVolume = reclaimedWaterVolume;
	}
	/**
	 * 获取：再生水量
	 */
	public String getReclaimedWaterVolume() {
		return reclaimedWaterVolume;
	}
	/**
	 * 设置：工业用水量
	 */
	public void setIndustrialWaterConsumption(String industrialWaterConsumption) {
		this.industrialWaterConsumption = industrialWaterConsumption;
	}
	/**
	 * 获取：工业用水量
	 */
	public String getIndustrialWaterConsumption() {
		return industrialWaterConsumption;
	}
	/**
	 * 设置：市政用水量
	 */
	public void setMunicipaWaterConsumption(String municipaWaterConsumption) {
		this.municipaWaterConsumption = municipaWaterConsumption;
	}
	/**
	 * 获取：市政用水量
	 */
	public String getMunicipaWaterConsumption() {
		return municipaWaterConsumption;
	}
	/**
	 * 设置：景观用水量
	 */
	public void setLandscapeWaterConsumption(String landscapeWaterConsumption) {
		this.landscapeWaterConsumption = landscapeWaterConsumption;
	}
	/**
	 * 获取：景观用水量
	 */
	public String getLandscapeWaterConsumption() {
		return landscapeWaterConsumption;
	}
	/**
	 * 设置：干污泥产生量
	 */
	public void setDrySludgeProduction(String drySludgeProduction) {
		this.drySludgeProduction = drySludgeProduction;
	}
	/**
	 * 获取：干污泥产生量
	 */
	public String getDrySludgeProduction() {
		return drySludgeProduction;
	}
	/**
	 * 设置：污泥厌氧消化装置产气量（有厌氧装置的填报）
	 */
	public void setAnaerobicInstallationGasProduction(String anaerobicInstallationGasProduction) {
		this.anaerobicInstallationGasProduction = anaerobicInstallationGasProduction;
	}
	/**
	 * 获取：污泥厌氧消化装置产气量（有厌氧装置的填报）
	 */
	public String getAnaerobicInstallationGasProduction() {
		return anaerobicInstallationGasProduction;
	}
	/**
	 * 设置：污泥厌氧消化装置产气利用方式
	 */
	public void setAnaerobicInstallationGasUtilizationMode(String anaerobicInstallationGasUtilizationMode) {
		this.anaerobicInstallationGasUtilizationMode = anaerobicInstallationGasUtilizationMode;
	}
	/**
	 * 获取：污泥厌氧消化装置产气利用方式
	 */
	public String getAnaerobicInstallationGasUtilizationMode() {
		return anaerobicInstallationGasUtilizationMode;
	}
	/**
	 * 设置：干污泥处置量
	 */
	public void setDrySludgeDisposal(String drySludgeDisposal) {
		this.drySludgeDisposal = drySludgeDisposal;
	}
	/**
	 * 获取：干污泥处置量
	 */
	public String getDrySludgeDisposal() {
		return drySludgeDisposal;
	}
	/**
	 * 设置：自行处置量
	 */
	public void setSelfDisposalCapacity(String selfDisposalCapacity) {
		this.selfDisposalCapacity = selfDisposalCapacity;
	}
	/**
	 * 获取：自行处置量
	 */
	public String getSelfDisposalCapacity() {
		return selfDisposalCapacity;
	}
	/**
	 * 设置：其中：土地利用量
	 */
	public void setLandUse(String landUse) {
		this.landUse = landUse;
	}
	/**
	 * 获取：其中：土地利用量
	 */
	public String getLandUse() {
		return landUse;
	}
	/**
	 * 设置：填埋处置量
	 */
	public void setLandfillDisposal(String landfillDisposal) {
		this.landfillDisposal = landfillDisposal;
	}
	/**
	 * 获取：填埋处置量
	 */
	public String getLandfillDisposal() {
		return landfillDisposal;
	}
	/**
	 * 设置：建筑材料利用量
	 */
	public void setBuildingMaterialsUtilization(String buildingMaterialsUtilization) {
		this.buildingMaterialsUtilization = buildingMaterialsUtilization;
	}
	/**
	 * 获取：建筑材料利用量
	 */
	public String getBuildingMaterialsUtilization() {
		return buildingMaterialsUtilization;
	}
	/**
	 * 设置：焚烧处置量
	 */
	public void setIncinerationDisposal(String incinerationDisposal) {
		this.incinerationDisposal = incinerationDisposal;
	}
	/**
	 * 获取：焚烧处置量
	 */
	public String getIncinerationDisposal() {
		return incinerationDisposal;
	}
	/**
	 * 设置：送外单位处置量
	 */
	public void setForOuterDisposalQuantity(String forOuterDisposalQuantity) {
		this.forOuterDisposalQuantity = forOuterDisposalQuantity;
	}
	/**
	 * 获取：送外单位处置量
	 */
	public String getForOuterDisposalQuantity() {
		return forOuterDisposalQuantity;
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
}
