package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;

/**
 * 废水治理设施
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:43:05
 */
@TableName("cominfo_measure_wastewater")
public class CominfoMeasureWastewaterEntity implements Serializable {
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
	 * 设施名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String measureName;
	/**
	 * 对应排污口
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String blowdownOutlet;
	/**
	 * 对应排污口name
	 */
	@TableField(exist = false)
	private String blowDownOutLetName;

	public String getBlowDownOutLetName() {
		return blowDownOutLetName;
	}

	public void setBlowDownOutLetName(String blowDownOutLetName) {
		this.blowDownOutLetName = blowDownOutLetName;
	}

	/**
	 * 规格型号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String model;
	/**
	 * 处理工艺
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String process;
	/**
	 * 废水类别
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String wastewaterCategory;
	/**
	 * 废水类别name
	 */
	@TableField(exist = false)
	private String wastewaterCategoryName;

	public String getWastewaterCategoryName() {
		return wastewaterCategoryName;
	}

	public void setWastewaterCategoryName(String wastewaterCategoryName) {
		this.wastewaterCategoryName = wastewaterCategoryName;
	}

	/**
	 * 主要去除物质
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String removalOfMaterial;
	/**
	 * 主要去除物质name
	 */
	@TableField(exist = false)
	private String removalOfMaterialName;

	public String getRemovalOfMaterialName() {
		return removalOfMaterialName;
	}

	public void setRemovalOfMaterialName(String removalOfMaterialName) {
		this.removalOfMaterialName = removalOfMaterialName;
	}

	/**
	 * 总投资额（万元）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double totalInvestment;
	/**
	 * 投运日期
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String deliveryDate;
	/**
	 * 设计处理能力（吨/天）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double processingCapacity;
	/**
	 * 实际处理能力（吨/天）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double actualProcessing;
	/**
	 * 运行状态
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String runningState;
	/**
	 * 年处理量（吨）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double yearThroughput;
	/**
	 * 年运行费用（万元）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Double yearOperatingCost;
	/**
	 * 备注
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String remarks;
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
	 *单台设计能力
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String singleDesignCapability;
	/**
	 *日平均运行时间（小时）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String dayRuntime;
	/**
	 *治理期限
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String governanceLimit;
	/**
	 *验收意见
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String acceptanceOpinion;

	/**
	 * 其中：处理其他单位水量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String handleOtherUnitwater;
	/**
	 * 加盖密闭情况
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String airtightSituation;
	/**
	 * 处理后废水去向
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String handleWhereabouts;
	/**
	 * 年运行小时
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String annualoPeratingHours;

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
	 * 设置：设施名称
	 */
	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}
	/**
	 * 获取：设施名称
	 */
	public String getMeasureName() {
		return measureName;
	}
	/**
	 * 设置：对应排污口
	 */
	public void setBlowdownOutlet(String blowdownOutlet) {
		this.blowdownOutlet = blowdownOutlet;
	}
	/**
	 * 获取：对应排污口
	 */
	public String getBlowdownOutlet() {
		return blowdownOutlet;
	}
	/**
	 * 设置：规格型号
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * 获取：规格型号
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 设置：处理工艺
	 */
	public void setProcess(String process) {
		this.process = process;
	}
	/**
	 * 获取：处理工艺
	 */
	public String getProcess() {
		return process;
	}
	/**
	 * 设置：废水类别
	 */
	public void setWastewaterCategory(String wastewaterCategory) {
		this.wastewaterCategory = wastewaterCategory;
	}
	/**
	 * 获取：废水类别
	 */
	public String getWastewaterCategory() {
		return wastewaterCategory;
	}
	/**
	 * 设置：主要去除物质
	 */
	public void setRemovalOfMaterial(String removalOfMaterial) {
		this.removalOfMaterial = removalOfMaterial;
	}
	/**
	 * 获取：主要去除物质
	 */
	public String getRemovalOfMaterial() {
		return removalOfMaterial;
	}
	/**
	 * 设置：总投资额（万元）
	 */
	public void setTotalInvestment(Double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}
	/**
	 * 获取：总投资额（万元）
	 */
	public Double getTotalInvestment() {
		return totalInvestment;
	}
	/**
	 * 设置：投运日期
	 */
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	/**
	 * 获取：投运日期
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * 设置：设计处理能力（吨/天）
	 */
	public void setProcessingCapacity(Double processingCapacity) {
		this.processingCapacity = processingCapacity;
	}
	/**
	 * 获取：设计处理能力（吨/天）
	 */
	public Double getProcessingCapacity() {
		return processingCapacity;
	}
	/**
	 * 设置：实际处理能力（吨/天）
	 */
	public void setActualProcessing(Double actualProcessing) {
		this.actualProcessing = actualProcessing;
	}
	/**
	 * 获取：实际处理能力（吨/天）
	 */
	public Double getActualProcessing() {
		return actualProcessing;
	}
	/**
	 * 设置：运行状态
	 */
	public void setRunningState(String runningState) {
		this.runningState = runningState;
	}
	/**
	 * 获取：运行状态
	 */
	public String getRunningState() {
		return runningState;
	}
	/**
	 * 设置：年处理量（吨）
	 */
	public void setYearThroughput(Double yearThroughput) {
		this.yearThroughput = yearThroughput;
	}
	/**
	 * 获取：年处理量（吨）
	 */
	public Double getYearThroughput() {
		return yearThroughput;
	}
	/**
	 * 设置：年运行费用（万元）
	 */
	public void setYearOperatingCost(Double yearOperatingCost) {
		this.yearOperatingCost = yearOperatingCost;
	}
	/**
	 * 获取：年运行费用（万元）
	 */
	public Double getYearOperatingCost() {
		return yearOperatingCost;
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

	public String getSingleDesignCapability() {
		return singleDesignCapability;
	}

	public void setSingleDesignCapability(String singleDesignCapability) {
		this.singleDesignCapability = singleDesignCapability;
	}

	public String getDayRuntime() {
		return dayRuntime;
	}

	public void setDayRuntime(String dayRuntime) {
		this.dayRuntime = dayRuntime;
	}

	public String getGovernanceLimit() {
		return governanceLimit;
	}

	public void setGovernanceLimit(String governanceLimit) {
		this.governanceLimit = governanceLimit;
	}

	public String getAcceptanceOpinion() {
		return acceptanceOpinion;
	}

	public void setAcceptanceOpinion(String acceptanceOpinion) {
		this.acceptanceOpinion = acceptanceOpinion;
	}


	public String getHandleOtherUnitwater() {
		return handleOtherUnitwater;
	}

	public void setHandleOtherUnitwater(String handleOtherUnitwater) {
		this.handleOtherUnitwater = handleOtherUnitwater;
	}

	public String getAirtightSituation() {
		return airtightSituation;
	}

	public void setAirtightSituation(String airtightSituation) {
		this.airtightSituation = airtightSituation;
	}

	public String getHandleWhereabouts() {
		return handleWhereabouts;
	}

	public void setHandleWhereabouts(String handleWhereabouts) {
		this.handleWhereabouts = handleWhereabouts;
	}

	public String getAnnualoPeratingHours() {
		return annualoPeratingHours;
	}

	public void setAnnualoPeratingHours(String annualoPeratingHours) {
		this.annualoPeratingHours = annualoPeratingHours;
	}
}
