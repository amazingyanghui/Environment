package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 危险废物集中处置厂运行情况
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:37:58
 */
@TableName("cominfo_centralized_hazardouswaste")
public class CominfoCentralizedHazardouswasteEntity implements Serializable {
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
	 * 危险废物接收量
	 */
	private String hazardousWastesReceiveNumber;
	/**
	 * 设计处置利用能力
	 */
	private String designDisposalUtilizationAbility;
	/**
	 * 处置利用总量
	 */
	private String utilizationTotal;
	/**
	 * 其中：处置工业危险废物量
	 */
	private String industrialHazardousWasteNumber;
	/**
	 * 处置医疗废物量
	 */
	private String medicalWasteNumber;
	/**
	 * 处置其他危险废物量
	 */
	private String otherHazardousWasteNumber;
	/**
	 * 综合利用危险废物量
	 */
	private String utilizationHazardousWasteNumber;
	/**
	 * 设计综合利用能力（有综合利用方式的填报）
	 */
	private String utilizationDesignCapacity;
	/**
	 * 危险废物数量
	 */
	private String hazardousWastesNumber;
	/**
	 * 综合利用方式（可多选）
	 */
	private String comprehensiveUtilizationMode;
	/**
	 * 设计容量（有填埋方式的填报）
	 */
	private String landfillDesignCapacity;
	/**
	 * 已填容量
	 */
	private String landfillLandfilledCapacity;
	/**
	 * 设计处置能力
	 */
	private String landfillDesignDealCapacity;
	/**
	 * 实际填埋处置量
	 */
	private String landfillActualCapacity;
	/**
	 * 设计处置能力（物理化学处置方式）
	 */
	private String physicochemicalDesignCapacity;
	/**
	 * 实际处置量
	 */
	private String physicochemicalActualCapacity;
	/**
	 * 设施数量（有焚烧方式的填报）
	 */
	private String burnEquipmentNumbers;
	/**
	 * 炉排炉
	 */
	private String burnGrateStoves;
	/**
	 * 流化床
	 */
	private String burnFluidizedBed;
	/**
	 * 固定床（含热解炉）
	 */
	private String burnFixedBed;
	/**
	 * 旋转炉
	 */
	private String burnRotaryFurnace;
	/**
	 * 其他
	 */
	private String burnOthers;
	/**
	 * 
	 */
	private String designedIncinerationCapacity;
	/**
	 * 13.主导行业二代码
	 */
	private String actualBurnVolume;
	/**
	 * 13.主导行业二产值占比（%）
	 */
	private String combustionPromoter;
	/**
	 * 13.主导行业三名称
	 */
	private String coalConsumption;
	/**
	 * 13.主导行业三代码
	 */
	private String fuelOilConsumption;
	/**
	 * 13.主导行业三产值占比（%）
	 */
	private String naturalGasConsumption;
	/**
	 * 14.是否清污分流
	 */
	private String wasteGasDesignDeal;
	/**
	 * 清水排水去向类型：
	 */
	private String slagProduction;
	/**
	 * 清水受纳水体名称：
	 */
	private String slagDealVolume;
	/**
	 * 清水受纳水体代码：
	 */
	private String burnAshProduction;
	/**
	 * 污水排水去向类型：
	 */
	private String burnAshDeal;
	/**
	 * 污水受纳水体名称：
	 */
	private String medicalWasteDealMethod;
	/**
	 * 污水受纳水体代码：
	 */
	private String medicalWasteDesignCapacity;
	/**
	 * 17.有无集中生活污水处理厂
	 */
	private String medicalWasteBurnDesignCapacity;
	/**
	 * 18.集中式生活污水处理厂名称
	 */
	private String medicalWasteDealVolume;
	/**
	 * 18.集中式生活污水处理厂统一社会信用代码
	 */
	private String wastewaterDealMethod;
	/**
	 * 18.集中式生活污水处理厂原组织机构代码号：
	 */
	private String wastewaterDesignCapacity;
	/**
	 * 19.有无集中工业污水处理厂
	 */
	private String wastewaterProduction;
	/**
	 * 20.集中式生活污水处理厂名称
	 */
	private String wastewaterActualDeal;
	/**
	 * 20.集中式生活污水处理厂统一社会信用代码
	 */
	private String wastewaterActualDischarge;
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
	 * 设置：危险废物接收量
	 */
	public void setHazardousWastesReceiveNumber(String hazardousWastesReceiveNumber) {
		this.hazardousWastesReceiveNumber = hazardousWastesReceiveNumber;
	}
	/**
	 * 获取：危险废物接收量
	 */
	public String getHazardousWastesReceiveNumber() {
		return hazardousWastesReceiveNumber;
	}
	/**
	 * 设置：设计处置利用能力
	 */
	public void setDesignDisposalUtilizationAbility(String designDisposalUtilizationAbility) {
		this.designDisposalUtilizationAbility = designDisposalUtilizationAbility;
	}
	/**
	 * 获取：设计处置利用能力
	 */
	public String getDesignDisposalUtilizationAbility() {
		return designDisposalUtilizationAbility;
	}
	/**
	 * 设置：处置利用总量
	 */
	public void setUtilizationTotal(String utilizationTotal) {
		this.utilizationTotal = utilizationTotal;
	}
	/**
	 * 获取：处置利用总量
	 */
	public String getUtilizationTotal() {
		return utilizationTotal;
	}
	/**
	 * 设置：其中：处置工业危险废物量
	 */
	public void setIndustrialHazardousWasteNumber(String industrialHazardousWasteNumber) {
		this.industrialHazardousWasteNumber = industrialHazardousWasteNumber;
	}
	/**
	 * 获取：其中：处置工业危险废物量
	 */
	public String getIndustrialHazardousWasteNumber() {
		return industrialHazardousWasteNumber;
	}
	/**
	 * 设置：处置医疗废物量
	 */
	public void setMedicalWasteNumber(String medicalWasteNumber) {
		this.medicalWasteNumber = medicalWasteNumber;
	}
	/**
	 * 获取：处置医疗废物量
	 */
	public String getMedicalWasteNumber() {
		return medicalWasteNumber;
	}
	/**
	 * 设置：处置其他危险废物量
	 */
	public void setOtherHazardousWasteNumber(String otherHazardousWasteNumber) {
		this.otherHazardousWasteNumber = otherHazardousWasteNumber;
	}
	/**
	 * 获取：处置其他危险废物量
	 */
	public String getOtherHazardousWasteNumber() {
		return otherHazardousWasteNumber;
	}
	/**
	 * 设置：综合利用危险废物量
	 */
	public void setUtilizationHazardousWasteNumber(String utilizationHazardousWasteNumber) {
		this.utilizationHazardousWasteNumber = utilizationHazardousWasteNumber;
	}
	/**
	 * 获取：综合利用危险废物量
	 */
	public String getUtilizationHazardousWasteNumber() {
		return utilizationHazardousWasteNumber;
	}
	/**
	 * 设置：设计综合利用能力（有综合利用方式的填报）
	 */
	public void setUtilizationDesignCapacity(String utilizationDesignCapacity) {
		this.utilizationDesignCapacity = utilizationDesignCapacity;
	}
	/**
	 * 获取：设计综合利用能力（有综合利用方式的填报）
	 */
	public String getUtilizationDesignCapacity() {
		return utilizationDesignCapacity;
	}
	/**
	 * 设置：危险废物数量
	 */
	public void setHazardousWastesNumber(String hazardousWastesNumber) {
		this.hazardousWastesNumber = hazardousWastesNumber;
	}
	/**
	 * 获取：危险废物数量
	 */
	public String getHazardousWastesNumber() {
		return hazardousWastesNumber;
	}
	/**
	 * 设置：综合利用方式（可多选）
	 */
	public void setComprehensiveUtilizationMode(String comprehensiveUtilizationMode) {
		this.comprehensiveUtilizationMode = comprehensiveUtilizationMode;
	}
	/**
	 * 获取：综合利用方式（可多选）
	 */
	public String getComprehensiveUtilizationMode() {
		return comprehensiveUtilizationMode;
	}
	/**
	 * 设置：设计容量（有填埋方式的填报）
	 */
	public void setLandfillDesignCapacity(String landfillDesignCapacity) {
		this.landfillDesignCapacity = landfillDesignCapacity;
	}
	/**
	 * 获取：设计容量（有填埋方式的填报）
	 */
	public String getLandfillDesignCapacity() {
		return landfillDesignCapacity;
	}
	/**
	 * 设置：已填容量
	 */
	public void setLandfillLandfilledCapacity(String landfillLandfilledCapacity) {
		this.landfillLandfilledCapacity = landfillLandfilledCapacity;
	}
	/**
	 * 获取：已填容量
	 */
	public String getLandfillLandfilledCapacity() {
		return landfillLandfilledCapacity;
	}
	/**
	 * 设置：设计处置能力
	 */
	public void setLandfillDesignDealCapacity(String landfillDesignDealCapacity) {
		this.landfillDesignDealCapacity = landfillDesignDealCapacity;
	}
	/**
	 * 获取：设计处置能力
	 */
	public String getLandfillDesignDealCapacity() {
		return landfillDesignDealCapacity;
	}
	/**
	 * 设置：实际填埋处置量
	 */
	public void setLandfillActualCapacity(String landfillActualCapacity) {
		this.landfillActualCapacity = landfillActualCapacity;
	}
	/**
	 * 获取：实际填埋处置量
	 */
	public String getLandfillActualCapacity() {
		return landfillActualCapacity;
	}
	/**
	 * 设置：设计处置能力（物理化学处置方式）
	 */
	public void setPhysicochemicalDesignCapacity(String physicochemicalDesignCapacity) {
		this.physicochemicalDesignCapacity = physicochemicalDesignCapacity;
	}
	/**
	 * 获取：设计处置能力（物理化学处置方式）
	 */
	public String getPhysicochemicalDesignCapacity() {
		return physicochemicalDesignCapacity;
	}
	/**
	 * 设置：实际处置量
	 */
	public void setPhysicochemicalActualCapacity(String physicochemicalActualCapacity) {
		this.physicochemicalActualCapacity = physicochemicalActualCapacity;
	}
	/**
	 * 获取：实际处置量
	 */
	public String getPhysicochemicalActualCapacity() {
		return physicochemicalActualCapacity;
	}
	/**
	 * 设置：设施数量（有焚烧方式的填报）
	 */
	public void setBurnEquipmentNumbers(String burnEquipmentNumbers) {
		this.burnEquipmentNumbers = burnEquipmentNumbers;
	}
	/**
	 * 获取：设施数量（有焚烧方式的填报）
	 */
	public String getBurnEquipmentNumbers() {
		return burnEquipmentNumbers;
	}
	/**
	 * 设置：炉排炉
	 */
	public void setBurnGrateStoves(String burnGrateStoves) {
		this.burnGrateStoves = burnGrateStoves;
	}
	/**
	 * 获取：炉排炉
	 */
	public String getBurnGrateStoves() {
		return burnGrateStoves;
	}
	/**
	 * 设置：流化床
	 */
	public void setBurnFluidizedBed(String burnFluidizedBed) {
		this.burnFluidizedBed = burnFluidizedBed;
	}
	/**
	 * 获取：流化床
	 */
	public String getBurnFluidizedBed() {
		return burnFluidizedBed;
	}
	/**
	 * 设置：固定床（含热解炉）
	 */
	public void setBurnFixedBed(String burnFixedBed) {
		this.burnFixedBed = burnFixedBed;
	}
	/**
	 * 获取：固定床（含热解炉）
	 */
	public String getBurnFixedBed() {
		return burnFixedBed;
	}
	/**
	 * 设置：旋转炉
	 */
	public void setBurnRotaryFurnace(String burnRotaryFurnace) {
		this.burnRotaryFurnace = burnRotaryFurnace;
	}
	/**
	 * 获取：旋转炉
	 */
	public String getBurnRotaryFurnace() {
		return burnRotaryFurnace;
	}
	/**
	 * 设置：其他
	 */
	public void setBurnOthers(String burnOthers) {
		this.burnOthers = burnOthers;
	}
	/**
	 * 获取：其他
	 */
	public String getBurnOthers() {
		return burnOthers;
	}
	/**
	 * 设置：
	 */
	public void setDesignedIncinerationCapacity(String designedIncinerationCapacity) {
		this.designedIncinerationCapacity = designedIncinerationCapacity;
	}
	/**
	 * 获取：
	 */
	public String getDesignedIncinerationCapacity() {
		return designedIncinerationCapacity;
	}
	/**
	 * 设置：13.主导行业二代码
	 */
	public void setActualBurnVolume(String actualBurnVolume) {
		this.actualBurnVolume = actualBurnVolume;
	}
	/**
	 * 获取：13.主导行业二代码
	 */
	public String getActualBurnVolume() {
		return actualBurnVolume;
	}
	/**
	 * 设置：13.主导行业二产值占比（%）
	 */
	public void setCombustionPromoter(String combustionPromoter) {
		this.combustionPromoter = combustionPromoter;
	}
	/**
	 * 获取：13.主导行业二产值占比（%）
	 */
	public String getCombustionPromoter() {
		return combustionPromoter;
	}
	/**
	 * 设置：13.主导行业三名称
	 */
	public void setCoalConsumption(String coalConsumption) {
		this.coalConsumption = coalConsumption;
	}
	/**
	 * 获取：13.主导行业三名称
	 */
	public String getCoalConsumption() {
		return coalConsumption;
	}
	/**
	 * 设置：13.主导行业三代码
	 */
	public void setFuelOilConsumption(String fuelOilConsumption) {
		this.fuelOilConsumption = fuelOilConsumption;
	}
	/**
	 * 获取：13.主导行业三代码
	 */
	public String getFuelOilConsumption() {
		return fuelOilConsumption;
	}
	/**
	 * 设置：13.主导行业三产值占比（%）
	 */
	public void setNaturalGasConsumption(String naturalGasConsumption) {
		this.naturalGasConsumption = naturalGasConsumption;
	}
	/**
	 * 获取：13.主导行业三产值占比（%）
	 */
	public String getNaturalGasConsumption() {
		return naturalGasConsumption;
	}
	/**
	 * 设置：14.是否清污分流
	 */
	public void setWasteGasDesignDeal(String wasteGasDesignDeal) {
		this.wasteGasDesignDeal = wasteGasDesignDeal;
	}
	/**
	 * 获取：14.是否清污分流
	 */
	public String getWasteGasDesignDeal() {
		return wasteGasDesignDeal;
	}
	/**
	 * 设置：清水排水去向类型：
	 */
	public void setSlagProduction(String slagProduction) {
		this.slagProduction = slagProduction;
	}
	/**
	 * 获取：清水排水去向类型：
	 */
	public String getSlagProduction() {
		return slagProduction;
	}
	/**
	 * 设置：清水受纳水体名称：
	 */
	public void setSlagDealVolume(String slagDealVolume) {
		this.slagDealVolume = slagDealVolume;
	}
	/**
	 * 获取：清水受纳水体名称：
	 */
	public String getSlagDealVolume() {
		return slagDealVolume;
	}
	/**
	 * 设置：清水受纳水体代码：
	 */
	public void setBurnAshProduction(String burnAshProduction) {
		this.burnAshProduction = burnAshProduction;
	}
	/**
	 * 获取：清水受纳水体代码：
	 */
	public String getBurnAshProduction() {
		return burnAshProduction;
	}
	/**
	 * 设置：污水排水去向类型：
	 */
	public void setBurnAshDeal(String burnAshDeal) {
		this.burnAshDeal = burnAshDeal;
	}
	/**
	 * 获取：污水排水去向类型：
	 */
	public String getBurnAshDeal() {
		return burnAshDeal;
	}
	/**
	 * 设置：污水受纳水体名称：
	 */
	public void setMedicalWasteDealMethod(String medicalWasteDealMethod) {
		this.medicalWasteDealMethod = medicalWasteDealMethod;
	}
	/**
	 * 获取：污水受纳水体名称：
	 */
	public String getMedicalWasteDealMethod() {
		return medicalWasteDealMethod;
	}
	/**
	 * 设置：污水受纳水体代码：
	 */
	public void setMedicalWasteDesignCapacity(String medicalWasteDesignCapacity) {
		this.medicalWasteDesignCapacity = medicalWasteDesignCapacity;
	}
	/**
	 * 获取：污水受纳水体代码：
	 */
	public String getMedicalWasteDesignCapacity() {
		return medicalWasteDesignCapacity;
	}
	/**
	 * 设置：17.有无集中生活污水处理厂
	 */
	public void setMedicalWasteBurnDesignCapacity(String medicalWasteBurnDesignCapacity) {
		this.medicalWasteBurnDesignCapacity = medicalWasteBurnDesignCapacity;
	}
	/**
	 * 获取：17.有无集中生活污水处理厂
	 */
	public String getMedicalWasteBurnDesignCapacity() {
		return medicalWasteBurnDesignCapacity;
	}
	/**
	 * 设置：18.集中式生活污水处理厂名称
	 */
	public void setMedicalWasteDealVolume(String medicalWasteDealVolume) {
		this.medicalWasteDealVolume = medicalWasteDealVolume;
	}
	/**
	 * 获取：18.集中式生活污水处理厂名称
	 */
	public String getMedicalWasteDealVolume() {
		return medicalWasteDealVolume;
	}
	/**
	 * 设置：18.集中式生活污水处理厂统一社会信用代码
	 */
	public void setWastewaterDealMethod(String wastewaterDealMethod) {
		this.wastewaterDealMethod = wastewaterDealMethod;
	}
	/**
	 * 获取：18.集中式生活污水处理厂统一社会信用代码
	 */
	public String getWastewaterDealMethod() {
		return wastewaterDealMethod;
	}
	/**
	 * 设置：18.集中式生活污水处理厂原组织机构代码号：
	 */
	public void setWastewaterDesignCapacity(String wastewaterDesignCapacity) {
		this.wastewaterDesignCapacity = wastewaterDesignCapacity;
	}
	/**
	 * 获取：18.集中式生活污水处理厂原组织机构代码号：
	 */
	public String getWastewaterDesignCapacity() {
		return wastewaterDesignCapacity;
	}
	/**
	 * 设置：19.有无集中工业污水处理厂
	 */
	public void setWastewaterProduction(String wastewaterProduction) {
		this.wastewaterProduction = wastewaterProduction;
	}
	/**
	 * 获取：19.有无集中工业污水处理厂
	 */
	public String getWastewaterProduction() {
		return wastewaterProduction;
	}
	/**
	 * 设置：20.集中式生活污水处理厂名称
	 */
	public void setWastewaterActualDeal(String wastewaterActualDeal) {
		this.wastewaterActualDeal = wastewaterActualDeal;
	}
	/**
	 * 获取：20.集中式生活污水处理厂名称
	 */
	public String getWastewaterActualDeal() {
		return wastewaterActualDeal;
	}
	/**
	 * 设置：20.集中式生活污水处理厂统一社会信用代码
	 */
	public void setWastewaterActualDischarge(String wastewaterActualDischarge) {
		this.wastewaterActualDischarge = wastewaterActualDischarge;
	}
	/**
	 * 获取：20.集中式生活污水处理厂统一社会信用代码
	 */
	public String getWastewaterActualDischarge() {
		return wastewaterActualDischarge;
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
