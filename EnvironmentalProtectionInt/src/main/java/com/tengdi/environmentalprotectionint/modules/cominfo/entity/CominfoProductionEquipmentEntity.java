package com.tengdi.environmentalprotectionint.modules.cominfo.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;
import java.util.Date;

/**
 * 生产设备
 * 
 * @author tengdi
 * @email 
 * @date 2018-08-02 17:42:48
 */
@TableName("cominfo_production_equipment")
public class CominfoProductionEquipmentEntity implements Serializable {
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
	 * 设备名称
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String equipmentName;
	/**
	 * 设备车间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String equipmentWorkshop;
	/**
	 * 设备型号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String equipmentModel;
	/**
	 * 数量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer number;
	/**
	 * 单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String unit;
	/**
	 * 设备使用情况
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String equipmentUsage;
	/**
	 * 创建时间
	 */
	private Date createdate;
	/**
	 * 修改时间
	 */
	private Date updatedate;
	/**
	 * 删除时间
	 */
	private Date deletedate;

	/**
	 * 备注
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String remarks;

	/**
	 * 设备编号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String equipmentCode;

	/**
	 * 设备类型
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer equipmentType;

	/**
	 * 设备类型name
	 */
	@TableField(exist = false)
	private String equipmentTypeName;


	/**
	 * 设备用途
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String equipmentUse;
	/**
	 * 设备规模
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String equipmentScale;

	/**
	 * 规模计量单位
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String equipmentScaleUnit;

	/**
	 * 生产工艺
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer productionProcess;

	/**
	 * 生产工艺name
	 */
	@TableField(exist = false)
	private String productionProcessName;
	/**
	 * 设备容量（高度）
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String equipmentCapacity;

	/**
	 * 对应机组编号
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String crewCode;

	/**
	 * 对应机组装机容量
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String crewCapacity;

	/**
	 * 是否热电联产
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer isCogeneration;
	/**
	 * 是否热电联产name
	 */
	@TableField(exist = false)
	private String isCogenerationName;

	public String getIsCogenerationName() {
		return isCogenerationName;
	}

	public void setIsCogenerationName(String isCogenerationName) {
		this.isCogenerationName = isCogenerationName;
	}

	/**
	 * 处理方式
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer processingMode;
	/**
	 * 处理方式name
	 */
	@TableField(exist = false)
	private String processingModeName;

	public String getEquipmentTypeName() {
		return equipmentTypeName;
	}

	public void setEquipmentTypeName(String equipmentTypeName) {
		this.equipmentTypeName = equipmentTypeName;
	}

	public String getProductionProcessName() {
		return productionProcessName;
	}

	public void setProductionProcessName(String productionProcessName) {
		this.productionProcessName = productionProcessName;
	}

	public String getProcessingModeName() {
		return processingModeName;
	}

	public void setProcessingModeName(String processingModeName) {
		this.processingModeName = processingModeName;
	}

	public String getEquipmentClassifyName() {
		return equipmentClassifyName;
	}

	public void setEquipmentClassifyName(String equipmentClassifyName) {
		this.equipmentClassifyName = equipmentClassifyName;
	}

	/**
	 * 额定出力
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String ratedOutput;

	/**
	 * 热效率
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String thermalEfficiency;

	/**
	 * 平均温度
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String aveTemperature;

	/**
	 * 运行时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String runningHours;

	/**
	 * 年生产时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String annualProductionHours;

	/**
	 * 产能
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String capacity;
	/**
	 * 设备分类
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer equipmentClassify;
	/**
	 * 设备分类name
	 */
	@TableField(exist = false)
	private String equipmentClassifyName;

	public Integer getEquipmentClassify() {
		return equipmentClassify;
	}

	public void setEquipmentClassify(Integer equipmentClassify) {
		this.equipmentClassify = equipmentClassify;
	}

	public String getEquipmentCode() {
		return equipmentCode;
	}

	public void setEquipmentCode(String equipmentCode) {
		this.equipmentCode = equipmentCode;
	}

	public Integer getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(Integer equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getEquipmentUse() {
		return equipmentUse;
	}

	public void setEquipmentUse(String equipmentUse) {
		this.equipmentUse = equipmentUse;
	}

	public String getEquipmentScale() {
		return equipmentScale;
	}

	public void setEquipmentScale(String equipmentScale) {
		this.equipmentScale = equipmentScale;
	}

	public String getEquipmentScaleUnit() {
		return equipmentScaleUnit;
	}

	public void setEquipmentScaleUnit(String equipmentScaleUnit) {
		this.equipmentScaleUnit = equipmentScaleUnit;
	}

	public Integer getProductionProcess() {
		return productionProcess;
	}

	public void setProductionProcess(Integer productionProcess) {
		this.productionProcess = productionProcess;
	}

	public String getEquipmentCapacity() {
		return equipmentCapacity;
	}

	public void setEquipmentCapacity(String equipmentCapacity) {
		this.equipmentCapacity = equipmentCapacity;
	}

	public String getCrewCode() {
		return crewCode;
	}

	public void setCrewCode(String crewCode) {
		this.crewCode = crewCode;
	}

	public String getCrewCapacity() {
		return crewCapacity;
	}

	public void setCrewCapacity(String crewCapacity) {
		this.crewCapacity = crewCapacity;
	}

	public Integer getIsCogeneration() {
		return isCogeneration;
	}

	public void setIsCogeneration(Integer isCogeneration) {
		this.isCogeneration = isCogeneration;
	}

	public Integer getProcessingMode() {
		return processingMode;
	}

	public void setProcessingMode(Integer processingMode) {
		this.processingMode = processingMode;
	}

	public String getRatedOutput() {
		return ratedOutput;
	}

	public void setRatedOutput(String ratedOutput) {
		this.ratedOutput = ratedOutput;
	}

	public String getThermalEfficiency() {
		return thermalEfficiency;
	}

	public void setThermalEfficiency(String thermalEfficiency) {
		this.thermalEfficiency = thermalEfficiency;
	}

	public String getAveTemperature() {
		return aveTemperature;
	}

	public void setAveTemperature(String aveTemperature) {
		this.aveTemperature = aveTemperature;
	}

	public String getRunningHours() {
		return runningHours;
	}

	public void setRunningHours(String runningHours) {
		this.runningHours = runningHours;
	}

	public String getAnnualProductionHours() {
		return annualProductionHours;
	}

	public void setAnnualProductionHours(String annualProductionHours) {
		this.annualProductionHours = annualProductionHours;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
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
	 * 设置：设备名称
	 */
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	/**
	 * 获取：设备名称
	 */
	public String getEquipmentName() {
		return equipmentName;
	}
	/**
	 * 设置：设备车间
	 */
	public void setEquipmentWorkshop(String equipmentWorkshop) {
		this.equipmentWorkshop = equipmentWorkshop;
	}
	/**
	 * 获取：设备车间
	 */
	public String getEquipmentWorkshop() {
		return equipmentWorkshop;
	}
	/**
	 * 设置：设备型号
	 */
	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}
	/**
	 * 获取：设备型号
	 */
	public String getEquipmentModel() {
		return equipmentModel;
	}
	/**
	 * 设置：数量
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	/**
	 * 获取：数量
	 */
	public Integer getNumber() {
		return number;
	}
	/**
	 * 设置：单位
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：单位
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 设置：设备使用情况
	 */
	public void setEquipmentUsage(String equipmentUsage) {
		this.equipmentUsage = equipmentUsage;
	}
	/**
	 * 获取：设备使用情况
	 */
	public String getEquipmentUsage() {
		return equipmentUsage;
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
	 * 设置：修改时间
	 */
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdatedate() {
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
