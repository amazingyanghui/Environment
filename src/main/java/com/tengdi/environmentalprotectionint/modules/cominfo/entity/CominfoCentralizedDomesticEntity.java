package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 生活垃圾集中处置厂运行情况
 * 
 * @author tengdi
 * @email 
 * @date 2019-03-12 17:38:04
 */
@TableName("cominfo_centralized_domestic")
public class CominfoCentralizedDomesticEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键UUID
	 */
	@TableId
	private String pid;
	/**
	 * 对应企业ID
	 */
	private String cid;
	/**
	 * 年运行天数
	 */
	private String operationDays;
	/**
	 * 本年实际处理量
	 */
	private String actualProcessingVolume;
	/**
	 * 设计容量（有填埋方式的填报）
	 */
	private String landfillDesignCapacity;
	/**
	 * 已填容量
	 */
	private String landfillLandfilledCapacity;
	/**
	 * 正在填埋作业区面积
	 */
	private String landfillArea;
	/**
	 * 已使用粘土覆盖区面积
	 */
	private String landfillClayArea;
	/**
	 * 已使用塑料土工膜覆盖区面积
	 */
	private String landfillPlasticArea;
	/**
	 * 本年实际填埋量
	 */
	private String landfillActualCapacity;
	/**
	 * 设计处理能力（有堆肥处置方式的填报）
	 */
	private String compostDesignCapacity;
	/**
	 * 本年实际堆肥量
	 */
	private String compostActualCapacity;
	/**
	 * 渗滤液收集系统
	 */
	private String compostLeachateCollectionSystem;
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
	 * 设计焚烧处理能力
	 */
	private String designedIncinerationCapacity;
	/**
	 * 本年实际焚烧处理量
	 */
	private String actualBurnVolume;
	/**
	 * 助燃剂使用情况
	 */
	private String combustionPromoter;
	/**
	 * 煤炭消耗量
	 */
	private String coalConsumption;
	/**
	 * 燃料油消耗量（不含车船用）
	 */
	private String fuelOilConsumption;
	/**
	 * 天然气消耗量
	 */
	private String naturalGasConsumption;
	/**
	 * 废气设计处理能力
	 */
	private String wasteGasDesignDeal;
	/**
	 * 炉渣产生量
	 */
	private String slagProduction;
	/**
	 * 炉渣处置方式
	 */
	private String slagDealType;
	/**
	 * 炉渣处置量
	 */
	private String slagDealVolume;
	/**
	 * 炉渣综合利用量
	 */
	private String slagUtilization;
	/**
	 * 焚烧飞灰产生量
	 */
	private String burnAshProduction;
	/**
	 * 焚烧飞灰处置量
	 */
	private String burnAshDeal;
	/**
	 * 焚烧飞灰综合利用量
	 */
	private String burnAshUtilization;
	/**
	 * 设计处理能力（厌氧发酵处置方式）
	 */
	private String anaerobicFermentationDesignCapacity;
	/**
	 * 本年实际处置量
	 */
	private String anaerobicFermentationActualCapacity;
	/**
	 * 设计处理能力（生物分解处置方式）
	 */
	private String biodegradationDesignCapacity;
	/**
	 * 本年实际处置量
	 */
	private String biodegradationActualCapacity;
	/**
	 * 设计处理能力（其他方式）
	 */
	private String otherDesignCapacity;
	/**
	 * 本年实际处置量
	 */
	private String otherActualCapacity;
	/**
	 * 废水（含渗滤液）产生量
	 */
	private String wastewaterProduction;
	/**
	 * 废水处理方式 
	 */
	private String wastewaterDealType;
	/**
	 * 废水设计处理能力
	 */
	private String wastewaterDesignCapacity;
	/**
	 * 废水处理方法
	 */
	private String wastewaterDealMethod;
	/**
	 * 废水实际处理量
	 */
	private String wastewaterActualDeal;
	/**
	 * 废水实际排放量
	 */
	private String wastewaterActualDischarge;
	/**
	 * 渗滤液膜浓缩液产生量
	 */
	private String leachateProduction;
	/**
	 * 渗滤液膜浓缩液处理方法
	 */
	private String leachateDealMethod;
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
	 * 设置：对应企业ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * 获取：对应企业ID
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
	 * 设置：本年实际处理量
	 */
	public void setActualProcessingVolume(String actualProcessingVolume) {
		this.actualProcessingVolume = actualProcessingVolume;
	}
	/**
	 * 获取：本年实际处理量
	 */
	public String getActualProcessingVolume() {
		return actualProcessingVolume;
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
	 * 设置：正在填埋作业区面积
	 */
	public void setLandfillArea(String landfillArea) {
		this.landfillArea = landfillArea;
	}
	/**
	 * 获取：正在填埋作业区面积
	 */
	public String getLandfillArea() {
		return landfillArea;
	}
	/**
	 * 设置：已使用粘土覆盖区面积
	 */
	public void setLandfillClayArea(String landfillClayArea) {
		this.landfillClayArea = landfillClayArea;
	}
	/**
	 * 获取：已使用粘土覆盖区面积
	 */
	public String getLandfillClayArea() {
		return landfillClayArea;
	}
	/**
	 * 设置：已使用塑料土工膜覆盖区面积
	 */
	public void setLandfillPlasticArea(String landfillPlasticArea) {
		this.landfillPlasticArea = landfillPlasticArea;
	}
	/**
	 * 获取：已使用塑料土工膜覆盖区面积
	 */
	public String getLandfillPlasticArea() {
		return landfillPlasticArea;
	}
	/**
	 * 设置：本年实际填埋量
	 */
	public void setLandfillActualCapacity(String landfillActualCapacity) {
		this.landfillActualCapacity = landfillActualCapacity;
	}
	/**
	 * 获取：本年实际填埋量
	 */
	public String getLandfillActualCapacity() {
		return landfillActualCapacity;
	}
	/**
	 * 设置：设计处理能力（有堆肥处置方式的填报）
	 */
	public void setCompostDesignCapacity(String compostDesignCapacity) {
		this.compostDesignCapacity = compostDesignCapacity;
	}
	/**
	 * 获取：设计处理能力（有堆肥处置方式的填报）
	 */
	public String getCompostDesignCapacity() {
		return compostDesignCapacity;
	}
	/**
	 * 设置：本年实际堆肥量
	 */
	public void setCompostActualCapacity(String compostActualCapacity) {
		this.compostActualCapacity = compostActualCapacity;
	}
	/**
	 * 获取：本年实际堆肥量
	 */
	public String getCompostActualCapacity() {
		return compostActualCapacity;
	}
	/**
	 * 设置：渗滤液收集系统
	 */
	public void setCompostLeachateCollectionSystem(String compostLeachateCollectionSystem) {
		this.compostLeachateCollectionSystem = compostLeachateCollectionSystem;
	}
	/**
	 * 获取：渗滤液收集系统
	 */
	public String getCompostLeachateCollectionSystem() {
		return compostLeachateCollectionSystem;
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
	 * 设置：设计焚烧处理能力
	 */
	public void setDesignedIncinerationCapacity(String designedIncinerationCapacity) {
		this.designedIncinerationCapacity = designedIncinerationCapacity;
	}
	/**
	 * 获取：设计焚烧处理能力
	 */
	public String getDesignedIncinerationCapacity() {
		return designedIncinerationCapacity;
	}
	/**
	 * 设置：本年实际焚烧处理量
	 */
	public void setActualBurnVolume(String actualBurnVolume) {
		this.actualBurnVolume = actualBurnVolume;
	}
	/**
	 * 获取：本年实际焚烧处理量
	 */
	public String getActualBurnVolume() {
		return actualBurnVolume;
	}
	/**
	 * 设置：助燃剂使用情况
	 */
	public void setCombustionPromoter(String combustionPromoter) {
		this.combustionPromoter = combustionPromoter;
	}
	/**
	 * 获取：助燃剂使用情况
	 */
	public String getCombustionPromoter() {
		return combustionPromoter;
	}
	/**
	 * 设置：煤炭消耗量
	 */
	public void setCoalConsumption(String coalConsumption) {
		this.coalConsumption = coalConsumption;
	}
	/**
	 * 获取：煤炭消耗量
	 */
	public String getCoalConsumption() {
		return coalConsumption;
	}
	/**
	 * 设置：燃料油消耗量（不含车船用）
	 */
	public void setFuelOilConsumption(String fuelOilConsumption) {
		this.fuelOilConsumption = fuelOilConsumption;
	}
	/**
	 * 获取：燃料油消耗量（不含车船用）
	 */
	public String getFuelOilConsumption() {
		return fuelOilConsumption;
	}
	/**
	 * 设置：天然气消耗量
	 */
	public void setNaturalGasConsumption(String naturalGasConsumption) {
		this.naturalGasConsumption = naturalGasConsumption;
	}
	/**
	 * 获取：天然气消耗量
	 */
	public String getNaturalGasConsumption() {
		return naturalGasConsumption;
	}
	/**
	 * 设置：废气设计处理能力
	 */
	public void setWasteGasDesignDeal(String wasteGasDesignDeal) {
		this.wasteGasDesignDeal = wasteGasDesignDeal;
	}
	/**
	 * 获取：废气设计处理能力
	 */
	public String getWasteGasDesignDeal() {
		return wasteGasDesignDeal;
	}
	/**
	 * 设置：炉渣产生量
	 */
	public void setSlagProduction(String slagProduction) {
		this.slagProduction = slagProduction;
	}
	/**
	 * 获取：炉渣产生量
	 */
	public String getSlagProduction() {
		return slagProduction;
	}
	/**
	 * 设置：炉渣处置方式
	 */
	public void setSlagDealType(String slagDealType) {
		this.slagDealType = slagDealType;
	}
	/**
	 * 获取：炉渣处置方式
	 */
	public String getSlagDealType() {
		return slagDealType;
	}
	/**
	 * 设置：炉渣处置量
	 */
	public void setSlagDealVolume(String slagDealVolume) {
		this.slagDealVolume = slagDealVolume;
	}
	/**
	 * 获取：炉渣处置量
	 */
	public String getSlagDealVolume() {
		return slagDealVolume;
	}
	/**
	 * 设置：炉渣综合利用量
	 */
	public void setSlagUtilization(String slagUtilization) {
		this.slagUtilization = slagUtilization;
	}
	/**
	 * 获取：炉渣综合利用量
	 */
	public String getSlagUtilization() {
		return slagUtilization;
	}
	/**
	 * 设置：焚烧飞灰产生量
	 */
	public void setBurnAshProduction(String burnAshProduction) {
		this.burnAshProduction = burnAshProduction;
	}
	/**
	 * 获取：焚烧飞灰产生量
	 */
	public String getBurnAshProduction() {
		return burnAshProduction;
	}
	/**
	 * 设置：焚烧飞灰处置量
	 */
	public void setBurnAshDeal(String burnAshDeal) {
		this.burnAshDeal = burnAshDeal;
	}
	/**
	 * 获取：焚烧飞灰处置量
	 */
	public String getBurnAshDeal() {
		return burnAshDeal;
	}
	/**
	 * 设置：焚烧飞灰综合利用量
	 */
	public void setBurnAshUtilization(String burnAshUtilization) {
		this.burnAshUtilization = burnAshUtilization;
	}
	/**
	 * 获取：焚烧飞灰综合利用量
	 */
	public String getBurnAshUtilization() {
		return burnAshUtilization;
	}
	/**
	 * 设置：设计处理能力（厌氧发酵处置方式）
	 */
	public void setAnaerobicFermentationDesignCapacity(String anaerobicFermentationDesignCapacity) {
		this.anaerobicFermentationDesignCapacity = anaerobicFermentationDesignCapacity;
	}
	/**
	 * 获取：设计处理能力（厌氧发酵处置方式）
	 */
	public String getAnaerobicFermentationDesignCapacity() {
		return anaerobicFermentationDesignCapacity;
	}
	/**
	 * 设置：本年实际处置量
	 */
	public void setAnaerobicFermentationActualCapacity(String anaerobicFermentationActualCapacity) {
		this.anaerobicFermentationActualCapacity = anaerobicFermentationActualCapacity;
	}
	/**
	 * 获取：本年实际处置量
	 */
	public String getAnaerobicFermentationActualCapacity() {
		return anaerobicFermentationActualCapacity;
	}
	/**
	 * 设置：设计处理能力（生物分解处置方式）
	 */
	public void setBiodegradationDesignCapacity(String biodegradationDesignCapacity) {
		this.biodegradationDesignCapacity = biodegradationDesignCapacity;
	}
	/**
	 * 获取：设计处理能力（生物分解处置方式）
	 */
	public String getBiodegradationDesignCapacity() {
		return biodegradationDesignCapacity;
	}
	/**
	 * 设置：本年实际处置量
	 */
	public void setBiodegradationActualCapacity(String biodegradationActualCapacity) {
		this.biodegradationActualCapacity = biodegradationActualCapacity;
	}
	/**
	 * 获取：本年实际处置量
	 */
	public String getBiodegradationActualCapacity() {
		return biodegradationActualCapacity;
	}
	/**
	 * 设置：设计处理能力（其他方式）
	 */
	public void setOtherDesignCapacity(String otherDesignCapacity) {
		this.otherDesignCapacity = otherDesignCapacity;
	}
	/**
	 * 获取：设计处理能力（其他方式）
	 */
	public String getOtherDesignCapacity() {
		return otherDesignCapacity;
	}
	/**
	 * 设置：本年实际处置量
	 */
	public void setOtherActualCapacity(String otherActualCapacity) {
		this.otherActualCapacity = otherActualCapacity;
	}
	/**
	 * 获取：本年实际处置量
	 */
	public String getOtherActualCapacity() {
		return otherActualCapacity;
	}
	/**
	 * 设置：废水（含渗滤液）产生量
	 */
	public void setWastewaterProduction(String wastewaterProduction) {
		this.wastewaterProduction = wastewaterProduction;
	}
	/**
	 * 获取：废水（含渗滤液）产生量
	 */
	public String getWastewaterProduction() {
		return wastewaterProduction;
	}
	/**
	 * 设置：废水处理方式 
	 */
	public void setWastewaterDealType(String wastewaterDealType) {
		this.wastewaterDealType = wastewaterDealType;
	}
	/**
	 * 获取：废水处理方式 
	 */
	public String getWastewaterDealType() {
		return wastewaterDealType;
	}
	/**
	 * 设置：废水设计处理能力
	 */
	public void setWastewaterDesignCapacity(String wastewaterDesignCapacity) {
		this.wastewaterDesignCapacity = wastewaterDesignCapacity;
	}
	/**
	 * 获取：废水设计处理能力
	 */
	public String getWastewaterDesignCapacity() {
		return wastewaterDesignCapacity;
	}
	/**
	 * 设置：废水处理方法
	 */
	public void setWastewaterDealMethod(String wastewaterDealMethod) {
		this.wastewaterDealMethod = wastewaterDealMethod;
	}
	/**
	 * 获取：废水处理方法
	 */
	public String getWastewaterDealMethod() {
		return wastewaterDealMethod;
	}
	/**
	 * 设置：废水实际处理量
	 */
	public void setWastewaterActualDeal(String wastewaterActualDeal) {
		this.wastewaterActualDeal = wastewaterActualDeal;
	}
	/**
	 * 获取：废水实际处理量
	 */
	public String getWastewaterActualDeal() {
		return wastewaterActualDeal;
	}
	/**
	 * 设置：废水实际排放量
	 */
	public void setWastewaterActualDischarge(String wastewaterActualDischarge) {
		this.wastewaterActualDischarge = wastewaterActualDischarge;
	}
	/**
	 * 获取：废水实际排放量
	 */
	public String getWastewaterActualDischarge() {
		return wastewaterActualDischarge;
	}
	/**
	 * 设置：渗滤液膜浓缩液产生量
	 */
	public void setLeachateProduction(String leachateProduction) {
		this.leachateProduction = leachateProduction;
	}
	/**
	 * 获取：渗滤液膜浓缩液产生量
	 */
	public String getLeachateProduction() {
		return leachateProduction;
	}
	/**
	 * 设置：渗滤液膜浓缩液处理方法
	 */
	public void setLeachateDealMethod(String leachateDealMethod) {
		this.leachateDealMethod = leachateDealMethod;
	}
	/**
	 * 获取：渗滤液膜浓缩液处理方法
	 */
	public String getLeachateDealMethod() {
		return leachateDealMethod;
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
